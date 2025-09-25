package Largets_3_Same_Digit_Number_In_String;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static String largestGoodInteger(String num) {

        String goodInt="";
        List<String> goodInts = new ArrayList<String>();
        char[] digits = num.toCharArray();
        for (int i =0; i < digits.length; i++) {
            System.out.println(digits[i]);
           if(i<digits.length-2){
               if (digits[i]==digits[i+1]&&digits[i]==digits[i+2]){
                   goodInt += digits[i];
                   goodInt += digits[i+1];
                   goodInt += digits[i+2];
                   goodInts.add(goodInt);
                   goodInt = "";
                   i+=2;
               }
           }
        }

        for (String s : goodInts) {
            System.out.println(s);
        }

        return null;
    }
}
