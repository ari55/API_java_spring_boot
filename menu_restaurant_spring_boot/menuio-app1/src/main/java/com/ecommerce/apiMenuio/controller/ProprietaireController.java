/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ecommerce.apiMenuio.controller;

import com.ecommerce.apiMenuio.security.JwtResponse;
import com.ecommerce.apiMenuio.security.LoginForm;
import com.ecommerce.apiMenuio.entities.Proprietaire;
import com.ecommerce.apiMenuio.managers.ProprietaireManager;
import java.net.URI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;

import com.ecommerce.apiMenuio.security.jwt.JwtProvider;
import java.util.Optional;
import javax.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author aissata
 */
@RestController
@CrossOrigin
public class ProprietaireController {
    
    @Autowired
    private ProprietaireManager pManager;
    
    @Autowired
    private PasswordEncoder passwordEncoder;
    
    @Autowired
    private AuthenticationManager authenticationManager;
    
    @Autowired
    JwtProvider jwtProvider;
        @CrossOrigin
    @PostMapping(value = "/inscription/proprietaire")
    public ResponseEntity<String> addProprietaire(@RequestBody Proprietaire p) {
        String encryptedPassword = passwordEncoder.encode(p.getPasswords());
        p.setPasswords(encryptedPassword);
        /*if (pAdded == null) {
            return ResponseEntity.noContent().build();
        } else {
            //ResponseEntity.created().build();
            URI location = ServletUriComponentsBuilder
                    .fromCurrentRequest()
                    .path("/{id}")
                    .buildAndExpand(pAdded.getId())
                    .toUri();
            return ResponseEntity.created(location).build();
        }*/
        
        if(pManager.existsByEmail(p.getEmail())) {
            return new ResponseEntity<String>("Echec -> Email déjà utilisé par un autre utilisateur!",
                    HttpStatus.BAD_REQUEST);
        }else{
            Proprietaire pAdded = pManager.save(p);
            if (pAdded == null){
                return ResponseEntity.noContent().build();
            }else{
                return ResponseEntity.ok().body("Utilisateur ajouté avec succès !!!");
            }
        }      
       
    }

    ////
        @CrossOrigin

    @PostMapping(value = "/connexion")
    public ResponseEntity<Optional<Proprietaire>> authenticateUser(@RequestBody LoginForm loginRequest ,final HttpServletResponse response) {
        
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.getEmail(),
                        loginRequest.getPasswords()
                )
        );
        Optional<Proprietaire> p = pManager.findByEmail(loginRequest.getEmail());
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtProvider.generateJwtToken(authentication);
                   response.addHeader("token", jwt );

        return ResponseEntity.ok().body(p);
    }
        @CrossOrigin
    @GetMapping(value="/id/{id}")
    public Optional<Proprietaire> getUserById(@PathVariable int id) {
        return pManager.findById(id);
    }
    @CrossOrigin
    @GetMapping(value="/email/{email}")
    public Optional<Proprietaire> getUserByemail(@PathVariable String email) {
        return pManager.findByEmail(email);
    }
}
