/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ecommerce.apiMenuio.service;

import com.ecommerce.apiMenuio.entities.LigneDeCommande;
import org.springframework.validation.annotation.Validated;

/**
 *
 * @author ateubohk
 */
@Validated
public interface LigneCommandeService {
       LigneDeCommande create(@Validated LigneDeCommande orderProduct);
 
}
