package com.example.felipe.sec.demo.model;

public class JwtRespose {
    private String token;
    
    public JwtRespose(String token){
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    
}
