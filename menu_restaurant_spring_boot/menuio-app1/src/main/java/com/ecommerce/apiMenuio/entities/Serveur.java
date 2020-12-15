/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ecommerce.apiMenuio.entities;

import java.util.Date;
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
public class Serveur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)       
    int id;
    String nom;
    String prenom;
    String email;
    long telephone;
    String addresse;
    String passwords;
    Date date_enregistrement;
    boolean statut_connexion;
    @JoinTable(name="restaurant", joinColumns = @JoinColumn(name = "id"))
    int idrestaurant;

    public Serveur() {
    }

    public Serveur(int id, String nom, String prenom, String email, long telephone, String addresse, String passwords, Date date_enregistrement, boolean statut_connexion, int idrestaurant) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.telephone = telephone;
        this.addresse = addresse;
        this.passwords = passwords;
        this.date_enregistrement = date_enregistrement;
        this.statut_connexion = statut_connexion;
        this.idrestaurant = idrestaurant;
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

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getTelephone() {
        return telephone;
    }

    public void setTelephone(long telephone) {
        this.telephone = telephone;
    }

    public String getAddresse() {
        return addresse;
    }

    public void setAddresse(String addresse) {
        this.addresse = addresse;
    }

    public String getPasswords() {
        return passwords;
    }

    public void setPasswords(String passwords) {
        this.passwords = passwords;
    }

    public Date getDate_enregistrement() {
        return date_enregistrement;
    }

    public void setDate_enregistrement(Date date_enregistrement) {
        this.date_enregistrement = date_enregistrement;
    }

    public boolean isStatut_connexion() {
        return statut_connexion;
    }

    public void setStatut_connexion(boolean statut_connexion) {
        this.statut_connexion = statut_connexion;
    }

    public int getIdrestaurant() {
        return idrestaurant;
    }

    public void setIdrestaurant(int id_restaurant) {
        this.idrestaurant = id_restaurant;
    }

    @Override
    public String toString() {
        return "Serveur{" + "id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", email=" + email + ", telephone=" + telephone + ", addresse=" + addresse + ", passwords=" + passwords + ", date_enregistrement=" + date_enregistrement + ", statut_connexion=" + statut_connexion + ", id_restaurant=" + idrestaurant + '}';
    }
    
}
