package com.example.callcenterproject.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "credit_types")
public class CreditType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String creditType;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "creditType", fetch = FetchType.LAZY)
    private List<CustomerCall> customerCalls;

    public CreditType() {
    }

    public CreditType(long id, String creditType, List<CustomerCall> customerCalls) {
        this.id = id;
        this.creditType = creditType;
        this.customerCalls = customerCalls;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCreditType() {
        return creditType;
    }

    public void setCreditType(String creditType) {
        this.creditType = creditType;
    }

    public List<CustomerCall> getCustomerCalls() {
        return customerCalls;
    }

    public void setCustomerCalls(List<CustomerCall> customerCalls) {
        this.customerCalls = customerCalls;
    }
}
