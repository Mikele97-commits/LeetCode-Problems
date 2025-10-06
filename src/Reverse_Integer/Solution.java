package Reverse_Integer;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public static int reverse(int x) {

        int solution = 0;
        int magnitude = -1;
        List<Integer> digits = new ArrayList<Integer>();
        do {
            digits.add(x % 10);
            x=x/10;
            magnitude++;
        }while(x!=0);
        System.out.println("Magnitude: "+magnitude);
        //Check for zeroes on the beggining
        for (int i = 0; i < digits.size(); i++) {
            if(digits.get(i)==0) {
                magnitude--;
                digits.remove(i);
            }
            if(digits.get(i)!=0)
                break;

        }
        System.out.println("Digits: "+digits);

            for (int i = 0; i < digits.size(); i++) {
                solution = solution + digits.get(i)*(int)Math.pow(10,magnitude);
                magnitude--;
                System.out.println("Solution: "+solution);
            }


        return solution;
    }
}