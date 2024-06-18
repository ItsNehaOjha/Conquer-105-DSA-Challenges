import java.util.ArrayList;
import java.util.List;

// Input: candidates = [2,3,6,7], target = 7
// Output: [[2,2,3],[7]]
// Explanation:
// 2 and 3 are candidates, and 2 + 2 + 3 = 7. Note that 2 can be used multiple times.
// 7 is a candidate, and 7 = 7.
// These are the only two combinations.

public class q20CombSumI {
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        func(0, candidates, target, ans, new ArrayList<>());
        return ans;
    }
    
    public static void func(int ind, int[] arr, int target, List<List<Integer>> ans, List<Integer> ds) {
        // base case
        if (ind == arr.length) {
            if (target == 0) {
                ans.add(new ArrayList<>(ds));
            }
            return;
        }
        
        // pick condition
        if (arr[ind] <= target) {
            ds.add(arr[ind]);
            func(ind, arr, target - arr[ind], ans, ds);
            ds.remove(ds.size() - 1);
        }
        
        // not pick condition
        func(ind + 1, arr, target, ans, ds);
    }

    public static void main(String[] args) {
        
        int[] candidates = {2, 3, 6, 7};
        int target = 7;
        List<List<Integer>> result = combinationSum(candidates, target);
        System.out.println("Combination Sum for target " + target + ":");
        for (List<Integer> combination : result) {
            System.out.println(combination);
        }
    }

}
