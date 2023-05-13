package com.tn;

import javax.persistence.*;

@Entity
@Table(name = "test_department" )
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer id;
    
    private String departmentName;

    @Column(columnDefinition = "tinyint unsigned default 100",nullable = false, unique = true)
    private short numOfMember;

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

    public short getNumOfMember() {
        return numOfMember;
    }

    public void setNumOfMember(short numOfMember) {
        this.numOfMember = numOfMember;
    }
}
