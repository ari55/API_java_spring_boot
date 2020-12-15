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
public class Stylemenu {
    
  @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @JoinTable(name="template", joinColumns = @JoinColumn(name="id"))
    private int idtemplate;
    
    private String couleur_titre_navigation;
    private String couleur_titre_categorie;
    private String couleur_titre_produits;
    private String couleur_titre_logo;
    private String couleur_background_logo;
    private String couleur_background_header;
    private String couleur_background_footer;
    private String couleur_background_template;
    private String couleur_boutons;
    private String url_image_logo;
    private String url_image_menu;

    public Stylemenu() {
    }

    public Stylemenu(int id, int idtemplate, String couleur_titre_navigation, String couleur_titre_categorie, String couleur_titre_produits, String couleur_titre_logo, String couleur_background_logo, String couleur_background_header, String couleur_background_footer, String couleur_background_template, String couleur_boutons, String url_image_menu) {
        this.id = id;
        this.idtemplate = idtemplate;
        this.couleur_titre_navigation = couleur_titre_navigation;
        this.couleur_titre_categorie = couleur_titre_categorie;
        this.couleur_titre_produits = couleur_titre_produits;
        this.couleur_titre_logo = couleur_titre_logo;
        this.couleur_background_logo = couleur_background_logo;
        this.couleur_background_header = couleur_background_header;
        this.couleur_background_footer = couleur_background_footer;
        this.couleur_background_template = couleur_background_template;
        this.couleur_boutons = couleur_boutons;
        this.url_image_menu = url_image_menu;
    }

    public Stylemenu( int idtemplate, String couleur_titre_navigation, String couleur_titre_categorie, String couleur_titre_produits, String couleur_titre_logo, String couleur_background_logo, String couleur_background_header, String couleur_background_footer, String couleur_background_template, String couleur_boutons, String url_image_logo) {
        this.idtemplate = idtemplate;
        this.couleur_titre_navigation = couleur_titre_navigation;
        this.couleur_titre_categorie = couleur_titre_categorie;
        this.couleur_titre_produits = couleur_titre_produits;
        this.couleur_titre_logo = couleur_titre_logo;
        this.couleur_background_logo = couleur_background_logo;
        this.couleur_background_header = couleur_background_header;
        this.couleur_background_footer = couleur_background_footer;
        this.couleur_background_template = couleur_background_template;
        this.couleur_boutons = couleur_boutons;
        this.url_image_logo = url_image_logo;
    }

    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdtemplate() {
        return idtemplate;
    }

    public void setIdtemplate(int id_template) {
        this.idtemplate = id_template;
    }

    public String getCouleur_titre_navigation() {
        return couleur_titre_navigation;
    }

    public void setCouleur_titre_navigation(String couleur_titre_navigation) {
        this.couleur_titre_navigation = couleur_titre_navigation;
    }

    public String getCouleur_titre_categorie() {
        return couleur_titre_categorie;
    }

    public void setCouleur_titre_categorie(String couleur_titre_categorie) {
        this.couleur_titre_categorie = couleur_titre_categorie;
    }

    public String getCouleur_titre_produits() {
        return couleur_titre_produits;
    }

    public void setCouleur_titre_produits(String couleur_titre_produits) {
        this.couleur_titre_produits = couleur_titre_produits;
    }

    public String getCouleur_titre_logo() {
        return couleur_titre_logo;
    }

    public void setCouleur_titre_logo(String couleur_titre_logo) {
        this.couleur_titre_logo = couleur_titre_logo;
    }

    public String getCouleur_background_logo() {
        return couleur_background_logo;
    }

    public void setCouleur_background_logo(String couleur_background_logo) {
        this.couleur_background_logo = couleur_background_logo;
    }

    public String getCouleur_background_header() {
        return couleur_background_header;
    }

    public void setCouleur_background_header(String couleur_background_header) {
        this.couleur_background_header = couleur_background_header;
    }

    public String getCouleur_background_footer() {
        return couleur_background_footer;
    }

    public void setCouleur_background_footer(String couleur_background_footer) {
        this.couleur_background_footer = couleur_background_footer;
    }

    public String getCouleur_background_template() {
        return couleur_background_template;
    }

    public void setCouleur_background_template(String couleur_background_template) {
        this.couleur_background_template = couleur_background_template;
    }

    public String getCouleur_boutons() {
        return couleur_boutons;
    }

    public void setCouleur_boutons(String couleur_boutons) {
        this.couleur_boutons = couleur_boutons;
    }

    public String getUrl_image_logo() {
        return url_image_logo;
    }

    public void setUrl_image_logo(String url_image_logo) {
        this.url_image_logo = url_image_logo;
    }

    public String getUrl_image_menu() {
        return url_image_menu;
    }

    public void setUrl_image_menu(String url_image_menu) {
        this.url_image_menu = url_image_menu;
    }

    @Override
    public String toString() {
        return "Stylemenu{" + "id=" + id + ", idtemplate=" + idtemplate + ", couleur_titre_navigation=" + couleur_titre_navigation + ", couleur_titre_categorie=" + couleur_titre_categorie + ", couleur_titre_produits=" + couleur_titre_produits + ", couleur_titre_logo=" + couleur_titre_logo + ", couleur_background_logo=" + couleur_background_logo + ", couleur_background_header=" + couleur_background_header + ", couleur_background_footer=" + couleur_background_footer + ", couleur_background_template=" + couleur_background_template + ", couleur_boutons=" + couleur_boutons + ", url_image_logo=" + url_image_logo + ", url_image_menu=" + url_image_menu + '}';
    }

    

    

    
}

