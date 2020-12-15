/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ecommerce.apiMenuio.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;

/**
 *
 * @author ateubohk
 */
@Entity
public class Menu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @JoinTable(name="styleMenu", joinColumns = @JoinColumn(name="id"))
    private int id_style_menu;
    @JoinTable(name="restaurant", joinColumns = @JoinColumn(name="id"))
    private int id_restaurant;

    public Menu() {
    }

    public Menu(int id, int id_style_menu, int id_restaurant) {
        this.id = id;
        this.id_style_menu = id_style_menu;
        this.id_restaurant = id_restaurant;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_style_menu() {
        return id_style_menu;
    }

    public void setId_style_menu(int id_style_menu) {
        this.id_style_menu = id_style_menu;
    }

    public int getId_restaurant() {
        return id_restaurant;
    }

    public void setId_restaurant(int id_restaurant) {
        this.id_restaurant = id_restaurant;
    }

    @Override
    public String toString() {
        return "Menu{" + "id=" + id + ", id_style_menu=" + id_style_menu + ", id_restaurant=" + id_restaurant + '}';
    }   
}
