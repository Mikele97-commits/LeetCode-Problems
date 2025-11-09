//https://leetcode.com/problems/container-with-most-water/description/
package Container_With_Most_Water;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter length of int array");
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.println("Enter element " + (i + 1) + " of array");
            arr[i] = sc.nextInt();
        }

        System.out.println("Most Water " + Solution.solution(arr));
    }
}
