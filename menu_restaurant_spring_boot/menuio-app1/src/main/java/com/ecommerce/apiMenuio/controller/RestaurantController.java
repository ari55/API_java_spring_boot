/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ecommerce.apiMenuio.controller;

import com.ecommerce.apiMenuio.entities.Restaurant;
import com.ecommerce.apiMenuio.managers.RestaurantManager;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author aissata
 */
@RestController
public class RestaurantController {
    
    @Autowired
    private RestaurantManager restoManager;
    @CrossOrigin

    @PostMapping(value="/inscription/restaurant")
    public ResponseEntity<String> addRestaurant(@RequestBody Restaurant resto){
        if (restoManager.existsByEmail(resto.getEmail())){
            return new ResponseEntity<String>("Echec -> Email déjà utilisé par un autre restaurant!",
                    HttpStatus.BAD_REQUEST);
        }else{
            Restaurant restoAdded = restoManager.save(resto);
            if (restoAdded == null){
                return ResponseEntity.noContent().build();
            }else{
                return ResponseEntity.ok().body("Restaurant ajouté avec succès !!!");
            }
        }
    }
    
   /* @GetMapping(value="/restaurant/{email}")
    public Restaurant getRestaurantByEmail(@PathVariable String email){
        return restoManager.findbyEmail(email);
    }*/
      @CrossOrigin
    @GetMapping(value="/iproprio/{idproprio}")
    public Optional<Restaurant> getByIdProprio(@PathVariable int idproprio) {
        return restoManager.findByIdproprietaire(idproprio);
    } 
}
