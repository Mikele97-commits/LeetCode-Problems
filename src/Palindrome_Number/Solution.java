package Palindrome_Number;

public class Solution {
    public static boolean solution(int num) {
        if (num < 0)
            return false;

        int magnitude=0;
        int temp= num;
        do {
            temp=temp/10;
            magnitude++;
        }while(temp!=0);
        System.out.println(magnitude);
        int[] arrayedNumber = new int[magnitude];
        int pointer1=0;
        int pointer2=magnitude-1;

        do{
           arrayedNumber[pointer1]=num/(int)Math.pow(10,magnitude-1);
            num=num-arrayedNumber[pointer1]*(int)Math.pow(10,magnitude-1);
           pointer1++;
           magnitude--;
        }while(magnitude>0);

        pointer1=0;
        boolean isPalindrome = true;
        do{
            if (arrayedNumber[pointer1]!=arrayedNumber[pointer2]){
                isPalindrome = false;
                break;
            }
            pointer1++;
            pointer2--;
        }while(pointer1<pointer2);


        return isPalindrome;
    }
}
