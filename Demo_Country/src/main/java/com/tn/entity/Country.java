package com.tn.entity;

import javax.persistence.*;

@Entity
@Table
public class Country {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)

    private int id;

    private String countryName;

    private String area;

    @OneToOne
    @JoinColumn(name = "capital_id", unique = true)
    private Capital capital;

    public Country() {
    }

    public Country(int id, String countryName, String area, Capital capital) {
        this.id = id;
        this.countryName = countryName;
        this.area = area;
        this.capital = capital;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public Capital getCapital() {
        return capital;
    }

    public void setCapital(Capital capital) {
        this.capital = capital;
    }
}
