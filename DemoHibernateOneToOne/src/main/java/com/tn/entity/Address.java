package com.tn.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Address {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)

    private int id;
    private String addressName;

    public Address() {
    }

    public Address(int id, String addressName) {
        this.id = id;
        this.addressName = addressName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAddressName() {
        return addressName;
    }

    public void setAddressName(String addressName) {
        this.addressName = addressName;
    }
}
