import java.util.Arrays;
import java.util.HashMap;

public class StringExercises {
    public static int lengthOfLongestSubstring(String s) {
        int counter = 0;
        int finalcounter = 0;
        int start = 0;
        int end = 0;
        int step = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        while (end < s.length()) {
            step++;

            if (map.containsKey(s.charAt(end))&&map.get(s.charAt(end)) >=start) {
                System.out.println("Step: " + step+" Found the same character'"+s.charAt(end)+"' at index: " + end+". Saving counter: " + counter);
                start=map.get(s.charAt(end))+1;
                map.put(s.charAt(end), end);
                if (counter>finalcounter) {
                    System.out.println("Counter " + counter + " is greater than finalcounter " + finalcounter);
                    finalcounter = counter;
                }
                end++;
                counter = end-start;
            }else {
                System.out.println("Step: " + step + ". End got to position: " + end+"w ith letter: " + s.charAt(end)+". Counter: " + counter);
                map.put(s.charAt(end), end);
                end++;
                counter++;
            }
        }
        if (counter>finalcounter) {
            finalcounter = counter;
        }
        return finalcounter;
    }

    public static String longestPalindrome(String s) {
        if (s.length() == 1) {
            return s;
        }

        if(s.length() == 2) {
            if (s.charAt(0) == s.charAt(1)) {
                return s;
            }else{
                return s.substring(0,1);
            }
        }
        String longest = "";
        String current = "";
        StringBuilder builder = new StringBuilder();
       //Check for odd-length palindrome
        for (int i = 0; i < s.length(); i++) {
            System.out.println("Checking " + i + " letter");
            int index1=i, index2=i;
            while(index1>=0 && index2<s.length()){
                if(s.charAt(index1)==s.charAt(index2)){
                    System.out.println("Goes for " + i + " letter");
                    index1--;
                    index2++;
                } else {
                    for(int j=index1+1; j<index2; j++){
                        builder.append(s.charAt(j));
                    }
                    current=builder.toString();

                    if(current.length()>longest.length()){
                        longest=current;
                    };
                    builder = new StringBuilder();
                    break;
                }
                if(index1<0 || index2==s.length()){
                    for(int j=index1+1; j<index2; j++){
                        builder.append(s.charAt(j));
                    }
                    current=builder.toString();

                    if(current.length()>longest.length()){
                        longest=current;
                    };
                    builder = new StringBuilder();
                    break;
                }
            }
        }

        //Check for even-length palindrome
        for(int i=1; i<s.length(); i++){
            if(s.charAt(i)==s.charAt(i-1)){
                int index1=i-1, index2=i;
                while(index1>=0 && index2<s.length()){
                    if(s.charAt(index1)==s.charAt(index2)){
                        index1--;
                        index2++;
                    }else{
                        for(int j=index1+1; j<index2; j++){
                            builder.append(s.charAt(j));
                        }
                        current=builder.toString();

                        if(current.length()>longest.length()){
                            longest=current;
                        };
                        builder = new StringBuilder();
                        break;
                    }
                    if(index1<0 || index2==s.length()){
                        for(int j=index1+1; j<index2; j++){
                            builder.append(s.charAt(j));
                        }
                        current=builder.toString();

                        if(current.length()>longest.length()){
                            longest=current;
                        };
                        builder = new StringBuilder();
                        break;
                    }
                }
            }
        }
        return longest;
    }

    public static String zigzag(String s, int numRows) {

        if (numRows == 1) {
            return s;
        }
        if (s.length() == 1|| s.length()==2) {
            return s;
        }



        if(s.length()<=numRows){
            return s;
        }
        Character[][] matrix = new Character[numRows][s.length()];


        int counter = 0;
        int row = 0;
        int col = 0;
        boolean switchDirection=false;
        while(counter<s.length()){
            if(!switchDirection){
                matrix[row][col] = s.charAt(counter);
                counter++;
                if(row+1==numRows){
                    switchDirection=true;
                }else {
                    row++;
                }
            }

            if (switchDirection) {
                if(counter==s.length()){
                    break;
                }
                row--;
                col++;
                matrix[row][col] = s.charAt(counter);

                counter++;
                if (row==0){
                    row++;
                    switchDirection=false;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<numRows; i++){
            for(int j=0; j<matrix[i].length; j++){
                if(matrix[i][j]!=null){
                    sb.append(matrix[i][j]);
                }
            }
        }
        String zigzag = sb.toString();
        return zigzag;
    }
}
