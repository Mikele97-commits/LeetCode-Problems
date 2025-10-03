package Longest_Palindromic_Substring;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a string: ");
        String string = sc.nextLine();
        String palindrome = "";
        String temp;

        for (int i = 0; i < string.length(); i++) {

            for (int j = i+1; j<string.length(); j++) {
                //If found the same character, check if it's palindrome
                if (string.charAt(i) == string.charAt(j)) {
                    temp = string.substring(i, j+1);
                    if (temp.length()>palindrome.length() && Palindrome.check(temp)) {
                        System.out.println("Palindrome " + palindrome + " has been substituted with "+ temp);
                        palindrome = temp;
                    }
                }
            }
        }
        System.out.println("Longest palindrome substring: " + palindrome);
    }
}
