package com.zrd.study.euclid;

/**
 * Created by zrd on 2017/2/9.
 * 欧几里得算法
 * 用于求两个整数的最大公约数
 */
public class Euclid {
    public static void main(String[] args) {
        long a = 121;
        long b = 102;

        if(a < b){
            long t = a;
            a = b;
            b = t;
        }

        long rem = 1;
        while(b != 0){
            rem = a%b;
            a = b;
            b = rem;
        }

        System.out.println(a);
    }
}
