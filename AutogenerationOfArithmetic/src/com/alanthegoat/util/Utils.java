package com.alanthegoat.util;

import com.sun.deploy.util.StringUtils;

import javax.sql.DataSource;
import java.util.regex.Pattern;

public class Utils {
    public static boolean isInteger(String str) {
        if(str==null)
            return false;
        for (int i = 0; i < str.length(); i++) {
            if(!Character.isDigit(str.charAt(i)))
                return false;
        }
        return true;
    }
    public static boolean isDecimal(String str){
        if(str==null)
            return false;
        return str.matches("\\d+/\\d+")||str.matches("\\d+'\\d+/\\d+");
    }

    public static String properfractionToDecimalNumber(String properfraction){
        String result="";
        String[] strings;
        Integer i;
        if(properfraction.matches("\\d+/\\d+")){
            strings = properfraction.split("/");
            result +=Float.parseFloat(strings[0])/Float.parseFloat(strings[1]);
        }
        if(properfraction.matches("\\d+'\\d+/\\d+")){
            strings = properfraction.split("'");
            i=Integer.parseInt(strings[0]);
            strings = strings[1].split("/");
            result += Double.parseDouble(strings[0])/Float.parseFloat(strings[1])+i;
        }

        return result;
    }

    public static String decimalNumberToProperFraction(Double decimalNumber){
        String s = decimalNumber.toString();
        StringBuilder sb = new StringBuilder();
        String[] strings = s.split("\\.");
        if("0".equals(strings[1]))
            return strings[0];
        if("0".equals(strings[0])){
            int gcd = GetMaxGcd.gcd(10,Integer.parseInt(strings[1]));
            sb.append(Integer.parseInt(strings[1])/gcd+"/");
            sb.append(10/gcd);
            s = sb.toString();
            return s;
        }
        sb.append(strings[0] +"'");
        int gcd = GetMaxGcd.gcd(10,Integer.parseInt(strings[1]));
        sb.append(Integer.parseInt(strings[1])/gcd+"/");
        sb.append(10/gcd);
        s = sb.toString();
        return s;
    }
    public static Fraction properFractionToFraction(String properFraction){
        Fraction result = null;
        String[] strings;
        Integer i;
        if(properFraction.matches("\\d+/\\d+")){
            strings = properFraction.split("/");
            result = new Fraction(Integer.parseInt(strings[0]),Integer.parseInt(strings[1]));
        }
        if(properFraction.matches("\\d+'\\d+/\\d+")){
            strings = properFraction.split("'");
            i=Integer.parseInt(strings[0]);
            strings = strings[1].split("/");
            result = new Fraction(Integer.parseInt(strings[0])+i*Integer.parseInt(strings[1]),Integer.parseInt(strings[1]));
        }
        return result;
    }

    public static Fraction fractionize(String s){
        Fraction fraction = null;
        String[] strings ;
        if(isInteger(s)){
            fraction = new Fraction(Integer.parseInt(s)*2,2);
        }else {
            strings = s.split("/");
            fraction = new Fraction(Integer.parseInt(strings[0]),Integer.parseInt(strings[1]));
        }
        return fraction;
    }

    public static void main(String[] args) {
        System.out.println(isInteger("0"));

    }
}
