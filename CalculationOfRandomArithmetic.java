package com.alanthegoat.calculation;

import com.alanthegoat.util.Fraction;
import com.alanthegoat.util.LinkedStack;
import com.alanthegoat.util.Utils;

public class CalculationOfRandomArithmetic {
    public String calculationOfRandomArithmetic(String arithmetic){
        String[] strings = arithmetic.split(" ");
        LinkedStack<String> linkedStack = new LinkedStack<>();
        String num1,num2;
        Fraction fraction1,fraction2;
        for (int i = 0; i < strings.length; i++) {
            if (Utils.isInteger(strings[i])) {
                linkedStack.push(strings[i]);
            } else if (Utils.isDecimal(strings[i])) {
                    linkedStack.push(Utils.properFractionToFraction(strings[i]).toString());
            } else {
                num1 = linkedStack.pop();
                num2 = linkedStack.pop();
                if(Utils.isDecimal(num1)||Utils.isDecimal(num2)){
                    fraction1 = Utils.fractionize(num1);
                    fraction2 = Utils.fractionize(num2);
                    switch (strings[i]) {
                        case "+":
                            fraction1 = fraction2.add(fraction1);
                            linkedStack.push(Utils.properFractionToFraction(fraction1.toString()).toString());
                            break;
                        case "-":
                            fraction1 = fraction2.sub(fraction1);
                            if(fraction1.toString().startsWith("-"))
                                return null;
                            linkedStack.push(Utils.properFractionToFraction(fraction1.toString()).toString());
                            break;
                        case "×":
                            fraction1 = fraction2.muti(fraction1);
                            linkedStack.push(Utils.properFractionToFraction(fraction1.toString()).toString());
                            break;
                        case "÷":
                            if(fraction1.getNumerator()==0)
                                return null;
                            fraction1 = fraction2.div(fraction1);
                            linkedStack.push(Utils.properFractionToFraction(fraction1.toString()).toString());
                            break;
                    }
                }else{
                    Integer result = null;
                    switch (strings[i]) {
                        case "+":
                            result = Integer.parseInt(num2)+Integer.parseInt(num1);
                            linkedStack.push(result.toString());
                            break;
                        case "-":
                            result = Integer.parseInt(num2)-Integer.parseInt(num1);
                            if(result<0)
                                return null;
                            linkedStack.push(result.toString());
                            break;
                        case "×":
                            result = Integer.parseInt(num2)*Integer.parseInt(num1);
                            linkedStack.push(result.toString());
                            break;
                        case "÷":
                            if(Integer.parseInt(num1)==0)
                                return null;
                            if(Integer.parseInt(num2)>Integer.parseInt(num1)){
                                result = Integer.parseInt(num2)/Integer.parseInt(num1);
                                fraction1 = new Fraction(Integer.parseInt(num2)%Integer.parseInt(num1),Integer.parseInt(num1));
                                fraction1.setInteger(result);
                            }else {
                                fraction1 = new Fraction(Integer.parseInt(num2),Integer.parseInt(num1));
                            }
                            linkedStack.push(Utils.properFractionToFraction(fraction1.toString()).toString());
                            break;
                    }
                }
            }
        }
        num1 = linkedStack.pop();
        if(num1.matches("\\d+/1"))
            num1 = num1.split("/")[0];
        if(num1.matches("\\d+/\\d+")){
            strings = num1.split("/");
            if(Integer.parseInt(strings[0])>Integer.parseInt(strings[1])){
                num1 = Integer.parseInt(strings[0])/Integer.parseInt(strings[1])+"'" +Integer.parseInt(strings[0])%Integer.parseInt(strings[1])+"/"+Integer.parseInt(strings[1]);
            }


        }

        return num1;
    }

    /*public static void main(String[] args) {
        CalculationOfRandomArithmetic calculationOfRandomArithmetic = new CalculationOfRandomArithmetic();
        System.out.println(calculationOfRandomArithmetic.calculationOfRandomArithmetic(""));
    }*/
}
