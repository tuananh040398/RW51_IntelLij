package com.tn;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
public class Address {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)

    private int id;
    private String addressName;

    @ManyToOne
    @JoinColumn(name = "account_id")
    private Account account;

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

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}
