package com.tn;

import java.util.List;

public class Student {
    private int id;
    private String studentName;
    private String address;
    private int age;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Student() {

    }

    public Student(int id, String studentName, String address, int age) {
        this.id = id;
        this.studentName = studentName;
        this.address = address;
        this.age = age;
    }

    public List addStudent(List<Student> studentList, Student student) {
        studentList.add(student);
        return studentList;
    }

    public List delStudent(List<Student> studentList, int id) {
        studentList.removeIf(student -> (student.getId() == id));
        return studentList;
    }

    @Override
    public String toString() {
        return "id=" + id +
                " - studentName='" + studentName + '\'' +
                " - address='" + address + '\'' +
                " - age=" + age;
    }
}
