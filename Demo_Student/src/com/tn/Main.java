package com.tn;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Student> studentList = new ArrayList<Student>();

        Student std1 = new Student(1, "Nguyễn Tuấn Anh", "số 1 Hùng Vương", 20);
        Student std2 = new Student(2, "Đỗ Nhật Quân", "số 2 Hùng Vương", 21);
        Student std3 = new Student(3, "Đặng Gia Sơn", "số 3 Hùng Vương", 22);

        System.out.println("-Danh sách student: ");
        Student student = new Student();
        student.addStudent(studentList, std1);
        student.addStudent(studentList, std2);
        student.addStudent(studentList, std3);
        studentList.forEach(ds -> {
            System.out.println(ds);
        });

        System.out.println("-Danh sách sau khi xóa Student: ");
        student.delStudent(studentList, 2);
        studentList.forEach(ds -> {
            System.out.println(ds);
        });
    }
}
