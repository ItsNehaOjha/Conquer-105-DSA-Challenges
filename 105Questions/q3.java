public class q3 {
    public static void main(String[] args) {
        // Given an array, find the second smallest and second largest element in the array. Print ‘-1’ in the event that either of them doesn’t exist.
//         Input:
//  [1,2,4,7,7,5]
//          Output:
//  Second Smallest : 2
// 	Second Largest : 5

        int[] arr= {1,2,4,7,7,5};
        int n=6;
        int max=0;
        int min=0;
        
        for(int i=0;i< n;i++){
            if(arr[0] != arr[1]){
                min=arr[1];
            }
            if(arr[n-2]!=arr[n-1]){
                max = arr[n-2];
            }
        }
   
        System.out.println(min);
        System.out.println(max);

        
    }

    public static int[] sort(int[] arr,int n){

        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            // Swap arr[i] with the minimum element found
            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }
        return arr;
       }

      

    }

