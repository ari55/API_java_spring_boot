/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ecommerce.apiMenuio.service;

import com.ecommerce.apiMenuio.entities.Produit;
import com.sun.istack.NotNull;
import org.springframework.validation.annotation.Validated;

/**
 *
 * @author ateubohk
 */
@Validated

public interface ProduitService {
    @NotNull Iterable<Produit> getAllProducts();

    Produit getProduct( int id);

    Produit save(Produit product);
}
