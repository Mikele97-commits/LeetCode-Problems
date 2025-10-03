package Median_Of_Two_Sorted_Arrays;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of elements in the first array");
        int n1=sc.nextInt();
        int[] nums1=new int[n1];
        System.out.println("Enter the number of elements in the second array");
        int n2=sc.nextInt();
        int[] nums2=new int[n2];
        System.out.println("Enter the elements of the first array");
        for (int i=0;i<n1;i++){
           nums1[i]=sc.nextInt();
        }
        System.out.println("Enter the elements of the second array");
        for (int i=0;i<n2;i++){
            nums2[i]=sc.nextInt();
        }
        int point1=0,point2=0,point3=0;
        int n3=n1+n2;
        int[] nums3=new int[n3];
        do{
            if (nums1[point1]<nums2[point2]){
                nums3[point3]=nums1[point1];
                point1++;
                point3++;
            }
            else if (nums1[point1]>nums2[point2]){
                nums3[point3]=nums2[point2];
                point2++;
                point3++;
            }
        }while(point1<n1 && point2<n2);

        if (point1<n1){
            for (int i=point1;i<n1;i++){
                nums3[point3]=nums1[i];
                point3++;
            }
        }
        if (point2<n2){
            for (int i=point2;i<n2;i++){
                nums3[point3]=nums2[i];
                point3++;
            }
        }
        System.out.println("Merged Array is:");
        for (int i=0;i<n3;i++){
            System.out.print(nums3[i]+" ");
        }


        double Median;
    if (n3%2>0){
        Median=nums3[(n3 / 2)];
    }
    else{
        Median= (double) (nums3[n3 / 2] + nums3[(n3 / 2) - 1]) /2;
    }
        System.out.println("Median is "+Median);
    }
}
