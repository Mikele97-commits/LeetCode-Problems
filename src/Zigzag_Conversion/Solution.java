package Zigzag_Conversion;

import java.util.ArrayList;

public class Solution {
    public static String convert(String string, int numRows) {
        int pointerLetter =0;
        int pointerRow =0;
        ArrayList<Character>[] letters = new ArrayList[numRows];
        for (int i = 0; i < numRows; i++) {
            letters[i] = new ArrayList<>();
        }
        boolean shift=false;
       do {

           if(!shift){
                letters[pointerRow].add(string.charAt(pointerLetter));
                System.out.println("Adding "+string.charAt(pointerLetter) + " to row " + pointerRow + "(down");
                pointerLetter++;
                pointerRow++;
                if(pointerRow==numRows){
                    pointerRow=pointerRow-2;
                    shift=true;
                }
           }
           else{
               letters[pointerRow].add(string.charAt(pointerLetter));
               System.out.println("Adding "+string.charAt(pointerLetter) + " to row " + pointerRow + "(up)");
               pointerLetter++;
               pointerRow--;
               if(pointerRow==-1){
                   pointerRow=pointerRow+2;
                   shift=false;
               }
           }
       }while(pointerLetter < string.length());

       StringBuilder output = new StringBuilder();
       for(int i=0;i<numRows;i++){
           for(int j=0;j<letters[i].size();j++){
               output.append(letters[i].get(j));
           }
       }

        return output.toString();
    }
}
