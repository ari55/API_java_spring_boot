/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ecommerce.apiMenuio.managers;

import com.ecommerce.apiMenuio.entities.Proprietaire;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author aissata
 */
@Repository
public interface ProprietaireManager extends JpaRepository<Proprietaire, Integer>{
    Optional<Proprietaire> findByEmail(String email);
    Boolean existsByEmail(String email);
       //Optional<Proprietaire> findbyNom(String nom);

}
