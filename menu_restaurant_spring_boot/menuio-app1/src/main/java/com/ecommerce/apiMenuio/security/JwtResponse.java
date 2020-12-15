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
public class JwtResponse {
    
    private String token;
 
    public JwtResponse(String accessToken) {
        this.token = accessToken;
    }
 
    public String getAccessToken() {
        return token;
    }
 
    public void setAccessToken(String accessToken) {
        this.token = accessToken;
    }

}
