import java.util.*;



// 77. Combinations
// Given two integers n and k, return all possible combinations of k numbers chosen from the range [1, n]. You may return the answer in any order.

// Input: n = 4, k = 2
// Output: [[1,2],[1,3],[1,4],[2,3],[2,4],[3,4]]


public class q49Combination {
    public static void main(String[] args) {
        int n = 4;
        int k = 2;
        List<List<Integer>> result = combine(n, k);
        System.out.println(result);
    }

    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        generateComb(1, n, k, new ArrayList<Integer>(), result);
        return result;
    }

    private static void generateComb(int start, int n, int k, List<Integer> combination, List<List<Integer>> result) {
        if (k == 0) {
            result.add(new ArrayList<>(combination));
            return;
        }
        for (int i = start; i <= n - k + 1; i++) {
            combination.add(i);
            generateComb(i + 1, n, k - 1, combination, result);
            combination.remove(combination.size() - 1);
        }
    }
}
