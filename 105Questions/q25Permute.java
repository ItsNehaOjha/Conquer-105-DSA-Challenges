import java.util.ArrayList;
import java.util.List;

public class q25Permute {
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
