//-----------------Moore's Voting Algorithm-----------------
// Find the Majority Element that occurs more than N/2 times
// Input: ‘n’ = 9, ‘a’ = [2, 2, 1, 3, 1, 1, 3, 1, 1]
// Output: 1
// Explanation: The frequency of ‘1’ is 5, which is greater than 9 / 2.
// Hence ‘1’ is the majority element.

public class q15MajorityElement {
    
    public static void main(String[] args) {
        int[] arr = {2, 2, 1, 1, 1, 2, 2};
        int majority = majorityElement(arr);

        System.out.println("Majority Element: " + majority);
        int majority2 = mooreVotingAlgo(arr);

        System.out.println("By Moore Voting Algorithm The Element is: " + majority2);
        
    }
    // brute force approach
    public static int majorityElement(int[] v) {
        int n = v.length;
        int maxCount = 0;
        int candidate = v[0]; // Initialize candidate as the first element

        // Find the majority candidate
        for (int i = 0; i < n; i++) {
            int current = v[i];
            int count = 0;

            // Count occurrences of the current element
            for (int j = 0; j < n; j++) {
                if (v[j] == current) {
                    count++;
                }
            }

            // Update candidate if the current element has more occurrences
            if (count > maxCount) {
                maxCount = count;
                candidate = current;
            }
        }

        return candidate;
    }

    //-----------------Moore's Voting Algorithm-----------------
    //arr[]= {7,7,5,7,5,1,5,7,5,5,7,7,5,5,5,5}
    public static int mooreVotingAlgo(int[]arr ){
        int n= arr.length;
        int cnt=0;
        int el =0;
        for(int i=0;i<n;i++){
            
            if(cnt ==0){
                cnt=1;
                el=arr[i];
            }else if(arr[i]== el){
                cnt++;
            }else{
                cnt--;
            }
        }
        int subCount=0;
        for(int i=0;i<n;i++){
            if(arr[i]==el){
                subCount++;
            }
        }
        if(subCount>n/2){
            return el;
        }
        return -1;
    }

}
