public class q02LargestElement {
    public static void main(String[] args) {
        int arr[] = {2, 5, 1, 3, 0};
        
        // Initialize max to the first element of the array
        int max = arr[0];
        
        for (int i = 1; i < arr.length; i++) { // Start from the second element
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        
        System.out.println("The largest element is: " + max);
    }
}
