import java.util.ArrayList;
import java.util.Arrays;
     // -------------rotate array by d----------(two approach)
public class q07RotateArray{
    public static void main(String[] args) {
        // Given an array 'arr' with 'n' elements, the task is to rotate the array to the left by 'k' steps, where 'k' is non-negative.
        // BY ARRAYLIST
        ArrayList<Integer> original =new ArrayList<>(Arrays.asList(1,2,3,4,5));
        int k=3;
        ArrayList<Integer> rotated = rotateArray(original,k);
        System.out.println(rotated); 
        //by array
        int[] arr = {1, 2, 3, 4, 5};
        int d = 3;
        rotateArray(arr, d);
        System.out.println("Rotated Array: " + Arrays.toString(arr));
    } 
    
    public static void rotateArray(int[] arr, int d) {
        int n = arr.length;
        // Handle cases where d might be larger than the array length
        d = d % n;

        // Rotate the entire array using reversal technique
        reverseArray(arr, 0, d - 1);       // Reverse the first segment (0 to d-1)
        reverseArray(arr, d, n - 1);             // Reverse the second segment (d to n-1)
        reverseArray(arr, 0, n - 1);       // Reverse the entire array (0 to n-1)
    }
    private static void reverseArray(int[] arr, int start, int end) {
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
    public static ArrayList<Integer> rotateArray(ArrayList<Integer> arr, int k){
        int n=arr.size();
        ArrayList<Integer> rotated = new ArrayList<>(n);

        for(int i=0;i<n;i++){
            int newIndex= (i+k)%n ;
             // Add element to new ArrayList at rotated index
            rotated.add(arr.get(newIndex));
        }

        return rotated;
    }
}
