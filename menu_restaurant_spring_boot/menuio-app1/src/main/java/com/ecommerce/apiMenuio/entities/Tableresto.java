/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ecommerce.apiMenuio.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import org.hibernate.annotations.Columns;

/**
 *
 * @author aissata
 */
@Entity
//JsonIgnoreProperties(value={"id", "id_restaurant"})
public class Tableresto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)        
    private int id;
    private String numeroTable;
    @JoinTable(name="restaurant", joinColumns = @JoinColumn(name="id"))
    @Column(name="id_restaurant")
    private int idRestaurant;

    public Tableresto() {
    }

    public Tableresto(int id, String numero_table, int id_restaurant) {
        this.id = id;
        this.numeroTable = numero_table;
        this.idRestaurant = id_restaurant;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumero_table() {
        return numeroTable;
    }

    public void setNumero_table(String numero_table) {
        this.numeroTable = numero_table;
    }

    public int getIdRestaurant() {
        return idRestaurant;
    }

    public void setIdRestaurant(int id_restaurant) {
        this.idRestaurant = id_restaurant;
    }

    @Override
    public String toString() {
        return "Tableresto{" + "id=" + id + ", numeroTable=" + numeroTable + ", id_restaurant=" + idRestaurant + '}';
    }

    
}
