/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ecommerce.apiMenuio.controller;

import com.ecommerce.apiMenuio.Exception.GlobalExceptionHandler;
import com.ecommerce.apiMenuio.entities.AppResponse;
import com.ecommerce.apiMenuio.entities.Produit;
import com.ecommerce.apiMenuio.entities.Stylemenu;
import com.ecommerce.apiMenuio.managers.StyleMenuManager;
import com.ecommerce.apiMenuio.service.CoudServiceInterface;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import utils.AppConstants;

/**
 *
 * @author ateubohk
 */
@RestController
public class StyleMenuContoller {

    @Autowired
    private StyleMenuManager styleMenuManager;
    @Autowired
    CoudServiceInterface cloudService;
    ////Ajouter un style au menu
    ObjectMapper objectMapper = new ObjectMapper();

    @CrossOrigin
    @PostMapping(value = "/ajout/stylemenu")
    public ResponseEntity<String> ajoutTemplate(@RequestBody Stylemenu stylemenu) {
        /* if (templateManager.existsByNom_template(template.getNom_template())) {
            return new ResponseEntity<String>("le nom de ce template existe deja", HttpStatus.NOT_ACCEPTABLE);
        } else {*/
        Stylemenu nouveauTemplate = styleMenuManager.save(stylemenu);
        if (nouveauTemplate != null) {
            return ResponseEntity.ok().body("Style ajouté !!");
        } else {
            return ResponseEntity.noContent().build();
        }
    }
//modifier un style_menu

    @CrossOrigin
    @PutMapping(value = "style/{id}")
    ResponseEntity<Stylemenu> updateTemplate(@PathVariable("id") int id, @Validated @RequestBody Stylemenu templ) {
        Stylemenu t = styleMenuManager.findById(id).orElseThrow(() -> new GlobalExceptionHandler("template not found on :: " + id));
        t.setCouleur_titre_navigation(templ.getCouleur_titre_navigation());
        t.setCouleur_titre_categorie(templ.getCouleur_titre_categorie());
        t.setCouleur_titre_produits(templ.getCouleur_titre_produits());
        t.setCouleur_titre_logo(templ.getCouleur_titre_logo());
        t.setCouleur_background_logo(templ.getCouleur_background_logo());
        t.setCouleur_background_header(templ.getCouleur_background_header());
        t.setCouleur_background_footer(templ.getCouleur_background_footer());
        t.setCouleur_background_template(templ.getCouleur_background_template());
        t.setCouleur_boutons(templ.getCouleur_boutons());
        t.setUrl_image_logo(templ.getUrl_image_logo());
        t.setUrl_image_menu(templ.getUrl_image_menu());

        final Stylemenu updateTempl = styleMenuManager.save(t);
        return ResponseEntity.ok(updateTempl);
    }

