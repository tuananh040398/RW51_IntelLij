package com.tn;

public class Square {
    private int chieuDai;
    private int chieuRong;

//    public int tinhDienTich() {
//        int dienTich = chieuDai * chieuRong;
//        return dienTich;
//    }

//    public int tinhChuVi() {
//        int chuVi = (chieuDai + chieuRong) * 2;
//        return chuVi;
//    }

//    public int binhPhuong(int so) {
//        int bp = so * so;
//        return bp;
//    }
//    public int lapPhuong(int g) {
//        int lp = g * g * g;
//        return lp;
//    }

//    public String hello(String ho, String ten) {
//        String hoTen = ho + " " + ten;
//        return hoTen;
//    }

//    public Square(){
//
//    }

    public Square(int chieuDai, int chieuRong) {
        this.chieuDai = chieuDai;
        this.chieuRong = chieuRong;
    }


    public int getChieuDai() {
        return chieuDai;
    }

    public void setChieuDai(int chieuDai) {
        this.chieuDai = chieuDai;
    }

    public int getChieuRong() {
        return chieuRong;
    }

    public void setChieuRong(int chieuRong) {
        this.chieuRong = chieuRong;
    }

    public int tinhDienTich () {
        int dienTich = chieuDai * chieuRong;
        return dienTich;
    }

}
