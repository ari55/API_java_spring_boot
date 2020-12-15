/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ecommerce.apiMenuio.managers;

import com.ecommerce.apiMenuio.entities.Categorie;
import java.util.Optional;
import org.hibernate.metamodel.model.convert.spi.JpaAttributeConverter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author ateubohk
 */
@Repository
public interface CategorieManager extends JpaRepository <Categorie, Integer> {
     /* @Modifying
    @Query("delete from categorie c where c.id = ?1")
    void deleteCategorieById(int id);*/
}
