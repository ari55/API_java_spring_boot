/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ecommerce.apiMenuio.controller;

import com.ecommerce.apiMenuio.entities.Menu;
import com.ecommerce.apiMenuio.managers.MenuManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author ateubohk
 */
@RestController
public class MenuController {
    @Autowired
   private MenuManager menuManager;
    @CrossOrigin
    @PostMapping(value="/menu")
    public ResponseEntity<String> ajoutMenu(@RequestBody Menu menu) {
         Menu nouveauMenu = menuManager.save(menu);
            if (nouveauMenu != null) {
                return ResponseEntity.ok().body("menu ajouté !!");
            } else {
                return ResponseEntity.noContent().build();
            }
    
    }
}
