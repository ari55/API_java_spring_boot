/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ecommerce.apiMenuio.security.services;

import com.ecommerce.apiMenuio.entities.Proprietaire;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.Collection;
import java.util.Objects;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

/**
 *
 * @author aissata
 */
public class UserPrinciple implements UserDetails{
    private static final long serialVersionUID = 1L;
    
    int id;
    String nom;
    String prenom;
    String email;
    long telephone;
    String addresse;
    @JsonIgnore
    String passwords;
   

    public UserPrinciple(int id, String nom, String prenom, String email, long telephone, String addresse, String passwords) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.telephone = telephone;
        this.addresse = addresse;
        this.passwords = passwords;
        //this.authorities = authorities;
    }
    
    public static UserPrinciple build(Proprietaire p) {
 
        return new UserPrinciple(
                p.getId(),
                p.getNom(),
                p.getPrenom(),
                p.getEmail(),
                p.getTelephone(),
                p.getAddresse(),
                p.getPasswords()
        );
    }



    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getEmail() {
        return email;
    }

    public long getTelephone() {
        return telephone;
    }

    public String getAddresse() {
        return addresse;
    }

    public String getPasswords() {
        return passwords;
    }
    
    @Override
    public String getUsername() {
        return email;
    }
 
    @Override
    public String getPassword() {
        return passwords;
    }
 
 
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }
 
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }
 
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }
 
    @Override
    public boolean isEnabled() {
        return true;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        
        UserPrinciple user = (UserPrinciple) o;
        return Objects.equals(id, user.id);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return null;
    }
    
    
    
}
