/******************************************************************************
 *  Michael Volynskiy | EMPLID: 23627478
 *  Compilation:  javac Assignment_1.java
 *  Execution:    java Assignment_1 < input.txt
 *
 *  Reads in a text file and for each line verifies whether the word has
 *  unique characters and prints each word in order of sorted characters
 *  alongside the boolean value.
 ******************************************************************************/

import java.util.Scanner;
import java.util.Arrays;
import java.io.File;
import java.io.IOException;
import java.lang.StringBuilder;

public class Assignment_1 {
    public static void main(String[] args) throws IOException {    // thrown input/output exceptions will be caught
        Scanner sc = new Scanner(new File("input.txt"));    // scanner reads from a file named "input.txt"

        while (sc.hasNextLine()) {    // while there are more lines to be read by the scanner, they will be converted to lowercase, methods: isUniqueChar and sortWord are called on them, and formatted for outputting
            String word = sc.nextLine().toLowerCase();
            System.out.println(isUniqueChar(word) + "\t" + sortWord(word));
        }
    }    // end of main method

    public static boolean isUniqueChar(String s) {    // method returns a boolean value upon checking for whether the String contains unique characters
        if (s.length() == 0)
            return false;

        else {
            for (int i = 0; i < s.length() - 1; i++)
                for (int j = i + 1; j < s.length(); j++)
                    if (s.charAt(i) == s.charAt(j))
                        return false;
        }

        return true;
    }

    private static String sortWord(String s) {    // method creates an instance of the String as a character array, sorts, then appends the array to return it as a String
        char[] c = s.toCharArray();
        StringBuilder sortedWord = new StringBuilder();

        Arrays.sort(c);    // replaces the insertionSort method

        for (int i = 0; i < c.length; i++)
            sortedWord.append(c[i]);

        return sortedWord.toString();
    }
}    // end of class Assignment_1