package com.example.felipe.sec.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.example.felipe.sec.demo.model.User;
import com.example.felipe.sec.demo.repository.UserRepository;

public class UserDetailServiceImpl implements UserDetailService {

    @Autowired
    private UserRepository repo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
        User user = repo.findByUserName(username);

        if(user == null){
            throw new UsernameNotFoundException("Usuario nao encontrado: " + username);
        }
        return org.springframework.security.core.userdetails.User
        .withUsername(user.getUsername())
        .password(user.getPassword())
        .roles("USER") // Defina as roles do usuário conforme sua lógica de autorização
        .build();

    }
    
    
}
