/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ecommerce.apiMenuio.controller;

import com.ecommerce.apiMenuio.Exception.GlobalExceptionHandler;
import com.ecommerce.apiMenuio.entities.Tableresto;
import com.ecommerce.apiMenuio.managers.TableRestoManager;
import java.util.List;
import java.util.Optional;
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
 * @author aissata
 */
@RestController
public class TableRestoController {
    
    @Autowired
    TableRestoManager tableManager;
    @CrossOrigin

    @PostMapping(value="/inscription/table")
    public ResponseEntity<String> addTable(@RequestBody Tableresto table){
        if (tableManager.existsByNumeroTable(table.getNumero_table())){
            return new ResponseEntity<String>("Echec -> Numéro de table déjà existant!",
                    HttpStatus.BAD_REQUEST);
        }else{
            Tableresto tableAdded = tableManager.save(table);
            
            if (tableAdded == null){
                return ResponseEntity.noContent().build();
            }else{
                return ResponseEntity.ok().body("Numéro de table ajouté avec succès !!!");
            }
        }
    }
    
    //Afficher tous les numéros de tables
    @CrossOrigin

    @GetMapping(value="/numeros/{id}")
    public List<Tableresto> getTableByRestoId(@PathVariable int id) {
        return tableManager.findByIdRestaurant(id);
    }
    
    //Modifier le numéro d'une table
    @CrossOrigin

    @PutMapping(value = "/numero/{id}")
    public ResponseEntity<Tableresto> updateTable(@PathVariable(value = "id") int id,
            @Validated @RequestBody Tableresto tableDetails) {
        Tableresto table = tableManager.findById(id)
                .orElseThrow(() -> new GlobalExceptionHandler("Table not found for this id :: " + id));

        table.setNumero_table(tableDetails.getNumero_table());

        final Tableresto updatedTable = tableManager.save(table);
        return ResponseEntity.ok(updatedTable);
    }
}
