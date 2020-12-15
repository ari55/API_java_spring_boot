/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ecommerce.apiMenuio.controller;
//import org.springframework.hateoas.Link;
import org.springframework.hateoas.Link;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

/**
 *
 * @author ateubohk
 */
public class CoreController {
    protected Link createHateoasLink(long id){
        Link link = linkTo(getClass()).slash(id).withSelfRel();
        return link;
    }
}
