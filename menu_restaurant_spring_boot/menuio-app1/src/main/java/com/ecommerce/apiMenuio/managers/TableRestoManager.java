/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ecommerce.apiMenuio.managers;

import com.ecommerce.apiMenuio.entities.Tableresto;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author aissata
 */
@Repository
public interface TableRestoManager extends JpaRepository<Tableresto, Integer> {
    Boolean existsByNumeroTable(String numero_table);
    
    List<Tableresto> findByIdRestaurant(int id_restaurant);
}
