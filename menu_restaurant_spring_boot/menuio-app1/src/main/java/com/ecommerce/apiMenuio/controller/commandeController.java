/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ecommerce.apiMenuio.controller;

import com.ecommerce.apiMenuio.Exception.ProduitIntrouvableException;
import com.ecommerce.apiMenuio.entities.Commande;
import com.ecommerce.apiMenuio.entities.LigneDeCommande;
import com.ecommerce.apiMenuio.entities.OrderProductDto;
import com.ecommerce.apiMenuio.service.CommandeSercice;
import com.ecommerce.apiMenuio.service.LigneCommandeService;
import com.ecommerce.apiMenuio.service.ProduitService;
import com.sun.istack.NotNull;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

/**
 *
 * @author ateubohk
 */
@RestController
public class commandeController extends CoreController {

    @Autowired
    CommandeSercice commandeSercice;
    LigneCommandeService ligneCommandeService;
    ProduitService produitService;

    public commandeController(CommandeSercice commandeSercice, LigneCommandeService ligneCommandeService, ProduitService produitService) {
        this.commandeSercice = commandeSercice;
        this.ligneCommandeService = ligneCommandeService;
        this.produitService = produitService;
    }

    
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public @NotNull
    Iterable<Commande> list() {
        return this.commandeSercice.getAllOrders();
    }

    @PostMapping
    public ResponseEntity<Commande> create(@RequestBody OrderForm form) {
        List<OrderProductDto> formDtos = form.getProductOrders();
        validateProductsExistence(formDtos);
        Commande order = new Commande();
       // order.setStatus(OrderStatus.PAID.name());
        order = this.commandeSercice.create(order);

        List<LigneDeCommande> orderProducts = new ArrayList<>();
        for (OrderProductDto dto : formDtos) {
            orderProducts.add(ligneCommandeService.create(new LigneDeCommande(order, produitService.getProduct(dto.getProduct().getId()), dto.getQuantite())));
        }

        order.setItems(orderProducts);

        this.commandeSercice.update(order);

        String uri = ServletUriComponentsBuilder
          .fromCurrentServletMapping()
          .path("/orders/{id}")
          .buildAndExpand(order.getId())
          .toString();
        HttpHeaders headers = new HttpHeaders();
        headers.add("Location", uri);

        return new ResponseEntity<>(order, headers, HttpStatus.CREATED);
    }
    
    
    
    private void validateProductsExistence(List<OrderProductDto> orderProducts) {
        List<OrderProductDto> list = orderProducts
          .stream()
          .filter(op -> Objects.isNull(produitService.getProduct(op
            .getProduct()
            .getId())))
          .collect(Collectors.toList());

        if (!CollectionUtils.isEmpty(list)) {
            new ProduitIntrouvableException("Product not found");
        }
    }

    
    public static class OrderForm {

        private List<OrderProductDto> productOrders;

        public List<OrderProductDto> getProductOrders() {
            return productOrders;
        }

        public void setProductOrders(List<OrderProductDto> productOrders) {
            this.productOrders = productOrders;
        }
    }
}
