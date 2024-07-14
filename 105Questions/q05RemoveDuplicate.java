public class q05RemoveDuplicate {
    

    // 26. Remove Duplicates from Sorted Array
    // Given an integer array nums sorted in non-decreasing order, remove the duplicates in-place such that each unique element
    //  appears only once. 
    // The relative order of the elements should be kept the same. Then return the number of unique elements in nums.

    public static void main(String[] args) {

        int[] nums = { 1, 1, 2, 2, 3, 4, 4, 4, 5 };
        int lengthAfterRemoval = removeDuplicates(nums);

        System.out.println("Array after removing duplicates:");
        for (int i = 0; i < lengthAfterRemoval; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println();

        System.out.println("Length of array after removal: " + lengthAfterRemoval);
    }
    public static int removeDuplicates(int[] nums) {
        int k = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                nums[k] = nums[i];
                k++;
            }
        }
        return k;
    }

}
