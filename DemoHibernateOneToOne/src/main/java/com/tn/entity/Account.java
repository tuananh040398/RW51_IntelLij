package com.tn.entity;

import javax.persistence.*;

@Entity
public class Account {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)


    private int id;
    private String username;

    @OneToOne
    @JoinColumn(name = "address_id", unique = true)
    private Address address;

    public Account() {
    }

    public Account(int id, String username) {
        this.id = id;
        this.username = username;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
