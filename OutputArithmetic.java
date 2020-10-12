package com.alanthegoat.outputfile;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class OutputArithmetic {
    static int count = 1;
    static private String filePath ="d://Exercises.txt";
    static private BufferedWriter bufferedWriter;

    static {
        try {
            bufferedWriter = new BufferedWriter(new FileWriter(filePath,true));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void outputArithmetic(String arithmetic) throws IOException {
        bufferedWriter.write((count++) +".  " + arithmetic+" = ");
        bufferedWriter.newLine();
    }

    public static void close() throws IOException {
        bufferedWriter.close();
    }
}
