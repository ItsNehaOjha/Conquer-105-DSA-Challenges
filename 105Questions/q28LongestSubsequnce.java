import java.util.Arrays;

public class q28LongestSubsequnce{

// Longest Consecutive Sequence in an Array
// Input:
//  [100, 200, 1, 3, 2, 4]
// Output: 4
// Explanation: The longest consecutive subsequence is 1, 2, 3, and 4.


    public static void main(String[] args) {
        int[] a = {100, 200, 1, 2, 3, 4};
        int ans = longestSuccessiveElements(a);
        System.out.println("The longest consecutive sequence is " + ans);
    }

    //brute force approach
    private static int longestSuccessiveElements(int[] a) {
        
        int large= 1;
        int n= a.length;
        for(int i=0;i<n;i++){
            int x= a[i];
            int cnt= 1;
            while(linearSearch(a, x+1)==true){
                x+=1;
                cnt +=1;
            }
            large= Math.max(cnt,large);
        }
        return large;

    }


    public static boolean linearSearch(int[]a, int target){
      
        for(int i=0;i<a.length;i++){
          if(a[i]==target){
            return true;
          }   
        }
        return false;
    }

    //better approach  by sorting
    public static int better(int[] a){
        int n= a.length;
        if(n==0) return 0;
        Arrays.sort(a);
        
        int prev= Integer.MIN_VALUE;
        int cnt= 0;
        int longest = 1;

        for(int i=0;i<n;i++){
            if(a[i]-1 == prev){
                cnt+=1;
                prev= a[i];
            }else if(a[i] != prev){
                cnt =1;
                prev= a[i];
            }
            longest = Math.max(longest, cnt);
        }
        return longest;

    }

}