import java.util.Arrays;
import java.util.HashMap;

public class ArrayExercises {

    public static int[] twoSum(int[] nums, int target) {
        //Creating hashmap with integers as key and value
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        //Going through all array indexes
        for (int i = 0; i < nums.length; i++) {
            //If there already is a value in hashmap which equals to target - value of current index
            //return array with index of value in map (as array value is key and index is map value)
            // and current index
            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]), i};
            }
            //If searched value isn't in map, throws value of current place in array as key, and it's index as value
            map.put(nums[i], i);
        }
        //Since there's always a solution, this never happens
        return null;
    }

    //Used binary search approach to find cut places in both arrays, instead of merging them
    //Getting O(log(n+m)) for large arrays
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {

        if (nums1.length == 0 || nums2.length == 0) {
            if (nums1.length == nums2.length) {
                return 0;
            }
            int[] arr = (nums1.length==0) ? nums2 : nums1;
            int index=arr.length/2;
            if(arr.length % 2 == 0){
                double median= ((double)arr[index]+(double)arr[index-1])/2;
                return median;
            }else{
                return arr[index];
            }
        }

        System.out.println("nums1:"+Arrays.toString(nums1)+" \nnums2:"+Arrays.toString(nums2));

        double median=0;
        int[] shortArray;
        int[] longArray;
        if(nums1.length!=nums2.length){
         shortArray = (nums1.length<=nums2.length?nums1:nums2);
         longArray = (nums1.length>=nums2.length?nums1:nums2);
        }else{
             shortArray=nums1;
             longArray=nums2;
        }
        int maxLeft;
        int minRight;
        int length=nums1.length+nums2.length;
        int index=findIndex(shortArray, longArray);
        int jndex=((length)/2)-index;
        System.out.println("jndex:"+jndex +" index:" + index);
        int left1=(index<1) ? Integer.MIN_VALUE : shortArray[index-1];
        int left2=(jndex<1) ? Integer.MIN_VALUE : longArray[jndex - 1];
        System.out.println("Short Array:"+ Arrays.toString(shortArray)+"\nLong Array:"+ Arrays.toString(longArray));
        int right1 = (index >= shortArray.length) ? Integer.MAX_VALUE : shortArray[index];
        int right2 = (jndex >= longArray.length) ? Integer.MAX_VALUE : longArray[jndex];
        System.out.println("Left1:"+left1+"\nLeft2:"+left2+"\nRight1:"+right1+"\nRight2:"+right2);
        minRight = Math.min(right1, right2);
        maxLeft = Math.max(left1, left2);

        if(length%2==0){
            median=((double)maxLeft+(double)minRight)/2;
        }else{
            int ij=index+jndex;
            if(ij<(length/2)){
            median=(double)maxLeft;}
            else{
                median=(double)minRight;
            }
        }
        return median;
    }
    public static int findIndex(int[] shortArray, int[] longArray) {
        int l1 = shortArray.length;
        int l2 = longArray.length;


        int lo=0;
        int hi=shortArray.length;
        while (true) {
            int i = (lo + hi) / 2;
            int j = (l1 + l2) / 2 - i;
            int left1 = (i == 0) ? Integer.MIN_VALUE : shortArray[i-1];
            int right1 = (i >= shortArray.length) ? Integer.MAX_VALUE : shortArray[i];
            int left2 = (j == 0) ? Integer.MIN_VALUE : longArray[j-1];
            int right2 = (j >= longArray.length) ? Integer.MAX_VALUE : longArray[j];
                if (left1 <= right2 && right1 >= left2) {
                    System.out.println("index:"+i);
                    return i;
                } else if (left1 > right2) {
                    hi = i - 1;
                } else if (left2 > right1) {
                    lo = i + 1;
                }
            }
    }

    public static int maxArea(int[] height) {
        int pointer1=0,pointer2=height.length-1;
        int maxArea=(pointer2-pointer1)*(Math.min(height[pointer1], height[pointer2]));
        while(pointer1<pointer2){
            if(height[pointer1]<height[pointer2]){
                pointer1++;
            }else{
                pointer2--;
            }
            int newArea=(pointer2-pointer1)*(Math.min(height[pointer1], height[pointer2]));
            if(maxArea<newArea){
                maxArea=newArea;
            }
        }
        return maxArea;
    }
}
