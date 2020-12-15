/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ecommerce.apiMenuio.managers;

import com.ecommerce.apiMenuio.entities.Produit;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author aissata
 */
@Repository
public interface ProduitManager extends JpaRepository<Produit, Integer>{
    //Produit findById(int id);
    
    List<Produit> findByIdCategorie(int idCategorie);
    
    List<Produit> findByIdMenu(int idMenu);
}
