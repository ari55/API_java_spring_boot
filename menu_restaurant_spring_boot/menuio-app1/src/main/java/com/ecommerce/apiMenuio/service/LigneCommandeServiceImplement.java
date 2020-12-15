/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ecommerce.apiMenuio.service;

import com.ecommerce.apiMenuio.entities.LigneDeCommande;
import com.ecommerce.apiMenuio.managers.LigneCommandeManager;
import javax.transaction.Transactional;
import org.springframework.stereotype.Service;

/**
 *
 * @author ateubohk
 */
@Service
@Transactional
public class LigneCommandeServiceImplement implements LigneCommandeService{
    private LigneCommandeManager orderProductRepository;

    public LigneCommandeServiceImplement(LigneCommandeManager orderProductRepository) {
        this.orderProductRepository = orderProductRepository;
    }

    
    @Override
    public LigneDeCommande create(LigneDeCommande orderProduct) {
        return this.orderProductRepository.save(orderProduct);
    }
    
}
