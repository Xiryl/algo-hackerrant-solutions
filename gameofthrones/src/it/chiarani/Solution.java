package it.chiarani;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the gameOfThrones function below.
    static String gameOfThrones(String s) {
        int[] allChars = new int[256];

        for(char character : s.toCharArray()) {
            // sSystem.out.println("char:"+ character + " int:" + (int)(character));
            allChars[character] ++;
        }

        boolean isPalindroma = true;
        int countOddChars = 0;
        for(int i = 0; i < allChars.length; i++) {
            if(allChars[i] %2 != 0) {
                if(countOddChars > 1) {
                    isPalindroma = false;
                } else {
                    isPalindroma = true;
                    countOddChars++;
                }
            }
        }

        return isPalindroma ? "YES" : "NO";
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scanner.nextLine();

        String result = gameOfThrones(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
