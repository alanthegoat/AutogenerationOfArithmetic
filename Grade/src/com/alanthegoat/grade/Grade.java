package com.alanthegoat.grade;

import java.io.*;

public class Grade {
    static final private String file1 = "d://Answers.txt";
    static final private String file2 = "d://Exercises.txt";
    static final private String file3 = "d://Grade.txt";
    static private BufferedReader br1;
    static private BufferedReader br2;
    static private BufferedWriter bw;
    static private StringBuilder sb1 = new StringBuilder();
    static private StringBuilder sb2 = new StringBuilder();
    static private String result1;
    static private String result2;
    static int rightCount = 0;
    static int wrongCount = 0;

    static {
        try {
            br1 = new BufferedReader(new FileReader(file1));
            br2 = new BufferedReader(new FileReader(file2));
            bw = new BufferedWriter(new FileWriter(file3));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void grade() throws IOException {
        result1 = "correct:";
        result2 = "wrong:";
        sb1.append("（");
        sb2.append("（");
        String str = null, str1 = null;
        String[] strings = null, strings1 = null;
        while ((str = br2.readLine()) != null && (str1 = br1.readLine()) != null) {
            strings = str.split("=");
            strings1 = str1.split("\\.  ");
            if (strings[1].equals(strings1[1])) {
                rightCount++;
                sb1.append(strings1[0] + ",");
            } else {
                wrongCount++;
                sb2.append(strings1[0] + ",");
            }
        }
        sb1.append(")");
        sb2.append(")");
        result1 += rightCount + sb1.toString();
        result2 += wrongCount + sb2.toString();
        bw.write(result1);
        bw.newLine();
        bw.write(result2);
        br1.close();
        br2.close();
        bw.close();
    }
}