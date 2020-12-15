/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ecommerce.apiMenuio.service;

import com.ecommerce.apiMenuio.entities.Commande;
import com.sun.istack.NotNull;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

/**
 *
 * @author ateubohk
 */
//@Service
@Validated

public interface CommandeSercice {
  @NotNull Iterable<Commande> getAllOrders();  
     Commande create( @Validated Commande order);
       void update(@Validated Commande order);

    
}
