/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ecommerce.apiMenuio.service;

import com.ecommerce.apiMenuio.Exception.ProduitIntrouvableException;
import com.ecommerce.apiMenuio.entities.Produit;
import com.ecommerce.apiMenuio.managers.ProduitManager;
import javax.transaction.Transactional;
import org.springframework.stereotype.Service;

/**
 *
 * @author ateubohk
 */

@Service
@Transactional
public class ProduitServiceImplement implements  ProduitService{

        private ProduitManager productRepository;

    public ProduitServiceImplement(ProduitManager productRepository) {
        this.productRepository = productRepository;
    }

        
    @Override
    public Iterable<Produit> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Produit getProduct(int id) {
 return productRepository
          .findById(id)
          .orElseThrow(() -> new ProduitIntrouvableException("Product not found"));    }

    @Override
    public Produit save(Produit product) {
        return productRepository.save(product);
    }
    
}
