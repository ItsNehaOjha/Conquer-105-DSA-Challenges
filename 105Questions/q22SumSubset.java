import java.util.ArrayList;
import java.util.Collections;

// Subset Sums

// Input:
// n = 2
// arr[] = {2, 3}
// Output:
// 0 2 3 5
// Explanation:
// When no elements is taken then Sum = 0.
// When only 2 is taken then Sum = 2.
// When only 3 is taken then Sum = 3.
// When element 2 and 3 are taken then 
// Sum = 2+3 = 5.

class q22SubsetSum {
    static ArrayList<Integer> subsetSums(ArrayList<Integer> arr, int n) {
        ArrayList<Integer> sumSubset = new ArrayList<>();
        func(0, 0, arr, n, sumSubset);
        Collections.sort(sumSubset);
        return sumSubset;
    }

    public static void func(int ind, int sum, ArrayList<Integer> arr, int n, ArrayList<Integer> ds) {
        if (ind == n) {
            ds.add(sum);
            return;
        }
        // pick the current element
        func(ind + 1, sum + arr.get(ind), arr, n, ds);
        // do not pick the current element
        func(ind + 1, sum, arr, n, ds);
    }

    public static void main(String[] args) {
        
        ArrayList<Integer> arr = new ArrayList<>();
        Collections.addAll(arr, 1, 2, 3);
        int n = arr.size();
        ArrayList<Integer> result = subsetSums(arr, n);
        System.out.println(result);
    }
}
