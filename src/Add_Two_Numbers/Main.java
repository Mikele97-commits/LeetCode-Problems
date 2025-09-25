package Add_Two_Numbers;//https://leetcode.com/problems/add-two-numbers/


public class Main {
    public static void main(String[] args) {
        int[] a = {2, 4, 7};
        int[] b = {5, 6, 4};
        int intA = 0;
        int intB = 0;
       for (int i = a.length - 1; i >= 0; i--) {
           intA += a[i]*Math.pow(10, i);
       }
        for (int i = b.length - 1; i >= 0; i--) {
            intB += b[i]*Math.pow(10, i);
        }

        int intC = intA+intB;
        System.out.println("intC: " + intC);
        int tempC = intC;
        int numberCount = 0;
        while (tempC >= 1) {
            numberCount++;
            tempC = tempC/10;
        }

        System.out.println("Number count:" + numberCount);
        int[] c = new int[numberCount];
        for (int i = c.length; i >0; i--) {
            tempC=intC;
            double number=tempC/Math.pow(10,i-1);
            System.out.println("number: " + number);
            c[i-1]=(int)number;
            intC -=(int)number*Math.pow(10,i-1);;
        }

        for (int i = 0; i < c.length; i++) {
            System.out.print(c[i] + " ");
        }
    }
}
