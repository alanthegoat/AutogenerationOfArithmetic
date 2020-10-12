package com.alanthegoat.autogenerationofarithmetic;

import com.alanthegoat.util.BinaryTree;
import com.alanthegoat.util.Utils;

import java.util.Random;

public class GenerationOfRandomArithmetic {
    private int operationNum;
    private Random random;
    private int numberNum;

    public GenerationOfRandomArithmetic(){

    }

    public String generateArithmetic(BinaryTree<String> binaryTree,int bound){
        random = new Random();
        operationNum = random.nextInt(4);
        if(operationNum==0)
            operationNum++;
        switch (operationNum){
            case 1: numberNum = 2;break;
            case 2: numberNum = 3;break;
            case 3: numberNum = 4;break;
        }
//      BinaryTree<String> binaryTree = new BinaryTree<>();
        int flag = 0;
        Random random = new Random();
        Number number = null;
        Character character = null;
        Double decimalNumber = null;
        Integer integer = null;

        if(operationNum==1){
            character = GenerationOfRandomNumber.getRandomOperation();
            binaryTree.insert(character.toString());
            for (int i = 0; i < numberNum; i++) {
                flag = random.nextInt(2);
                number = decimalNumberOrInteger(flag,bound);
                if(number instanceof Integer){
                    integer = number.intValue();
                    binaryTree.insert(integer.toString());
                }
                else {
                    decimalNumber = number.doubleValue();
                    binaryTree.insert(Utils.decimalNumberToProperFraction(decimalNumber));
                }
            }
        }else{
            for (int i = 0; i < operationNum; i++) {
                character = GenerationOfRandomNumber.getRandomOperation();
                binaryTree.insert(character.toString());
            }
            for (int i = 0; i < numberNum; i++) {
                flag = random.nextInt(2);
                number = decimalNumberOrInteger(flag,bound);
                if(number instanceof Integer){
                    integer = number.intValue();
                    binaryTree.insert(integer.toString());
                }
                else {
                    decimalNumber = number.doubleValue();
                    binaryTree.insert(Utils.decimalNumberToProperFraction(decimalNumber));
                }
            }
        }
        String arithmetic = binaryTree.inorderTraversal();
        StringBuilder sb = new StringBuilder();
        String[] strings = arithmetic.split(" ");
        if(operationNum==2){
            if(getPriority(strings[3])>getPriority(strings[1])){
                sb.append("(");
                for (int i = 0; i < strings.length; i++) {
                    if(i==3)
                        sb.append(")");
                    sb.append(strings[i]);
                }
            }
        }
        if(operationNum==3){
            if(getPriority(strings[3])==getPriority(strings[1])+getPriority(strings[5])||(getPriority(strings[1])==1&&getPriority(strings[3])==2&&getPriority(strings[5])==2)){
                sb.append("(");
                for (int i = 0; i < strings.length; i++) {
                    if(i==3)
                        sb.append(")");
                    if(i==4)
                        sb.append("(");
                    sb.append(strings[i]);
                }
                sb.append(")");
            }else if(getPriority(strings[3])>=getPriority(strings[5])){

                for (int i = 0; i < strings.length; i++) {
                    if(i==4)
                        sb.append("(");
                    sb.append(strings[i]);
                }
                sb.append(")");
            }
        }

        if(sb.toString().equals(""))
            return arithmetic;

        return sb.toString();

    }


    private Number decimalNumberOrInteger(int flag,int bound){
        Number number = null;
        switch (flag){
            case 0: number = GenerationOfRandomNumber.getRandomIntergerNumber(bound);break;
            case 1:
                number = GenerationOfRandomNumber.getRandomDoubleNumber(bound);
                break;
        }
        return number;
    }

    private int getPriority(String operation){
        int priority = 0;
        switch(operation){
            case "+":priority = 1;break;
            case "-":priority = 1;break;
            case "×":priority = 2;break;
            case "÷":priority = 2;break;
        }
        return priority;
    }
    public static void main(String[] args){
        int count = 1;
        GenerationOfRandomArithmetic generationOfRandomArithmetic = new GenerationOfRandomArithmetic();
        BinaryTree<String> binaryTree;
        for (int i = 0; i < 10; i++) {
            binaryTree = new BinaryTree<>();
            System.out.println(count++ + ".   " +generationOfRandomArithmetic.generateArithmetic(binaryTree,10));
        }
    }
}
