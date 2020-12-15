/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ecommerce.apiMenuio.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author ateubohk
 */
@Entity
@Table(name = "commande")
public class Commande implements Serializable {
   
    private int id;
    private boolean statut;
    private Date date_commande;
    private double prix_total;
   // @JoinTable(name = "tableresto", joinColumns = @JoinColumn(name = "id"))
    private Tableresto id_table;
    //@JoinTable(name = "serveur", joinColumns = @JoinColumn(name = "id"))
    private Serveur id_serveur;
    private List<LigneDeCommande> items = new ArrayList<LigneDeCommande>();

    public Commande() {
    }

    public Commande(int id, boolean statut, Date date_commande, double prix_total, Tableresto id_table, Serveur id_serveur) {
        this.id = id;
        this.statut = statut;
        this.date_commande = date_commande;
        this.prix_total = prix_total;
        this.id_table = id_table;
        this.id_serveur = id_serveur;
    }

    
 @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }
 //@OneToMany(mappedBy = "commande", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
   @OneToMany(fetch = FetchType.EAGER,mappedBy = "id_commande" , cascade = CascadeType.ALL)
    //@JsonManagedReference
    public List<LigneDeCommande> getItems() {
        return items;
    }

    public void setItems(List<LigneDeCommande> items) {
        this.items = items;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isStatut() {
        return statut;
    }

    public void setStatut(boolean statut) {
        this.statut = statut;
    }

    public Date getDate_commande() {
        return date_commande;
    }

    public void setDate_commande(Date date_commande) {
        this.date_commande = date_commande;
    }

    public double getPrix_total() {
        return prix_total;
    }

    public void setPrix_total(double prix_total) {
        this.prix_total = prix_total;
    }
@ManyToOne
    @JoinColumn(name = "id_table")
    public Tableresto getId_table() {
        return id_table;
    }

    public void setId_table(Tableresto id_table) {
        this.id_table = id_table;
    } 

    @ManyToOne
    @JoinColumn(name = "id_serveur")
    public Serveur getId_serveur() {
        return id_serveur;
    }

    public void setId_serveur(Serveur id_serveur) {
        this.id_serveur = id_serveur;
    }

    @Override
    public String toString() {
        return "Commande{" + "id=" + id + ", statut=" + statut + ", date_commande=" + date_commande + ", prix_total=" + prix_total + ", id_table=" + id_table + ", id_serveur=" + id_serveur + ", items=" + items + '}';
    }
   
    
    
    
 
    
    
    
    
    
    

}
