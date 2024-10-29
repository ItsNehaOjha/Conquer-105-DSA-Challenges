import java.util.ArrayList;
import java.util.List;

public class q25Permute {

// 46. Permutations
// Given an array nums of distinct integers, return all the possible permutations. You can return the answer in any order.
// Example 1:
// Input: nums = [1,2,3]
// Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]


    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        List<List<Integer>> result = permute(nums);
        for (List<Integer> permutation : result) {
            System.out.println(permutation);
        }
    }

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        recurPermute(0, nums, ans);
        return ans;
    }

    private static void recurPermute(int ind, int[] nums, List<List<Integer>> ans) {
        // Base case
        if (ind == nums.length) {
            List<Integer> ds = new ArrayList<>();
            for (int i = 0; i < nums.length; i++) {
                ds.add(nums[i]);
            }
            ans.add(new ArrayList<>(ds));
            return;
        }
        for (int i = ind; i < nums.length; i++) {
            swap(i, ind, nums);
            recurPermute(ind + 1, nums, ans);
            // Reswap to backtrack
            swap(i, ind, nums);
        }
    }

    private static void swap(int n1, int n2, int[] nums) {
        int temp = nums[n1];
        nums[n1] = nums[n2];
        nums[n2] = temp;
    }




    
}
