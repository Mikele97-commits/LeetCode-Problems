import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IntExercises {
    public static int reverse(int x) {
        if(x==Integer.MIN_VALUE){
            return 0;
        }
        if(x>-10&&x<10){
            return x;
        }
        System.out.println("X=" +x);
        boolean negative = false;
        if (x < 0) {
            negative = true;
            x=-x;
        }
        int magnitude =1;
        long number=10;
        while (number<=x){
            magnitude++;
            number*=10;
        }
        System.out.println("Magnitude: "+magnitude);
        if(number>10){
            number=number/10;}
        System.out.println("number: "+number);
        int[] ciphers = new int[magnitude];
        int counter = 0;
        for (int i=magnitude;i>=1;i--){
            System.out.println("Dividing" + x + " by " + number);
            ciphers[counter]=x/(int)number;
            x=x-(ciphers[counter]*(int)number);
            number=number/10;
            counter++;
        }
        long solution=0;
        for (int i=ciphers.length-1;i>=0;i--){
            solution+=(ciphers[i]*(Math.pow(10,magnitude-1)));
            magnitude--;
        }
        if(solution>Integer.MAX_VALUE){
            return 0;
        }
        System.out.println(Arrays.toString(ciphers));
        if (negative){
            solution=-solution;
        }

        return (int)solution;
    }

    public static int myAtoi(String s) {
        long solution=0;
        int i=0;
        boolean negative = false;
        boolean numberFound = false;
        boolean signFound = false;
        while (i<=s.length()-1){
            char c = s.charAt(i);
            if(c==' '||c=='+'){
                if(signFound){
                    break;
                }
                if(c=='+'){
                    signFound=true;
                }
                if(numberFound){
                    break;
                }
                i++;
                continue;
            }
            if(c=='-'){
                if(signFound){
                    break;
                }
                if(numberFound){
                    break;
                }
                negative=true;
                i++;
                signFound=true;
                continue;
            }

            if(c<48||c>57){
                break;
            }
            solution=solution*10+c-48;
            if(solution>Integer.MAX_VALUE){
                break;
            }
            numberFound=true;
            i++;
        }
        if(solution>Integer.MAX_VALUE){
            if(negative){
                return Integer.MIN_VALUE;
            }
            return Integer.MAX_VALUE;
        }
        if(negative){
            solution=-solution;
        }
        return (int) solution;
    }

    public static boolean isPalindrome(int x) {
        if (x < 0){
            return false;
        }
        String number = Integer.toString(x);
        int pointer1=0;
        int pointer2=number.length()-1;
        while (pointer1<pointer2){
            if(number.charAt(pointer1)!=number.charAt(pointer2)){
                return false;
            }
            pointer1++;
            pointer2--;
        }

        return true;
    }

    public static String intToRoman (int num){
        int thousands=num/1000;
        int hundreds=(num-thousands*1000)/100;
        int tens=(num-thousands*1000-hundreds*100)/10;
        int ones=num%10;
        System.out.println(thousands+ " "+hundreds+ " "+tens+ " "+ones);
        StringBuilder sb = new StringBuilder();
        sb.append("M".repeat(Math.max(0, thousands)));
        switch(hundreds){
            case 1:
            case 2:
            case 3:
            {
                sb.append("C".repeat(hundreds));
            }
            break;
            case 4:
                sb.append("CD");
                break;
            case 5:
            case 6:
            case 7:
            case 8:
                sb.append("D");
                sb.append("C".repeat(hundreds - 5));
                break;
            case 9:
                sb.append("CM");
        }
        switch(tens){
            case 1:
            case 2:
            case 3:
            {
                sb.append("X".repeat(tens));
            }
            break;
            case 4:
                sb.append("XL");
                break;
            case 5:
            case 6:
            case 7:
            case 8:
                sb.append("L");
                sb.append("X".repeat(tens - 5));
                break;
            case 9:
                sb.append("XC");
        }
        switch(ones){
            case 1:
            case 2:
            case 3:
            {
                sb.append("I".repeat(ones));
            }
            break;
            case 4:
                sb.append("IV");
                break;
            case 5:
            case 6:
            case 7:
            case 8:
                sb.append("V");
                sb.append("I".repeat(ones - 5));
                break;
            case 9:
                sb.append("IX");
        }

        return sb.toString();
    }

    public static int romanToInt(String s) {
        List<Integer> numbers = new ArrayList<Integer>();
        for (int i = 0; i < s.length(); i++) {
            switch (s.charAt(i)) {
                case 'I':
                    numbers.add(1);
                    break;
                case 'V':
                    numbers.add(5);
                    break;
                case 'X':
                    numbers.add(10);
                    break;
                case 'L':
                    numbers.add(50);
                    break;
                case 'C':
                    numbers.add(100);
                    break;
                case 'D':
                    numbers.add(500);
                    break;
                case 'M':
                    numbers.add(1000);
                    break;
            }
        }
        int answer = 0;
        for (int i = 0; i < numbers.size(); i++) {
            if(i<numbers.size()-1){
                if(numbers.get(i)<numbers.get(i+1)){
                    answer += numbers.get(i+1)-numbers.get(i);
                    i++;
                    continue;
                }
                answer+=numbers.get(i);
                continue;
            }
            answer += numbers.get(i);
        }
        return answer;
    }
}
