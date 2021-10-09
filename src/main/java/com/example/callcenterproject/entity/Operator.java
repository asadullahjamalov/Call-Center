package com.example.callcenterproject.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "operators")
public class Operator {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String surname;
    private long phoneNumber;
    private String username;
    private String password;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "operator", fetch = FetchType.LAZY)
    private List<CustomerCall> customerCallList;

    public Operator() {
    }

    public Operator(long id, String name, String surname, long phoneNumber,
                    String username, String password, List<CustomerCall> customerCallList) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.phoneNumber = phoneNumber;
        this.username = username;
        this.password = password;
        this.customerCallList = customerCallList;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<CustomerCall> getCustomerCallList() {
        return customerCallList;
    }

    public void setCustomerCallList(List<CustomerCall> customerCallList) {
        this.customerCallList = customerCallList;
    }
}
