/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ecommerce.apiMenuio.hateos;

import com.ecommerce.apiMenuio.entities.Commande;
import com.ecommerce.apiMenuio.entities.LigneDeCommande;
import com.ecommerce.apiMenuio.entities.Serveur;
import com.ecommerce.apiMenuio.entities.Tableresto;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.hateoas.RepresentationModel;

//import org.springframework.hateoas.ResourceSupport;
//import org.springframework.transaction.support.ResourceHolderSupport;
/**
 *
 * @author ateubohk
 */
public class CommandeRessource extends  RepresentationModel {
        @JsonProperty
            public long id;
    private boolean statut;
    private Date date_commande;
    private double prix_total;
   // @JoinTable(name = "tableresto", joinColumns = @JoinColumn(name = "id"))
    private Tableresto id_table;
    //@JoinTable(name = "serveur", joinColumns = @JoinColumn(name = "id"))
    private Serveur id_serveur;
    private List<LigneDeCommande> items = new ArrayList<LigneDeCommande>();

    public CommandeRessource( Commande c) {
        id = c.getId();
        statut= c.isStatut();
        date_commande= c.getDate_commande();
        prix_total= c.getPrix_total();
        id_table= c.getId_table();
        id_serveur=c.getId_serveur();
        items=c.getItems();
    }

        
        
        

}
