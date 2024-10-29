class q56MergeSOrt {
    
//     912. Sort an Array
// Given an array of integers nums, sort the array in ascending order and return it.
// You must solve the problem without using any built-in functions in O(nlog(n)) time complexity and with the smallest space 
// complexity possible.

// Input: nums = [5,2,3,1]
// Output: [1,2,3,5]
// Explanation: After sorting the array, the positions of some numbers are not changed (for example, 2 and 3),
//  while the positions of other numbers are changed (for example, 1 and 5).
    
    
    public int[] sortArray(int[] nums) {
        mergeSort(nums, 0, nums.length - 1);
        return nums;
    }

    private void mergeSort(int[] nums, int low, int high) {
        if (low >= high) {
            return;
        }
        int mid = low + (high - low) / 2;
        mergeSort(nums, low, mid);
        mergeSort(nums, mid + 1, high);
        merge(nums, low, mid, high);
    }

    private void merge(int[] arr, int s, int m, int e) {
        int[] mix = new int[e - s + 1];
        int i = s;
        int j = m + 1;
        int k = 0;
        
        while (i <= m && j <= e) {
            if (arr[i] <= arr[j]) {
                mix[k] = arr[i];
                i++;
            } else {
                mix[k] = arr[j];
                j++;
            }
            k++;
        }
        
        while (i <= m) {
            mix[k] = arr[i];
            i++;
            k++;
        }
        
        while (j <= e) {
            mix[k] = arr[j];
            j++;
            k++;
        }
        
        for (int l = 0; l < mix.length; l++) {
            arr[s + l] = mix[l];
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {5, 2, 3, 1};
        int[] sortedNums = solution.sortArray(nums);
        for (int num : sortedNums) {
            System.out.print(num + " ");
        }
    }
}

