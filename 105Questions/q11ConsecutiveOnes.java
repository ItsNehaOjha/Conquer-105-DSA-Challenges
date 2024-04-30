public class q11ConsecutiveOnes {
    
    //Given a binary array nums, return the maximum number of consecutive 1's in the array.
    //Input: nums = [1,1,0,1,1,1]
    //Output: 3

    public static void main(String[] args) {
        int[] arr={1,1,0,1,1,1};
        int ans= consecutive(arr);
        System.err.println(ans);

    }
    public static int consecutive(int[] arr){
        int n=arr.length;
        int max=0;
        int count =0;
        for(int i=0;i<n;i++){
            if(arr[i]==1){
                count++;
                if(count>max){
                    max++;
                }
            }else{
                count=0;
            }
        }
        return max;
    }
}
