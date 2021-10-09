package com.example.callcenterproject.service;

import com.example.callcenterproject.entity.Operator;
import com.example.callcenterproject.exception.OperatorNotFound;
import com.example.callcenterproject.model.ExceptionResponse;
import com.example.callcenterproject.repository.OperatorRepo;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class JwtUserDetailsService implements UserDetailsService {

    private final OperatorRepo operatorRepo;

    public JwtUserDetailsService(OperatorRepo operatorRepo) {
        this.operatorRepo = operatorRepo;
    }

    @Override
    public UserDetails loadUserByUsername(String username) {
        Operator operator = operatorRepo.getOperatorByUsername(username);
        System.out.println(operator.getUsername());
        if (operator != null) {
            return new User(username, operator.getPassword(),
                    new ArrayList<>());
        } else {
            throw new OperatorNotFound(new ExceptionResponse("Operator not found with username: " + username, 404));
        }
    }
}
