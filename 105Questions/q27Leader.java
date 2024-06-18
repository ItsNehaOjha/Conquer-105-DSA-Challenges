
import java.util.ArrayList;

public class q27Leader {
    
//     Leaders in an array
//     n = 6
// A[] = {16,17,4,3,5,2}
// Output: 17 5 2
// Explanation: The first leader is 17 as it is greater than all the elementsto its right.  Similarly, the next 
// leader is 5. The right most element is always a leader so it is also included.
    public static void main (String[] args) {
       
            int[] arr= {2,3,5,66,7,6};
            int n= arr.length;
            ArrayList<Integer> res = new ArrayList<Integer>();
            res = leaders(arr, n);
            
            for(int i=0; i<res.size(); i++){
                System.out.print(res.get(i)+" ");
            }
               
        
    }

     public static ArrayList<Integer> leaders(int arr[], int n){
        ArrayList<Integer> ans = new ArrayList<>();
        int max = arr[n-1];
        ans.add(arr[n-1]);
        for(int i=n-2;i>=0;i--){
            if(arr[i]>=max){
                ans.add(arr[i]);
                max=arr[i];
            }
        }
        reverse(ans);
        return ans;
     }
     public static void reverse(ArrayList<Integer> arr){
        int s= 0;
        int e= arr.size()-1;
        while(s<e){
            int temp = arr.get(s);
            arr.set(s,arr.get(e));
            arr.set(e, temp);
            s++;
            e--;
        }
     }
}


// 🚀 Day 26: "Conquer 105 DSA Challenges"!

// Problem: Next Permutation (Find the next lexicographical permutation).

// Example: [1, 2, 3]
// Output: [1, 3, 2]
// 📝 GitHub