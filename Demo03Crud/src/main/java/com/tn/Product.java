package com.tn;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table

public class Product {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;

    private String productName;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }
}
