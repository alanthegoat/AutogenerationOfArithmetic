package com.alanthegoat.autogenerationofarithmetic;

import java.util.Random;

public class GenerationOfRandomNumber {
    public static Character getRandomOperation(){
        Random random = new Random();
        int i = random.nextInt(4);
        Character op = null;
        switch(i){
            case 0:op = '+';break;
            case 1:op = '-';break;
            case 2:op = '×';break;
            case 3:op = '÷';break;
        }
        return op;
    }

    public static Integer getRandomIntergerNumber(int bound){
        Random random = new Random();
        Integer integer = random.nextInt(bound+1);
        return integer;
    }

    public static Double getRandomDoubleNumber(int bound){
        Random random = new Random();
        Double decimalNumber = random.nextDouble();
        Integer integer = random.nextInt(bound);
        String string = new String(String.valueOf(decimalNumber+integer));
        string = string.substring(0,3);
        decimalNumber = Double.parseDouble(string);
        return decimalNumber;
    }

}
