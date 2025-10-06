package Reverse_Integer;
//https://leetcode.com/problems/reverse-integer/description/

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter an integer: ");
        int x = sc.nextInt();
        System.out.println(Solution.reverse(x));
    }
}
