/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ecommerce.apiMenuio.managers;

import com.ecommerce.apiMenuio.entities.Template;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author ateubohk
 */
public interface TemplateManager extends JpaRepository<Template, Integer> {
        Boolean existsByNom(String nom);

}
