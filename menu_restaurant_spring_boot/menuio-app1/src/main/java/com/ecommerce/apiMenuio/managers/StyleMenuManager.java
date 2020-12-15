/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ecommerce.apiMenuio.managers;

import com.ecommerce.apiMenuio.entities.Stylemenu;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author ateubohk
 */
@Repository
public interface StyleMenuManager  extends JpaRepository<Stylemenu, Integer>{
    List<Stylemenu> findByIdtemplate(Integer idtemplate);
}
