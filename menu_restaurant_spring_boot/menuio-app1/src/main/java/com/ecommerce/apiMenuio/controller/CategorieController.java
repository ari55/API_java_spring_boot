/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ecommerce.apiMenuio.controller;

import com.ecommerce.apiMenuio.Exception.GlobalExceptionHandler;
import com.ecommerce.apiMenuio.entities.Categorie;
import com.ecommerce.apiMenuio.managers.CategorieManager;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author ateubohk
 */
@RestController
public class CategorieController {

    @Autowired
    private CategorieManager categorieManager;
@CrossOrigin
    @PostMapping(value = "/ajout/categorie")
    public ResponseEntity<String> ajoutCategorie(@RequestBody Categorie cat) {
        Categorie nouvelleCategorie = categorieManager.save(cat);
        if (nouvelleCategorie != null) {
            return ResponseEntity.ok().body("la nouvelle categorie a ete ajouté !!");
        } else {
            return ResponseEntity.noContent().build();
        }

    }
    @CrossOrigin

    @DeleteMapping(value = "/categorie/{id}")
    public ResponseEntity<Integer> deleleCategorie(@PathVariable Integer id) {
        categorieManager.deleteById(id);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }

    //modifier une categorie
        @CrossOrigin

    @PutMapping(value = "/categorie/{id}")
    ResponseEntity<Categorie> updateCategorie(@PathVariable("id") int id, @Validated @RequestBody Categorie cat) {
        Categorie c = categorieManager.findById(id).orElseThrow(() -> new GlobalExceptionHandler("categorie  not found on :: " + id));
        c.setNom(cat.getNom());
        c.setId_menu(cat.getId_menu());
        final Categorie categ = categorieManager.save(c);
        return ResponseEntity.ok(categ);
    }
@CrossOrigin
    @GetMapping(value = "/categorie")
    //ResponseEntity<Categorie> getAll(@Validated @RequestBody Categorie cat) {
    //  Categorie c = categorieManager.findAll();
    //List<Categorie> allCat = categorieManager.findAll();
    List<Categorie> getAll() {
        return categorieManager.findAll();
    }
   

}
