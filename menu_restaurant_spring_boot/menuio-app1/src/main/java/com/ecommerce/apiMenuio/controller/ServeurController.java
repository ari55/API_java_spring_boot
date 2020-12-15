/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ecommerce.apiMenuio.controller;

import com.ecommerce.apiMenuio.Exception.GlobalExceptionHandler;
import com.ecommerce.apiMenuio.entities.Serveur;
import com.ecommerce.apiMenuio.managers.ServerManager;
import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author aissata
 */
@RestController
public class ServeurController {

    @Autowired
    ServerManager sManager;
    @CrossOrigin
    @PostMapping(value = "/ajout/serveur")
    public ResponseEntity<String> addServer(@RequestBody Serveur s) {

        if (sManager.existsByEmail(s.getEmail())) {
            return new ResponseEntity<String>("Echec -> Email déjà utilisé par un serveur !!!",
                    HttpStatus.BAD_REQUEST);
        } else {
            Serveur sAdded = sManager.save(s);
            if (sAdded == null) {
                return ResponseEntity.noContent().build();
            } else {
                return ResponseEntity.ok().body("Produit ajouté avec succès !!!");
            }
        }

    }
    @CrossOrigin
    @GetMapping(value = "/serveur")
    List<Serveur> getAll() {
        return sManager.findAll();
    }
    @CrossOrigin
    @GetMapping(value = "/serveur/{idrestaurant}")
    public List<Serveur> getServeur(@PathVariable("idrestaurant") int se ) {
        return sManager.findByIdrestaurant(se);
   }
    @CrossOrigin
    //modifier un serveur
    @PutMapping(value = "/serveur/{id}")
    ResponseEntity<Serveur> updateServeur(@PathVariable("id") int id, @Validated @RequestBody Serveur serv) {
        Serveur s = sManager.findById(id).orElseThrow(() -> new GlobalExceptionHandler("serveur de restaurant not found on :: " + id));
        s.setNom(serv.getNom());
        s.setPrenom(serv.getPrenom());
        s.setEmail(serv.getEmail());
        s.setTelephone(serv.getTelephone());
        s.setAddresse(serv.getAddresse());
        s.setPasswords(serv.getPasswords());
        s.setDate_enregistrement(serv.getDate_enregistrement());
        s.setStatut_connexion(serv.isStatut_connexion());
        final Serveur updateServ = sManager.save(s);
        return ResponseEntity.ok(updateServ);
    }

}
