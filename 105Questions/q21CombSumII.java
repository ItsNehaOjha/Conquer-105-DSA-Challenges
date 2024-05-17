import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class q21CombSumII {
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(candidates);
        func(0, candidates, target, ans, new ArrayList<>());
        return ans;
    }
    
    public static void func(int ind, int[] arr, int target, List<List<Integer>> ans, List<Integer> ds) {
        // base case
       
        if (target == 0) {
            ans.add(new ArrayList<>(ds));
            return;
        }
       
        for(int i=ind; i<arr.length;i++){
            if(i>ind && arr[i]== arr[i-1]) continue;

            if(arr[i]>target) break;
            ds.add(arr[i]);
            func(i + 1, arr, target-arr[i], ans, ds);
            ds.remove(ds.size()-1);

        }
    }

    public static void main(String[] args) {
        
        int[] candidates = {1,1,1,2,2};
        int target = 4;
        List<List<Integer>> result = combinationSum(candidates, target);
        System.out.println("Combination Sum for target " + target + ":");
        for (List<Integer> combination : result) {
            System.out.println(combination);
        }
    }

}
