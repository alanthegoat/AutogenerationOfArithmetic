package com.alanthegoat.util;


public class Fraction {
    private int numerator;  // 分子
    private int denominator; // 分母
    private Integer integer;


    public Fraction() {
    }

    public void setInteger(int integer) {
        this.integer = integer;
    }

    public Fraction(int a, int b) {
        if (a == 0) {
            numerator = 0;
            denominator = 1;
        } else {
            setNumeratorAndDenominator(a, b);
        }
    }

    private void setNumeratorAndDenominator(int a, int b) {  // 设置分子和分母
        int c = f(Math.abs(a), Math.abs(b));         // 计算最大公约数
        numerator = a / c;
        denominator = b / c;
        if (numerator < 0 && denominator < 0) {
            numerator = -numerator;
            denominator = -denominator;
        }
    }

    public int getNumerator() {
        return numerator;
    }

    public int getDenominator() {
        return denominator;
    }

    private int f(int a, int b) {  // 求a和b的最大公约数
        if (a < b) {
            int c = a;
            a = b;
            b = c;
        }
        int r = a % b;
        while (r != 0) {
            a = b;
            b = r;
            ;
            r = a % b;
        }
        return b;
    }

    public Fraction add(Fraction r) {  // 加法运算
        Fraction result = null;
        int a = r.getNumerator();
        int b = r.getDenominator();
        int newNumerator = numerator * b + denominator * a;
        int newDenominator = denominator * b;
        if(newNumerator>newDenominator){
            a = newNumerator/newDenominator;
            newNumerator = newNumerator%newDenominator;
            result = new Fraction(newNumerator, newDenominator);
            result.setInteger(a);
            return result;
        }
            result = new Fraction(newNumerator, newDenominator);
        return result;
    }

    public Fraction sub(Fraction r) {  // 减法运算
        Fraction result = null;
        int a = r.getNumerator();
        int b = r.getDenominator();
        int newNumerator = numerator * b - denominator * a;
        int newDenominator = denominator * b;
        if(newNumerator>newDenominator){
            a = newNumerator/newDenominator;
            newNumerator = newNumerator%newDenominator;
            result = new Fraction(newNumerator, newDenominator);
            result.setInteger(a);
            return result;
        }
        result = new Fraction(newNumerator, newDenominator);
        return result;
    }

    public Fraction muti(Fraction r) { // 乘法运算
        Fraction result = null;
        int a = r.getNumerator();
        int b = r.getDenominator();
        int newNumerator = numerator * a;
        int newDenominator = denominator * b;
        if(newNumerator>newDenominator){
            a = newNumerator/newDenominator;
            newNumerator = newNumerator%newDenominator;
            result = new Fraction(newNumerator, newDenominator);
            result.setInteger(a);
            return result;
        }
        result = new Fraction(newNumerator, newDenominator);
        return result;
    }

    public Fraction div(Fraction r) {  // 除法运算
        Fraction result = null;
        int a = r.getNumerator();
        int b = r.getDenominator();
        int newNumerator = numerator * b;
        int newDenominator = denominator * a;
        if(newNumerator>newDenominator){
            a = newNumerator/newDenominator;
            newNumerator = newNumerator%newDenominator;
            result = new Fraction(newNumerator, newDenominator);
            result.setInteger(a);
            return result;
        }
        result = new Fraction(newNumerator, newDenominator);
        return result;
    }

    @Override
    public String toString() {
        if(integer==null)
            return numerator+"/"+denominator;

        return integer+"'"+numerator+"/"+denominator;
    }

/*    public static void main(String[] args) {
        Fraction fraction = new Fraction(0,2);
        Fraction fraction1 = new Fraction(18,5);
        System.out.println(fraction.f(-36,18));
        System.out.println(fraction.sub(fraction1));
    }*/
}

