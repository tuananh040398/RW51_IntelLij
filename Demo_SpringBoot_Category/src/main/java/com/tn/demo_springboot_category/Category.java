package com.tn.demo_springboot_category;

import javax.persistence.*;

@Entity
@Table
public class Category {
    @Id
    @GeneratedValue ( strategy = GenerationType.IDENTITY)

    private int id;
    private String categoryName;
    private String description;

    private String price;

    public Category() {
    }

    public Category(int id, String categoryName, String description) {
        this.id = id;
        this.categoryName = categoryName;
        this.description = description;

    }

    public Category(int id, String categoryName, String description, String price) {
        this.id = id;
        this.categoryName = categoryName;
        this.description = description;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
