import java.util.ArrayList;
import java.util.List;

public class q9Union$$$ {

    // int[] a = {1, 3, 5, 7};   int[] b = {2, 4, 5, 6, 8}; 
    // output : Merged and Sorted List: [1, 2, 3, 4, 5, 6, 7, 8]
    
    public static List<Integer> sortedArray(int[] a, int[] b) {
        ArrayList<Integer> ans = new ArrayList<>();
        int n1 = a.length;
        int n2 = b.length;
        int i = 0;
        int j = 0;


        // Merge sorted arrays 'a' and 'b' into 'ans'
        while (i < n1 && j < n2) {
            if (a[i] <= b[j]) {
                // Add 'a[i]' to 'ans' if it's not a duplicate
                if (ans.isEmpty() || ans.get(ans.size() - 1) != a[i]) {
                    ans.add(a[i]);
                }
                i++;
            } else {
                // Add 'b[j]' to 'ans' if it's not a duplicate
                if (ans.isEmpty() || ans.get(ans.size() - 1) != b[j]) {
                    ans.add(b[j]);
                }
                j++;
            }
        }

        // Add remaining elements from 'a' if any
        while (i < n1) {
            if (ans.isEmpty() || ans.get(ans.size() - 1) != a[i]) {
                ans.add(a[i]);
            }
            i++;
        }

        // Add remaining elements from 'b' if any
        while (j < n2) {
            if (ans.isEmpty() || ans.get(ans.size() - 1) != b[j]) {
                ans.add(b[j]);
            }
            j++;
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] a = {1, 3, 5, 7};
        int[] b = {2, 4, 5, 6, 8};

        List<Integer> sortedList = sortedArray(a, b);
        System.out.println("Merged and Sorted List: " + sortedList);
    }
}
