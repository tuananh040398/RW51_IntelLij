package com.tn.entity;

import javax.persistence.*;

@Entity
@Table
public class Capital {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)

    private int id;

    private String capitalName;

    public Capital() {
    }

    public Capital(int id, String capitalName) {
        this.id = id;
        this.capitalName = capitalName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCapitalName() {
        return capitalName;
    }

    public void setCapitalName(String capitalName) {
        this.capitalName = capitalName;
    }

}
