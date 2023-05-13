package com.tn;

public class Main {
    public static void main(String[] args) {
        CalculateNumber calculateNumber = new CalculateNumber();

        int t = calculateNumber.tinhTong(7);
        System.out.println("Tổng là: " + t);

        int lt = calculateNumber.luyThua(5);
        System.out.println("Lũy thừa là: " + lt);
    }
}
