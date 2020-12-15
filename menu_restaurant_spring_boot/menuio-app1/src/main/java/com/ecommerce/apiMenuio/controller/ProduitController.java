/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ecommerce.apiMenuio.controller;

import com.ecommerce.apiMenuio.Exception.GlobalExceptionHandler;
import com.ecommerce.apiMenuio.Exception.ProduitIntrouvableException;
import com.ecommerce.apiMenuio.entities.AppResponse;
import com.ecommerce.apiMenuio.entities.Produit;
import com.ecommerce.apiMenuio.managers.ProduitManager;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import com.ecommerce.apiMenuio.service.ApplicationService;
import com.ecommerce.apiMenuio.service.CloudService;
import com.ecommerce.apiMenuio.service.CoudServiceInterface;
import utils.AppConstants;

/**
 *
 * @author ateubohk
 */
@RestController
public class ProduitController {

    @Autowired
    ProduitManager pManager;
    @Autowired
    ApplicationService applicationService;
    ObjectMapper objectMapper = new ObjectMapper();
    @Autowired
    CoudServiceInterface cloudService;

    @CrossOrigin
    //@PostMapping(value = "/produit")
    @RequestMapping(value = AppConstants.EMPLOYEE_URI, method = RequestMethod.POST, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public AppResponse createProduit(
            @RequestParam(value = AppConstants.EMPLOYEE_JSON_PARAM, required = true) String empJson,
            @RequestParam(required = true, value = AppConstants.EMPLOYEE_FILE_PARAM) MultipartFile file) throws JsonParseException, JsonMappingException, IOException {
        Produit employee = objectMapper.readValue(empJson, Produit.class);
        String url = cloudService.uploadfile(file);
        employee.setUrl_image(url);
        System.out.println(url);
        applicationService.createProduit(employee);
        return new AppResponse(AppConstants.SUCCESS_CODE, AppConstants.SUCCESS_MSG);

    }
@CrossOrigin

    @GetMapping(value = "/produit/{id}")
    public Optional<Produit> getProduitById(@PathVariable int id) {
        Optional<Produit> produit = pManager.findById(id);
        if (produit == null) {
            throw new ProduitIntrouvableException("Le produit avec l'id " + id + " est INTROUVABLE. ");
        }
        return produit;
    }

    @CrossOrigin
    @GetMapping(value = "/produits/{id}")
    public List<Produit> getAllProductsByResto(@PathVariable int id) {
        List<Produit> produits = pManager.findByIdMenu(id);
        return produits;
    }

    
//Toutes les infos de tous les produits par categorie
    @CrossOrigin

    @GetMapping(value = "/produitbycategorie/{id}")
    public List<Produit> getProduitByIdCategorie(@PathVariable int id) {
        List<Produit> produits = pManager.findByIdCategorie(id);
        return produits;
    }

    //Modifier un produit
    @CrossOrigin

    @PutMapping(value = "/produit/{id}")
    public ResponseEntity<Produit> updateProduit(@PathVariable(value = "id") int id,
            @Validated @RequestBody Produit produitDetails) {
        Produit produit = pManager.findById(id)
                .orElseThrow(() -> new GlobalExceptionHandler("Produit not found for this id :: " + id));

        produit.setNom(produitDetails.getNom());
        produit.setPrix(produitDetails.getPrix());
        produit.setUrl_image(produitDetails.getUrl_image());
        produit.setDescription(produitDetails.getDescription());
        produit.setIdCategorie(produitDetails.getIdCategorie());

        final Produit updatedProduit = pManager.save(produit);
        return ResponseEntity.ok(updatedProduit);
    }
    
    //Supprimer un produit
    @CrossOrigin

    @DeleteMapping(value = "/produits/{id}")
    public void deleteProduit(@PathVariable int id) {
        pManager.deleteById(id);
    }

}
