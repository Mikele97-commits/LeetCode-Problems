package Longest_Palindromic_Substring;

public class Palindrome {
    public static boolean check(String string) {
        int start = 0;
        int end = string.length() - 1;
        while (start < end) {
            if (string.charAt(start) != string.charAt(end)) {
                System.out.println(string + " is not a palindrome");
                return false;
            }
            start++;
            end--;
        }
        System.out.println(string + " is a palindrome");
        return true;
    }
}
