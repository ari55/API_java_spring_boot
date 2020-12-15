/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ecommerce.apiMenuio.security;

/**
 *
 * @author aissata
 */
public class LoginForm {
    private String email;
 
    private String passwords;
 
    public String getEmail() {
        return email;
    }
 
    public void setEmail(String email) {
        this.email = email;
    }
 
    public String getPasswords() {
        return passwords;
    }
 
    public void setPasswords(String password) {
        this.passwords = password;
    }
}
