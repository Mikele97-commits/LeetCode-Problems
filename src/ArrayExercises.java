import java.util.*;

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

    public static List<List<Integer>> threeSum(int[] nums) {
        HashSet<List<Integer>> tripletsSet = new HashSet<>();
        List<List<Integer>> triplets=new ArrayList<>();
        HashSet<Integer> integerSet=new HashSet<>();
        for(int j=0;j<nums.length;j++){
            integerSet.clear();
            for (int i = 0; i < nums.length; i++){
                if(i==j){
                    continue;
                }
               if(integerSet.contains(-(nums[j]+nums[i]))){
                   List<Integer> list=new ArrayList<>();
                   list.add(nums[j]);
                   list.add(nums[i]);
                   list.add(-(nums[j]+nums[i]));
                   list.sort(Integer::compareTo);
                   if(!tripletsSet.contains(list)){
                       tripletsSet.add(list);
                       triplets.add(list);
                   }
                   while(i<nums.length-2&&nums[i]==nums[i+1]){
                       i++;
                   }
               }
               integerSet.add(nums[i]);
            }
        }
        return triplets;
    }

    public static int threeSumClosest(int[] nums, int target) {
        int p1=0, p2=1,p3=nums.length-1;
        int smallest=Integer.MAX_VALUE;
        int answer=0;
        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums));
        while(p1<=nums.length-3){
            while(p2<p3){
                System.out.println("p1+p2+p3="+(nums[p1]+nums[p2]+nums[p3]));

              if(nums[p1]+nums[p2]+nums[p3]==target){
                  System.out.println("Here");
                  return target;
              }
              if(smallest>Math.abs(target-(nums[p1]+nums[p2]+nums[p3]))){
                  System.out.println("smallest before="+smallest);
                  smallest=Math.abs(target-(nums[p1]+nums[p2]+nums[p3]));
                  System.out.println("smallest after="+smallest);
                  answer=nums[p1]+nums[p2]+nums[p3];
                  //System.out.println("current answer="+answer +" because nums[p1]:" + nums[p1] + " nums[p2]:"+ nums[p2] + " nums[p3]:"+nums[p3]);
              }
                if(nums[p1]+nums[p2]+nums[p3]<target){
                    //System.out.println("get higher");
                    p2++;
                }
                if(nums[p1]+nums[p2]+nums[p3]>target){
                    //System.out.println("get lower");
                    p3--;
                }
            }
            p1++;
            p2=p1+1;
            p3=nums.length-1;
            System.out.println("Going next step: p1="+p1+" p2="+p2+" p3="+p3);
        }
        return answer;
    }

    public static List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> ans=new ArrayList<>();
        int highest=Integer.MIN_VALUE;
        int index=Integer.MIN_VALUE;
        for(int i=0;i<candies.length;i++){
            if(candies[i]>highest){
                highest=candies[i];
                index=i;
            }
        }

        for(int i=0;i<candies.length;i++){
            if(i==index){
                ans.add(true);
                continue;
            }
            if(candies[i]+extraCandies>=highest){
                ans.add(true);
            }else {
                ans.add(false);
            }

        }
        return ans;
    }

    public static boolean canPlaceFlowers(int[] flowerbed, int n) {

        if(flowerbed.length==1){
            if(flowerbed[0]==0||n==0){
                return true;
            }else {
                return false;
            }
        }
        if(flowerbed[0]==0&&flowerbed[1]==0){
            n--;
            flowerbed[0]=1;
        }
        for(int i=1;i<=flowerbed.length-2;i++){
            if(flowerbed[i-1]==0&&flowerbed[i+1]==0&&flowerbed[i]==0){
                n--;
                flowerbed[i]=1;
            }
        }
        if(flowerbed[flowerbed.length-1]==0&&flowerbed[flowerbed.length-2]==0){
            n--;
            flowerbed[flowerbed.length-1]=1;
        }
        return n <= 0;
    }

    public static int[] productExceptSelf(int[] nums) {
        int[] left = new int[nums.length];
        int[] right = new int[nums.length];
        int temp=1;
        for(int i=0;i<nums.length;i++){
            temp=temp*nums[i];
            left[i]=temp;
        }
        temp=1;
        for(int i=nums.length-1;i>0;i--){
            temp=temp*nums[i];
            right[i]=temp;
        }
        int[] ans=new int[nums.length];
        for(int i=0;i<nums.length;i++){
            if(i==0){
                ans[i]=right[i+1];
            }else if(i==nums.length-1){
                ans[i]=left[i-1];
            }else {
                ans[i] = left[i - 1] * right[i + 1];
            }
        }
        return ans;
    }

    public static boolean increasingTriplet(int[] nums) {
        int smallest=nums[0];
        int medium=Integer.MAX_VALUE;

        for(int i=1;i<nums.length;i++){
           if(nums[i]>medium){
               return true;
           }else if(nums[i]<medium&&nums[i]>smallest){
               medium=nums[i];
           }else if(nums[i]<smallest){
               smallest=nums[i];
           }
        }


        return false;
    }


}
