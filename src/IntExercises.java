import java.math.BigInteger;
import java.util.Arrays;

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
}
