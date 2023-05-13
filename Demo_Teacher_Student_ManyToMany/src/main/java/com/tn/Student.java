package com.tn;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
public class Student {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)

    private int id;
    private String studentName;
    private String className;

    @ManyToMany(mappedBy = "students")
    private List<Teacher> teachers;

    public Student() {
    }

    public Student(int id, String studentName, String className) {
        this.id = id;
        this.studentName = studentName;
        this.className = className;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentnName(String studentName) {
        this.studentName = studentName;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public List<Teacher> getTeachers() {
        return teachers;
    }

    public void setTeachers(List<Teacher> teachers) {
        this.teachers = teachers;
    }
}
