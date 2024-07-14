class q04SortedAndRotated{

    // Check if Array Is Sorted and Rotated
    //     Input: nums = [3,4,5,1,2]
    // Output: true
    // Explanation: [1,2,3,4,5] is the original sorted array.
    // You can rotate the array by x = 3 positions to begin on the the element of value 3: [3,4,5,1,2].
    public static void main(String[] args) {
        int[] arr={3,4,5,1,2};
        
        System.out.println(solution(arr));
    }
    public static boolean solution(int[] arr){
        int c=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]> arr[(i+1)%arr.length]){
                c++;
            }
            if(c>1){
                return false;
            }
        }
        return true;
    }

}