    @CrossOrigin
        @RequestMapping(value = "/stylemenu/{id}", method = RequestMethod.PUT, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<Stylemenu> updateOne(@PathVariable("id") int id,
            @RequestParam(value = AppConstants.EMPLOYEE_JSON_PARAM, required = true) String empJson,
            @RequestParam(required = true, value = AppConstants.EMPLOYEE_FILE_PARAM_ONE) MultipartFile fileone) throws JsonParseException, JsonMappingException, IOException {
        Stylemenu t = styleMenuManager.findById(id).orElseThrow(() -> new GlobalExceptionHandler("template not found on :: " + id));
        Stylemenu emp = objectMapper.readValue(empJson, Stylemenu.class);
        String url = cloudService.uploadfile(fileone);
        t.setCouleur_titre_navigation(emp.getCouleur_titre_navigation());
        t.setCouleur_titre_categorie(emp.getCouleur_titre_categorie());
        t.setCouleur_titre_produits(emp.getCouleur_titre_produits());
        t.setCouleur_titre_logo(emp.getCouleur_titre_logo());
        t.setCouleur_background_logo(emp.getCouleur_background_logo());
        t.setCouleur_background_header(emp.getCouleur_background_header());
        t.setCouleur_background_footer(emp.getCouleur_background_footer());
        t.setCouleur_background_template(emp.getCouleur_background_template());
        t.setCouleur_boutons(emp.getCouleur_boutons());
        t.setUrl_image_logo(url);
       /* t.setUrl_image_menu(emp.getUrl_image_menu());*/
        final Stylemenu updateTempl = styleMenuManager.saveAndFlush(t);
        return ResponseEntity.ok(updateTempl);
    }
    
    @CrossOrigin
        @RequestMapping(value = "/lestylemenu/{id}", method = RequestMethod.PUT, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<Stylemenu> updateStyle(@PathVariable("id") int id,
            @RequestParam(value = AppConstants.EMPLOYEE_JSON_PARAM, required = true) String empJson
           ) throws JsonParseException, JsonMappingException, IOException {
        Stylemenu t = styleMenuManager.findById(id).orElseThrow(() -> new GlobalExceptionHandler("template not found on :: " + id));
        Stylemenu emp = objectMapper.readValue(empJson, Stylemenu.class);
        //String url = cloudService.uploadfile(fileone);
        t.setCouleur_titre_navigation(emp.getCouleur_titre_navigation());
        t.setCouleur_titre_categorie(emp.getCouleur_titre_categorie());
        t.setCouleur_titre_produits(emp.getCouleur_titre_produits());
        t.setCouleur_titre_logo(emp.getCouleur_titre_logo());
        t.setCouleur_background_logo(emp.getCouleur_background_logo());
        t.setCouleur_background_header(emp.getCouleur_background_header());
        t.setCouleur_background_footer(emp.getCouleur_background_footer());
        t.setCouleur_background_template(emp.getCouleur_background_template());
        t.setCouleur_boutons(emp.getCouleur_boutons());
        t.setUrl_image_logo(emp.getUrl_image_logo());
        t.setUrl_image_menu(emp.getUrl_image_menu());
        final Stylemenu updateTempl = styleMenuManager.saveAndFlush(t);
        return ResponseEntity.ok(updateTempl);
    }
    
    
    @CrossOrigin
    //@PostMapping(value = "/produit")
    @RequestMapping(value = "/stylemenutwo/{id}", method = RequestMethod.PUT, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<Stylemenu> updateTwo(@PathVariable("id") int id,
            @RequestParam(value = AppConstants.EMPLOYEE_JSON_PARAM, required = true) String empJson,
            @RequestParam(required = true, value = AppConstants.EMPLOYEE_FILE_PARAM_TWO) MultipartFile filetwo) throws JsonParseException, JsonMappingException, IOException {

        Stylemenu t = styleMenuManager.findById(id).orElseThrow(() -> new GlobalExceptionHandler("template not found on :: " + id));
        Stylemenu emp = objectMapper.readValue(empJson, Stylemenu.class);
        String url = cloudService.uploadfile(filetwo);
        t.setCouleur_titre_navigation(emp.getCouleur_titre_navigation());
        t.setCouleur_titre_categorie(emp.getCouleur_titre_categorie());
        t.setCouleur_titre_produits(emp.getCouleur_titre_produits());
        t.setCouleur_titre_logo(emp.getCouleur_titre_logo());
        t.setCouleur_background_logo(emp.getCouleur_background_logo());
        t.setCouleur_background_header(emp.getCouleur_background_header());
        t.setCouleur_background_footer(emp.getCouleur_background_footer());
        t.setCouleur_background_template(emp.getCouleur_background_template());
        t.setCouleur_boutons(emp.getCouleur_boutons());
      /*  t.setUrl_image_logo(emp);*/
        t.setUrl_image_menu(url);
        final Stylemenu updateTempl = styleMenuManager.saveAndFlush(t);
        return ResponseEntity.ok(updateTempl);
    }

    @CrossOrigin
    @GetMapping(value = "/stylemenu/{idtemplate}")
    public List<Stylemenu> getStylemenu(@PathVariable("idtemplate") int se) {
        return styleMenuManager.findByIdtemplate(se);
    }

}
