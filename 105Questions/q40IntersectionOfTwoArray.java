import java.util.*;

public class q40IntersectionOfTwoArray {
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 2, 1};
        int[] nums2 = {2, 2};

        int[] result = intersection(nums1, nums2);

        System.out.println(Arrays.toString(result));
    }

    public static int[] intersection(int[] A, int[] B) {
        Arrays.sort(A); // Sort the first array
        Arrays.sort(B); // Sort the second array

        int i = 0;
        int j = 0;
        int n = A.length;
        int m = B.length;
        ArrayList<Integer> ans = new ArrayList<>();

        while (i < n && j < m) {
            if (A[i] == B[j]) {
                ans.add(A[i]);
                i++;
                j++;
            } else if (A[i] < B[j]) {
                i++;
            } else {
                j++;
            }
        }

        // Convert ArrayList to int[]
        int[] res = new int[ans.size()];
        for (int k = 0; k < ans.size(); k++) {
            res[k] = ans.get(k);
        }
        return res;
    }
}
