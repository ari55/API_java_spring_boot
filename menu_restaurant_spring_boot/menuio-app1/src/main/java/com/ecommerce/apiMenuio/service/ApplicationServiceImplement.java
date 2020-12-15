/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ecommerce.apiMenuio.service;

import com.ecommerce.apiMenuio.entities.Produit;
import com.ecommerce.apiMenuio.managers.ProduitManager;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author ateubohk
 */

 @Service
public class ApplicationServiceImplement implements ApplicationService {
@Autowired
	ProduitManager produitManager;
 @Transactional    
public Produit createProduit(Produit employee) {
		return produitManager.save(employee);
    }

 @Transactional  
 public List<Produit> getAllProduits() {
		return produitManager.findAll();
    }
    
}
