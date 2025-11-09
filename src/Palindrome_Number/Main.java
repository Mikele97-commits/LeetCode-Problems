//https://leetcode.com/problems/palindrome-number/description/
package Palindrome_Number;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number: ");
        int number = sc.nextInt();
        if(Solution.solution(number))
            System.out.println("Is palindrome");
        else
            System.out.println("Is not palindrome");
    }
}
