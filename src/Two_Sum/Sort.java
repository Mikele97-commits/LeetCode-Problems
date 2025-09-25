package Two_Sum;

public class Sort {
        public static void quick(int[] arr, int left, int right) {
            int pivot = arr[right];
            System.out.println("pivot: " + pivot);
            int temp = 0;
            int i = -1;
            int j = 0;
            while (j < right) {
                if (arr[j] < pivot) {
                    i++;
                    temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
                j++;
                for(int k = 0; k < arr.length; k++) {
                }
            }

            i++;
            temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;

            for(int k = 0; k < arr.length; k++) {
                System.out.print(arr[k] + " ");
            }
            if(left < right) {
                quick(arr, left, i-1);
                quick(arr, i + 1, right);
            }

        }


    public static boolean check(int[] nums) {
        boolean sorted = true;
        for (int i = 0; i < nums.length-1; i++) {
            if (nums[i] > nums[i+1]) {
                sorted = false;
                System.out.println("Unsorted");
                break;
            }
        }
        return sorted;
    }
}
