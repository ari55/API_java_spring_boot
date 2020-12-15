/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ecommerce.apiMenuio.entities;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author ateubohk
 */
@Table(name = "ligneCommande ")
@Entity
public class LigneDeCommande implements Serializable {
    private int id;
    //@JoinTable(name = "produit", joinColumns = @JoinColumn(name = "id"))
    private Produit id_produit;
    private int quantite;
    private String description_du_client;
    //@JoinTable(name = "commande", joinColumns = @JoinColumn(name = "id"))
    private Commande id_commande;

    public LigneDeCommande(Commande id_commande,Produit id_produit, int quantite) {
        this.id_produit = id_produit;
        this.quantite = quantite;
        this.id_commande = id_commande;
    }

    public LigneDeCommande(int id, Produit id_produit, int quantite, String description_du_client, Commande id_commande) {
        this.id = id;
        this.id_produit = id_produit;
        this.quantite = quantite;
        this.description_du_client = description_du_client;
        this.id_commande = id_commande;
    }
@ManyToOne
    @JoinColumn(name = "id_produit")
    public Produit getId_produit() {
        return id_produit;
    }

    public void setId_produit(Produit id_produit) {
        this.id_produit = id_produit;
    }
@ManyToOne
    @JoinColumn(name = "commande_id")
    public Commande getId_commande() {
        return id_commande;
    }

    public void setId_commande(Commande id_commande) {
        this.id_commande = id_commande;
    }

    

    public LigneDeCommande() {
    }
 @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

//    public int getId_produit() {
//        return id_produit;
//    }
//
//    public void setId_produit(int id_produit) {
//        this.id_produit = id_produit;
//    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public String getDescription_du_client() {
        return description_du_client;
    }

    public void setDescription_du_client(String description_du_client) {
        this.description_du_client = description_du_client;
    }

//    public int getId_commande() {
//        return id_commande;
//    }
//
//    public void setId_commande(int id_commande) {
//        this.id_commande = id_commande;
//    }

   

    
}
