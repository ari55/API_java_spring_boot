/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ecommerce.apiMenuio.service;

import com.ecommerce.apiMenuio.entities.Commande;
import com.ecommerce.apiMenuio.managers.CommandeManager;
import java.time.Instant;
import java.time.LocalDate;
import java.util.Date;
import javax.transaction.Transactional;
import org.springframework.stereotype.Service;

/**
 *
 * @author ateubohk
 */

@Service
@Transactional 
public class CommandeServiceImplmt implements CommandeSercice {
   
        private CommandeManager orderRepository;

    public CommandeServiceImplmt(CommandeManager orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public Iterable<Commande> getAllOrders() {
        return this.orderRepository.findAll();
    }

    @Override
    public Commande create(Commande order) {
        order.setDate_commande(Date.from(Instant.MIN));
            return this.orderRepository.save(order);

    }

    @Override
    public void update(Commande order) {
        this.orderRepository.save(order);
    }

    
    
    
}
