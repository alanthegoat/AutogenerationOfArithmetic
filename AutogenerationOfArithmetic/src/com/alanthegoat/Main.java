package com.alanthegoat;

import com.alanthegoat.autogenerationofarithmetic.GenerationOfRandomArithmetic;
import com.alanthegoat.calculation.CalculationOfRandomArithmetic;
import com.alanthegoat.outputfile.OutputFile;
import com.alanthegoat.util.BinaryTree;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        GenerationOfRandomArithmetic generation = new GenerationOfRandomArithmetic();
        CalculationOfRandomArithmetic calculation = new CalculationOfRandomArithmetic();
        BinaryTree<String> binaryTree;
        String answer ,arithmetic;

        for (int i = 0; i < Integer.parseInt(args[1]); i++) {
            binaryTree = new BinaryTree<>();
            arithmetic =generation.generateArithmetic(binaryTree,Integer.parseInt(args[3]));
            answer=calculation.calculationOfRandomArithmetic(binaryTree.postorderTraversal());
            if(answer==null){
                i--;
                continue;
            }else {
                OutputFile.outputArithmetic(arithmetic);
                OutputFile.outputAnswers(answer);
            }

        }
    }
}
