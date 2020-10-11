package com.alanthegoat.outputfile;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class OutputFile {
    static int count1 = 1;
    static int count2 = 1;

    public static void outputArithmetic(String arithmetic) throws IOException {
        String filePath ="d://Exercises.txt";
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filePath,true));
        bufferedWriter.write((count1++) +".  " + arithmetic+" = ");
        bufferedWriter.newLine();
        bufferedWriter.close();
    }

    public static void outputAnswers(String answer) throws IOException {
        String filePath ="d://Answers.txt";
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filePath,true));
        bufferedWriter.write((count2++) +".  " + answer);
        bufferedWriter.newLine();
        bufferedWriter.close();
    }
}
