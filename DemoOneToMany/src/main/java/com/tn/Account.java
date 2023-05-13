package com.tn;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
public class Account {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)

    private int id;
    private String userName;

    @OneToMany(mappedBy = "account")
    private List<Address> addresses;

    public Account() {
    }

    public Account(int id, String userName) {
        this.id = id;
        this.userName = userName;
    }

    public Account(List<Address> addresses) {
        this.addresses = addresses;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public List<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }
}
