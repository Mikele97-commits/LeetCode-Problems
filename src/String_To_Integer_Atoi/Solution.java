package String_To_Integer_Atoi;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public static int myAtoi(String s) {
        List<Integer> list = new ArrayList<>();
        int solution=0;
        boolean notSpaceFound=false;
        boolean signFound=false;
        boolean isNegative=false;
        boolean numberFound=false;
       for (int i = 0; i < s.length(); i++) {
           if (s.charAt(i)!=32&&s.charAt(i)!=45&&s.charAt(i)!=43&&!(s.charAt(i)>=48&&s.charAt(i)<=57)) {
               break;
           }
           if(!notSpaceFound) {
               if(s.charAt(i)==32) {
                   continue;
               }
           }
           if(!signFound) {
               notSpaceFound=true;
               if(s.charAt(i)==45||s.charAt(i)==43) {
                   signFound=true;
                   if(s.charAt(i)==45) {
                       isNegative=true;
                   }
               }
           }
           if(s.charAt(i)>='0'&&s.charAt(i)<='9') {
               numberFound=true;
               System.out.println("Found number: "+s.charAt(i));
               list.add((int)s.charAt(i)-48);
           }
           if(numberFound&&(s.charAt(i)<48||s.charAt(i)>57)) {
               System.out.println("Found not number: "+s.charAt(i));
               break;
           }
       }
        System.out.println("list size: "+list.size());
        int magnitude = list.size()-1;
        for(int i=0; i<list.size(); i++) {
            if(isNegative){
            solution=solution-list.get(i)*(int)Math.pow(10, magnitude);
            magnitude--;}
            else {
                System.out.println("adding "+ list.get(i) + " times " + (int) Math.pow(10, magnitude));
                solution = solution + list.get(i) * (int) Math.pow(10, magnitude);
                magnitude--;
            }
        }
        return solution;
    }
}