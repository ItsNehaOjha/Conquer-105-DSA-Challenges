import java.util.ArrayList;

public class subsequence {
    public static void printS(int ind, ArrayList<Integer> ds, int s, int sum, int arr[], int n) {
        if (ind == n) {
            if (s == sum) {
                for (int i : ds) {
                    System.out.print(i + " ");
                }
                System.out.println();
            }
            return;  // Ensure to return from here to stop further execution.
        }

        // Include the current element
        ds.add(arr[ind]);
        s += arr[ind];
        printS(ind + 1, ds, s, sum, arr, n);

        // Exclude the current element (backtrack)
        ds.remove(ds.size() - 1);
        s -= arr[ind];
        printS(ind + 1, ds, s, sum, arr, n);
    }

    public static void main(String[] args) {
        int arr[] = {1, 2, 1};
        int n = arr.length;
        int sum = 2;
        ArrayList<Integer> ds = new ArrayList<>();
        printS(0, ds, 0, sum, arr, n);
    }
}
