package Two_Sum;

public class Solution {
    public static String twoSum(int[] nums, int target) {
        if(!Sort.check(nums)){
            Sort.quick(nums,0,nums.length-1);
        }

        int i=0,j=nums.length-1;
        while(i<j){
            if(nums[i]+nums[j]==target){
                String solution = "["+nums[i]+"("+i+")"+","+nums[j]+"("+j+")"+"]";
                return solution;
            }
            else if(nums[i]+nums[j]>target){
                j--;
            }
            else{
                i++;
            }
        }
        return null;
    }
}
