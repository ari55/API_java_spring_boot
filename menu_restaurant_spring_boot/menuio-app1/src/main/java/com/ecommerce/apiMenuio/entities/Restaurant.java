/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ecommerce.apiMenuio.entities;

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
public class Restaurant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nom;
    private String email;
    private String addresse;
    private int nombre_table;
    private String url_logo;
    private String url_qr_code;
    @JoinTable(name="proprietaire", joinColumns = @JoinColumn(name="id"))
    private int idproprietaire;

    public Restaurant() {
    }

    public Restaurant(int id, String nom, String email, String addresse, int nombre_table, String url_logo, String url_qr_code, int idproprietaire) {
        this.id = id;
        this.nom = nom;
        this.email = email;
        this.addresse = addresse;
        this.nombre_table = nombre_table;
        this.url_logo = url_logo;
        this.url_qr_code = url_qr_code;
        this.idproprietaire = idproprietaire;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddresse() {
        return addresse;
    }

    public void setAddresse(String addresse) {
        this.addresse = addresse;
    }

    public int getNombre_table() {
        return nombre_table;
    }

    public void setNombre_table(int nombre_table) {
        this.nombre_table = nombre_table;
    }

    public String getUrl_logo() {
        return url_logo;
    }

    public void setUrl_logo(String url_logo) {
        this.url_logo = url_logo;
    }

    public String getUrl_qr_code() {
        return url_qr_code;
    }

    public void setUrl_qr_code(String url_qr_code) {
        this.url_qr_code = url_qr_code;
    }
    
    
    public int getIdproprietaire() {
        return idproprietaire;
    }

    public void setIdproprietaire(int idproprietaire) {
        this.idproprietaire = idproprietaire;
    }

    @Override
    public String toString() {
        return "Restaurant{" + "id=" + id + ", nom=" + nom + ", email=" + email + ", addresse=" + addresse + ", nombre_table=" + nombre_table + ", url_logo=" + url_logo + ", url_qr_code=" + url_qr_code + ", idproprietaire=" + idproprietaire + '}';
    }
    
}
