public class q3 {

    // Method to find the second smallest and second largest elements in the array
      // Given an array, find the second smallest and second largest element in the array. Print ‘-1’ in the event that either of them doesn’t exist.
    //         Input:
    //  [1,2,4,7,7,5]
    //          Output:
    //  Second Smallest : 2
    // 	Second Largest : 5
    /**
     * @param args
     */
    public static void main(String[] args) {
       
        int[] arr = {1, 2, 4, 7, 7, 5};
        int res = betterSol(arr, arr.length);
        System.out.println("better solution gives the result: "+res);

        //easy optimal solution
        int[] result1 = solutionOfProblem(arr, arr.length);

        System.out.println("Second Smallest Digit: " + result1[0]);
        System.out.println("Second Largest Digit: " + result1[1]);
        
    }

    
    //better solution:

    public static int  betterSol(int[] arr, int n){
        int lar= -1;
        for(int i=0;i<n;i++){
            if(arr[i]>lar){
                lar=arr[i];
            }
        }
        int seclar=-1;
        for(int j=0;j<n;j++){
            if(arr[j]>seclar && arr[j]!=lar){
                seclar= arr[j];
            }
        }
        return seclar;  
    }
//---------------------------------------------------------------------------------------------------
    // easy optimal sol with two functions separately for second smallest and second largest

    public static int secondLargetDigit(int[] arr,int n ){

        int largest= arr[0];
        int secondLargest= -1;
        for (int i=1;i<n; i++){

            if(arr[i]>largest){
                secondLargest= largest;
                largest= arr[i];
            }else if(arr[i]<largest && arr[i]>secondLargest){
                secondLargest=arr[i];
            }
        }

        return secondLargest;
        
    }
    public static int secondSmallestDigit(int[] arr,int n ){

        //arr = {1,2,4,7,7,5}
        int smallest= arr[0];
        int secondsmallest= Integer.MAX_VALUE;
        for (int i=1;i<n; i++){
            if(arr[i]<smallest){
                secondsmallest= smallest;
                smallest= arr[i];
            }else if(arr[i]!=smallest && arr[i]<secondsmallest){
                secondsmallest=arr[i];
            }
            
        }

        return secondsmallest;
        
    }
    public static int[] solutionOfProblem(int[]arr, int n){
        int sSmall= secondSmallestDigit(arr, n);
        int sLargest = secondLargetDigit(arr, n);
        return new int[]{sSmall,sLargest};
    }

//---------------------------------------------------------------------------------------------------
   
    
    
}
