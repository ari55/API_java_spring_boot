/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ecommerce.apiMenuio.managers;

import com.ecommerce.apiMenuio.entities.Serveur;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author aissata
 */
@Repository
public interface ServerManager extends JpaRepository<Serveur, Integer> {

    Boolean existsByEmail(String email);

    Optional<Serveur> findById(Integer id);

    List<Serveur> findByIdrestaurant(Integer idresto);

}
