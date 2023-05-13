package com.tn;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
public class Address {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)

    private int id;
    private String street;

    @ManyToMany(mappedBy = "addresses")
    private List<User> users;

    public Address() {
    }

    public Address(int id, String street) {
        this.id = id;
        this.street = street;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
