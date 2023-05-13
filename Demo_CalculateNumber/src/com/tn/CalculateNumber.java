package com.tn;

public class CalculateNumber {
    public int tinhTong(int n) {
        int tong = 0;
        for ( int i = 1; i <= n; i++) {
            tong = tong + i;
        }
        return tong;
    }

    public int luyThua(int n) {
        int luythua = 1;
        for ( int i = 1; i <= n; i++) {
            luythua = luythua * i;
        }
        return luythua;
    }
}
