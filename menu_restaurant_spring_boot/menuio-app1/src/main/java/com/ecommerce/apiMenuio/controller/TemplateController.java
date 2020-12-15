/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ecommerce.apiMenuio.controller;

import com.ecommerce.apiMenuio.Exception.GlobalExceptionHandler;
import com.ecommerce.apiMenuio.entities.Stylemenu;
import com.ecommerce.apiMenuio.entities.Template;
import com.ecommerce.apiMenuio.managers.StyleMenuManager;
import com.ecommerce.apiMenuio.managers.TemplateManager;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
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
 * @author ateubohk
 */
@RestController
public class TemplateController {

    @Autowired
    private TemplateManager templateManager;

////Ajouter un style au menu
    ////Ajouter un template
    @CrossOrigin

    @PostMapping(value = "/ajout/template")
    public ResponseEntity<String> ajoutTemplate(@RequestBody Template template) {
         if (templateManager.existsByNom(template.getNom())){
            return new ResponseEntity<String>("Echec -> ce template existe deja!",
                    HttpStatus.BAD_REQUEST);
        }else{
        Template nouveauTemplate = templateManager.save(template);
        if (nouveauTemplate != null) {
            return ResponseEntity.ok().body("template ajouté !!");
        } else {
            return ResponseEntity.noContent().build();
        }
         }
    }
        @CrossOrigin

     @GetMapping(value = "/template")
    List<Template> getAll() {
        return templateManager.findAll();
    }

}
