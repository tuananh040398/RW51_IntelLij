package com.tn;


import javax.persistence.*;
import java.util.List;

@Entity
@Table
public class Teacher {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)

    private int id;
    private String teacherName;
    private int age;
    private String major;

    @ManyToMany
    @JoinTable(
            name ="Teacher_Student",
            joinColumns = { @JoinColumn(name = "teacher_id")},
            inverseJoinColumns = { @JoinColumn(name = "student_id")}
    )
    private List<Student> students;

    public Teacher() {
    }

    public Teacher(int id, String teacherName, int age, String major) {
        this.id = id;
        this.teacherName = teacherName;
        this.age = age;
        this.major = major;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }
}
