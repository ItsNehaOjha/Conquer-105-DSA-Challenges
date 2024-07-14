import java.util.ArrayList;
import java.util.Arrays;
public class q08MoveZeroes {
    public static void main(String[] args) {

        //----------------move zeroes in right and left-----------------

        // Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.
        //Note that you must do this in-place without making a copy of the array.
        //Input: nums = [0,1,0,3,12] Output: [1,3,12,0,0]
        int[] arr={1,0,2,3,0,0,0,4,5,1};
        int n=arr.length;

        //optimal solution
        optimalSol(arr,n);     
        System.out.println("optimal approach "+ Arrays.toString(arr));
        
        //brute force approach
        bruteSol(arr,n);
        System.out.println("brute force approach "+Arrays.toString(arr));

        // brute force approach zeroes in the left
        zeroesinleft(arr,n);
        System.out.println("zeroes in the left "+Arrays.toString(arr));

        //better approach
        moveZeroes(arr,n);     
        System.out.println("better approach "+ Arrays.toString(arr));       
         
    }

    //brute force approach
    public static void bruteSol(int[]arr, int n){
        ArrayList<Integer> temp = new ArrayList<>();
        for(int i=0;i< n;i++){
            if(arr[i]!=0){
                temp.add(arr[i]);
            }
        }

        for(int i=0;i<temp.size();i++){
            arr[i]=temp.get(i);
            
        }
        for(int i=temp.size();i<n;i++){
            arr[i]=0;
        }
    }
    //zeroes in the left
    public static void zeroesinleft(int[]arr, int n){
        ArrayList<Integer> temp = new ArrayList<>();

        for(int i=0;i< n;i++){
            if(arr[i]!=0){
                temp.add(arr[i]);//temp size =5. arr size =8 , zeroes needed =3 
            }
        }

        int lastZero = arr.length-temp.size();
        int index=0;
        for(int i=0;i<lastZero;i++){
            arr[i]=0;
            index++;
        }

        int tempI=0;
        for(int i=index;i<arr.length;i++){
            arr[i]=temp.get(tempI);
            tempI++;
            
        }
    }
    //better approach
    public static void moveZeroes(int[]arr, int n){
        int count=0;
        for(int i=0;i<n;i++){
            if(arr[i]!=0){
                arr[count]=arr[i];
                count++;
            }
        }
        while(count<arr.length){
            arr[count]=0;
            count++;
        }/
    }
    //optimal approach : two pointer approach
    public static void optimalSol(int[] arr, int n){
        int i=0;
        int j=1;
        while(i<n && j<n){
            if(arr[i]!=0 && arr[j]==0){
                i++;
                j++;
            }else if(arr[i]==0 && arr[j]!=0){
                int temp = arr[i];
                arr[i]=arr[j];
                arr[j]=temp;
                i++;
                j++;
            }else if(arr[i]==0 && arr[j]==0){
                j++;
            }
        }
        
    }
}
