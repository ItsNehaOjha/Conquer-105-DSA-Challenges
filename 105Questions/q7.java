import java.util.ArrayList;
import java.util.Arrays;

public class q7 {
    public static void main(String[] args) {
        // Given an array 'arr' with 'n' elements, the task is to rotate the array to the left by 'k' steps, where 'k' is non-negative.
        // BY ARRAYLIST
        ArrayList<Integer> original =new ArrayList<>(Arrays.asList(1,2,3,4,5));
        int k=2;
        ArrayList<Integer> rotated = rotateArray(original,k);
        System.out.println(rotated); 
    }
    public static ArrayList<Integer> rotateArray(ArrayList<Integer> arr, int k){
        int n=arr.size();
        ArrayList<Integer> rotated = new ArrayList<>(n);

        //cases where k might be larger than the array size
        // k = k % n;

        for(int i=0;i<n;i++){
            int newIndex= (i+k)%n ;
             // Add element to new ArrayList at rotated index
            rotated.add(arr.get(newIndex));
        }

        return rotated;
    }
}
