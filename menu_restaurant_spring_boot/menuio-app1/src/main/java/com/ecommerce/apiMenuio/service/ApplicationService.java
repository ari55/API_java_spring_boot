/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ecommerce.apiMenuio.service;

import com.ecommerce.apiMenuio.entities.Produit;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author ateubohk
 */
@Service
public interface ApplicationService {
    Produit createProduit(Produit employee);

	   List<Produit> getAllProduits();
}
