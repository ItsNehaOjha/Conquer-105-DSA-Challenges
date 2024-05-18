import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 90. Subsets II
// Given an integer array nums that may contain duplicates, return all possible 
// subsets
//  (the power set).
// The solution set must not contain duplicate subsets. Return the solution in any order.
// Example 1:
// Input: nums = [1,2,2]
// Output: [[],[1],[1,2],[1,2,2],[2],[2,2]]

public class q23SubsetII {
    public static void main(String[] args) {
        int[] nums = {1, 2, 2};
        q23SubsetII solution = new q23SubsetII();
        List<List<Integer>> result = solution.subsetsWithDup(nums);
        for (List<Integer> subset : result) {
            System.out.println(subset);
        }
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums); // Sort the array to handle duplicates
        List<List<Integer>> ans = new ArrayList<>();
        findSubset(0, nums, new ArrayList<>(), ans);
        return ans;
    }

    public void findSubset(int ind, int[] nums, List<Integer> ds, List<List<Integer>> ans) {
        ans.add(new ArrayList<>(ds)); // Add the current subset to the answer list for the blank subset
        for (int i = ind; i < nums.length; i++) {   //implicit BASE CASE 
            // Skip duplicates
            if (i != ind && nums[i] == nums[i - 1]) continue;
            ds.add(nums[i]); 
            findSubset(i + 1, nums, ds, ans); 
            ds.remove(ds.size() - 1); // Backtrack and remove the last element
        }
    }
}
