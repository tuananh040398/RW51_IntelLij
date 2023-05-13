package com.tn;

public class Student extends People {
//    private int id;
    private String studentName;
    private int age;

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void printName() {
        System.out.println("Name: Tuấn Anh");
    }
    //    public int tinhDienTich(int chieudai, int chieurong) {
//        int Dientich = chieudai * chieurong;
//        return Dientich;
//    }
}
