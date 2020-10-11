package com.alanthegoat.util;

public class GetMaxGcd {
    public static int gcd(int a,int b){
        if(a<b){
            int temp=a;
            a=b;
            b=temp;
        }
        //求最大公约数
        if(a%b!=0){
            int k=a%b;
            return gcd(b, k);
        }
        return b;
    }


    public static void main(String[] args) {
        System.out.println(GetMaxGcd.gcd(77,5));
    }
}
