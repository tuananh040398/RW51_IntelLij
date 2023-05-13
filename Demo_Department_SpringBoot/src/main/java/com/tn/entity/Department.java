package com.tn.entity;

import javax.persistence.*;

@Entity
@Table
public class Department {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)

    private int id;

    private String departmentName;

    private String descritption;

    public Department() {
    }

    public Department(int id, String departmentName, String descritption) {
        this.id = id;
        this.departmentName = departmentName;
        this.descritption = descritption;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getDescritption() {
        return descritption;
    }

    public void setDescritption(String descritption) {
        this.descritption = descritption;
    }
}
