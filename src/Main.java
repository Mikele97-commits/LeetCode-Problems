import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        ArrayList<Character> substring = new ArrayList<>();
        ArrayList<Character> finalSubstring = new ArrayList<>();
       for (int i = 0; i < s.length(); i++) {
           substring.add(s.charAt(i));
           for (int j =0; j < substring.size(); j++) {

               if ((i<s.length()-1 &&substring.get(j) == s.charAt(i+1)) || (i==s.length()-1) ) {
                   if(substring.size()>finalSubstring.size()){
                       System.out.println("found bigger substring:" + substring +"\nReplacing old substring:" + finalSubstring);
                       finalSubstring.clear();
                       finalSubstring.addAll(substring);
                       substring.clear();
                       System.out.println("New substring:" + finalSubstring);
                   }
                   else
                       substring.clear();
               }
           }
       }

        System.out.println(finalSubstring);
    }
}
