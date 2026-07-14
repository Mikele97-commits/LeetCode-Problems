
import java.util.*;


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

    public static String longestCommonPrefix(String[] strs) {
        int shortestLength = strs[0].length();
        for (int i = 1; i < strs.length; i++) {
            if (strs[i].length() < shortestLength) {
                shortestLength = strs[i].length();
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < shortestLength; i++) {
            for(int j = 1; j < strs.length; j++) {
                if (strs[0].charAt(i) != strs[j].charAt(i)) {
                    return sb.toString();
                }
            }
            sb.append(strs[0].charAt(i));
        }

        return sb.toString();
    }


    public static List<String> letterCombinations(String digits) {

        ArrayList<Integer> numbers = new ArrayList<>();
        for(int i = 0; i<digits.length(); i++){
            numbers.add((int)digits.charAt(i)-'0');
        }
        char[] two={'a','b','c'};
        char[] three={'d','e','f'};
        char[] four={'g','h','i'};
        char[] five={'j','k','l'};
        char[] six={'m','n','o'};
        char[] seven={'p','q','r','s'};
        char[] eight={'t','u','v'};
        char[] nine={'w','x','y','z'};
        List<char[]> digitsList = new ArrayList<>();
        for(int i = 0; i<digits.length(); i++){
            switch(numbers.get(i)){
                case 2: digitsList.add(two); break;
                case 3: digitsList.add(three); break;
                case 4: digitsList.add(four); break;
                case 5: digitsList.add(five); break;
                case 6: digitsList.add(six); break;
                case 7: digitsList.add(seven); break;
                case 8: digitsList.add(eight); break;
                case 9: digitsList.add(nine); break;
            }
        }
        switch(digits.length()){
            case 1:return lCOne(digitsList);
            case 2:return lCTwo(digitsList);
            case 3:return lCThree(digitsList);
            case 4:return lCFour(digitsList);
        }
        return null;
    }
    public static List<String> lCOne(List<char[]> digits) {
        List<String> result = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i<digits.get(0).length; i++){
            sb.append(digits.get(0)[i]);
            result.add(sb.toString());
            sb.delete(0, sb.length());
        }
        return result;
    }
    public static List<String> lCTwo(List<char[]> digits) {
        List<String> result = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i<digits.get(0).length; i++){
            for(int j = 0; j<digits.get(1).length; j++){
                sb.append(digits.get(0)[i]).append(digits.get(1)[j]);
                result.add(sb.toString());
                sb.delete(0, sb.length());
            }
        }
        return result;
    }
    public static List<String> lCThree(List<char[]> digits) {
        List<String> result = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i<digits.get(0).length; i++){
            for(int j = 0; j<digits.get(1).length; j++){
                for(int k = 0; k<digits.get(2).length; k++) {
                    sb.append(digits.get(0)[i]).append(digits.get(1)[j]).append(digits.get(2)[k]);
                    result.add(sb.toString());
                    sb.delete(0, sb.length());
                }
            }
        }
        return result;
    }
    public static List<String> lCFour(List<char[]> digits) {
        List<String> result = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i<digits.get(0).length; i++){
            for(int j = 0; j<digits.get(1).length; j++){
                for(int k = 0; k<digits.get(2).length; k++) {
                    for(int l = 0; l<digits.get(3).length; l++) {
                        sb.append(digits.get(0)[i]).append(digits.get(1)[j]).append(digits.get(2)[k]).append(digits.get(3)[l]);
                        result.add(sb.toString());
                        sb.delete(0, sb.length());
                    }
                }
            }
        }
        return result;
    }

    public static boolean isValid(String s) {
        if(s.length()<2) return false;
        char[] chars= s.toCharArray();
        Map<Character, Character> pairs = new HashMap<>();
        pairs.put('(', ')');
        pairs.put('[', ']');
        pairs.put('{', '}');
        Stack<Character> openings = new Stack<>();
        for (char aChar : chars) {
            if (pairs.containsKey(aChar)) {
                openings.push(aChar);
            } else if (openings.isEmpty()) {
                return false;
            } else if (aChar == pairs.get(openings.peek())) {
                openings.pop();
            } else {
                return false;
            }
        }
        return openings.isEmpty();
    }

}
