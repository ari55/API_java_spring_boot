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

/**
 *
 * @author aissata
 */
@Entity
//@JsonIgnoreProperties(value={"id", "id_categorie", "id_menu"})
public class Produit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    String nom;
    String description;
    double prix;
    String url_image;
    @JoinTable(name="categorie", joinColumns = @JoinColumn(name="id"))
    @Column(name="id_categorie")       
    int idCategorie;
    @JoinTable(name="menu", joinColumns = @JoinColumn(name="id"))
    @Column(name="id_menu")
    int idMenu;

    public Produit() {
    }

    public Produit(int id, String nom, String description, double prix, String url_image, int id_categorie, int idMenu) {
        this.id = id;
        this.nom = nom;
        this.description = description;
        this.prix = prix;
        this.url_image = url_image;
        this.idCategorie = id_categorie;
        this.idMenu = idMenu;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public String getUrl_image() {
        return url_image;
    }

    public void setUrl_image(String url_image) {
        this.url_image = url_image;
    }

    public int getIdCategorie() {
        return idCategorie;
    }

    public void setIdCategorie(int id_categorie) {
        this.idCategorie = id_categorie;
    }

    public int getIdMenu() {
        return idMenu;
    }

    public void setIdMenu(int idMenu) {
        this.idMenu = idMenu;
    }

    @Override
    public String toString() {
        return "Produit{" + "id=" + id + ", nom=" + nom + ", description=" + description + ", prix=" + prix + ", url_image=" + url_image + ", id_categorie=" + idCategorie + ", idMenu=" + idMenu + '}';
    }   
}
