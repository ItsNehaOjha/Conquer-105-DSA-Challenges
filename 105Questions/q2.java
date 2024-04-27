public class q2 {
    public static void main(String[] args) {
        // Given an array, we have to find the largest element in the array.
        //  arr[] = {2,5,1,3,0}; Output: 5

        int arr[] = {2,5,1,3,0};
        int max =0;
        for(int i=0;i<arr.length-1;i++){
            if(arr[i]>arr[i+1]){
                if(arr[i]>max){
                    max = arr[i];
                }
            }
        }
        System.err.println(max);
    }
}
