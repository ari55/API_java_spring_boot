/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ecommerce.apiMenuio.entities;

/**
 *
 * @author ateubohk
 */
public class OrderProductDto {
    private Produit product;
    private Integer quantite;

    public Produit getProduct() {
        return product;
    }

    public void setProduct(Produit product) {
        this.product = product;
    }

    public Integer getQuantite() {
        return quantite;
    }

    public void setQuantite(Integer quantite) {
        this.quantite = quantite;
    }
    
    
}
