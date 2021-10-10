package com.example.callcenterproject.entity;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "advertisement_type")
public class AdvertisementType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String advertisementType;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "advertisementType", fetch = FetchType.LAZY)
    private List<CustomerCall> customerCalls;

    public AdvertisementType() {
    }

    public AdvertisementType(long id, String advertisementType, List<CustomerCall> customerCalls) {
        this.id = id;
        this.advertisementType = advertisementType;
        this.customerCalls = customerCalls;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAdvertisementType() {
        return advertisementType;
    }

    public void setAdvertisementType(String advertisementType) {
        this.advertisementType = advertisementType;
    }

    public List<CustomerCall> getCustomerCalls() {
        return customerCalls;
    }

    public void setCustomerCalls(List<CustomerCall> customerCalls) {
        this.customerCalls = customerCalls;
    }
}
