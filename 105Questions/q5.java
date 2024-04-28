public class q5 {
    
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
