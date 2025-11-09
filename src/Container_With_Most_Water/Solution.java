package Container_With_Most_Water;

public class Solution {
   public static int solution(int[] array) {
       int pointer1=0,pointer2= array.length-1;
       int mostWater=0;
       int temp;
       while(pointer1<pointer2){
           if(array[pointer1]==array[pointer2]||array[pointer1]<array[pointer2]){
               temp=array[pointer1]*(pointer2-pointer1);
               if(temp>mostWater)
                   mostWater=temp;
               pointer1++;
           }
           if(array[pointer1]>array[pointer2]){
               temp=array[pointer2]*(pointer2-pointer1);
               if(temp>mostWater)
                   mostWater=temp;
               pointer2--;
           }

       }
       return mostWater;
   }
}
