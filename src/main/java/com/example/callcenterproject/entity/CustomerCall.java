package com.example.callcenterproject.entity;

import javax.persistence.*;

@Entity
@Table(name = "customer_requests")
public class CustomerCall {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String surname;
    private String address;
    private String note;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "credit_type_id", referencedColumnName = "id")
    private CreditType creditType;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "advertisement_type_id", referencedColumnName = "id")
    private AdvertisementType advertisementType;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "operator_id", referencedColumnName = "id")
    private Operator operator;

    public CustomerCall() {
    }

    public CustomerCall(long id, String name, String surname, String address, String note,
                        CreditType creditType, AdvertisementType advertisementType, Operator operator) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.note = note;
        this.creditType = creditType;
        this.advertisementType = advertisementType;
        this.operator = operator;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public CreditType getCreditType() {
        return creditType;
    }

    public void setCreditType(CreditType creditType) {
        this.creditType = creditType;
    }

    public AdvertisementType getAdvertisementType() {
        return advertisementType;
    }

    public void setAdvertisementType(AdvertisementType advertisementType) {
        this.advertisementType = advertisementType;
    }

    public Operator getOperator() {
        return operator;
    }

    public void setOperator(Operator operator) {
        this.operator = operator;
    }
}
