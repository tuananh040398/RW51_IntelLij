package com.tn;

import javax.persistence.*;

@Entity
@Table
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer id;
    private String departmentName;
    private Integer numOfMember;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public Integer getNumOfMember() {
        return numOfMember;
    }

    public void setNumOfMember(Integer numOfMember) {
        this.numOfMember = numOfMember;
    }
}
