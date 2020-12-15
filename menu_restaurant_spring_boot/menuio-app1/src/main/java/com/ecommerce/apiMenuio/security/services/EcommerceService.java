/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ecommerce.apiMenuio.security.services;

import com.ecommerce.apiMenuio.entities.Commande;
import com.ecommerce.apiMenuio.managers.CommandeManager;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ateubohk
 */
@Service
public class EcommerceService {
    
    @Autowired
    CommandeManager orderRepository;
    public List<Commande> getOrders(){
        return orderRepository.findAll();
    }
   /* public Commande getOrder(int id){
        return orderRepository.findOne(id);
    }/*/
    public Commande saveOrder(Commande order){
        return orderRepository.save(order);
    }
}
