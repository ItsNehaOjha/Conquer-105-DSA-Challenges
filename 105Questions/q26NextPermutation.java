public class q26NextPermutation {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        nextPermutation(arr);
        for (int num : arr) {
            System.out.print(num + " ");
        }
        // Expected output: 1 3 2
    }

    public static void nextPermutation(int[] arr) {
        int n = arr.length;
        int ind = -1;

        // Find the first decreasing element from the end
        for (int i = n - 2; i >= 0; i--) {
            if (arr[i] < arr[i + 1]) {
                ind = i;
                break;
            }
        }

        // If no such element is found, the array is the highest permutation
        if (ind == -1) {
            reverse(arr, 0, n - 1);
            return;
        }

        // Find the next larger element to swap with arr[ind]
        for (int i = n - 1; i > ind; i--) {
            if (arr[i] > arr[ind]) {
                swap(arr, i, ind);
                break;
            }
        }

        // Reverse the elements from ind + 1 to the end of the array
        reverse(arr, ind + 1, n - 1);
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private static void reverse(int[] arr, int i, int j) {
        while (i < j) {
            swap(arr, i, j);
            i++;
            j--;
        }
    }
}
