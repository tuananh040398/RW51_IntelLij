package com.tn;

import javax.persistence.*;

@Entity
@Table
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer id;
    private String teacherName;

    @Column(length = 70, nullable = false)
    private String address;

    @Column(columnDefinition = "tinyint unsigned")
    private short age;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public short getAge() {
        return age;
    }

    public void setAge(short age) {
        this.age = age;
    }

    public Teacher() {

    }

    public Teacher(Integer id, String teacherName, String address, short age) {
        this.id = id;
        this.teacherName = teacherName;
        this.address = address;
        this.age = age;
    }
}
