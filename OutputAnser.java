package com.alanthegoat.outputfile;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class OutputAnser {
    static private String filePath ="d://Answers.txt";
    static private BufferedWriter bufferedWriter;
    static private int count = 1;

    static {
        try {
            bufferedWriter = new BufferedWriter(new FileWriter(filePath));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void outputAnswers(String answer) throws IOException {
        bufferedWriter.write((count++) +".  " + answer);
        bufferedWriter.newLine();
    }
    public static void close() throws IOException {
        bufferedWriter.close();
    }
}
