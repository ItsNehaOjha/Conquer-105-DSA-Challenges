import java.util.ArrayList;
import java.util.Arrays;

public class q08MoveZeroes {
    public static void main(String[] args) {
        int[] originalArr = {1, 0, 2, 3, 0, 0, 0, 4, 5, 1};

        // Optimal solution
        int[] arr1 = originalArr.clone();
        optimalSol(arr1, arr1.length);
        System.out.println("Optimal approach: " + Arrays.toString(arr1));

        // Brute force approach
        int[] arr2 = originalArr.clone();
        bruteSol(arr2, arr2.length);
        System.out.println("Brute force approach: " + Arrays.toString(arr2));

        // Zeroes on the left
        int[] arr3 = originalArr.clone();
        zeroesinleft(arr3, arr3.length);
        System.out.println("Zeroes on the left: " + Arrays.toString(arr3));

        // Better approach
        int[] arr4 = originalArr.clone();
        moveZeroes(arr4, arr4.length);
        System.out.println("Better approach: " + Arrays.toString(arr4));
    }

    // Brute force approach
    public static void bruteSol(int[] arr, int n) {
        ArrayList<Integer> temp = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (arr[i] != 0) {
                temp.add(arr[i]);
            }
        }

        for (int i = 0; i < temp.size(); i++) {
            arr[i] = temp.get(i);
        }
        for (int i = temp.size(); i < n; i++) {
            arr[i] = 0;
        }
    }

    // Zeroes on the left
    public static void zeroesinleft(int[] arr, int n) {
        ArrayList<Integer> temp = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (arr[i] != 0) {
                temp.add(arr[i]);
            }
        }

        int lastZero = arr.length - temp.size();
        int index = 0;
        for (int i = 0; i < lastZero; i++) {
            arr[i] = 0;
            index++;
        }

        int tempI = 0;
        for (int i = index; i < arr.length; i++) {
            arr[i] = temp.get(tempI);
            tempI++;
        }
    }

    // Better approach
    public static void moveZeroes(int[] arr, int n) {
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] != 0) {
                arr[count] = arr[i];
                count++;
            }
        }
        while (count < arr.length) {
            arr[count] = 0;
            count++;
        }
    }

    // Optimal approach: Two-pointer approach
    public static void optimalSol(int[] arr, int n) {
        int i = 0, j = 1;
        while (j < n) {
            if (arr[i] == 0 && arr[j] != 0) {
                // Swap elements at i and j
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
            }
            if (arr[i] != 0) {
                i++;
            }
            j++;
        }
    }
}
