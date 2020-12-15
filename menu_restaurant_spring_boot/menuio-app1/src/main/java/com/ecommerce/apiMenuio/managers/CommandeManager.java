/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ecommerce.apiMenuio.managers;

import com.ecommerce.apiMenuio.entities.Commande;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author ateubohk
 */
public interface CommandeManager extends JpaRepository<Commande, Integer> {
    // public Commande findOneWithItems(@Param("id") Integer id);
 
}
