package Zigzag_Conversion;
//https://leetcode.com/problems/zigzag-conversion/description/
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a string: ");
        String s = sc.nextLine();
        System.out.println("Enter number of rows");
        int n = sc.nextInt();
        System.out.println(Solution.convert(s, n));
    }
}
