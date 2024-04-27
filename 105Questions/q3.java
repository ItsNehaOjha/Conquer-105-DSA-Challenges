public class q3 {

    // Method to find the second smallest and second largest elements in the array
      // Given an array, find the second smallest and second largest element in the array. Print ‘-1’ in the event that either of them doesn’t exist.
    //         Input:
    //  [1,2,4,7,7,5]
    //          Output:
    //  Second Smallest : 2
    // 	Second Largest : 5
    public static int[] getSecondOrderElements(int n, int[] arr) {
        
        if (n < 2 || arr == null || arr.length < n) {
            return new int[]{-1, -1};
        }

       
        int min = Integer.MAX_VALUE;
        int secondMin = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int secondMax = Integer.MIN_VALUE;

       
        for (int num : arr) {
            if (num < min) {
                secondMin = min;
                min = num;
            } else if (num < secondMin && num != min) {
                secondMin = num;
            }

            if (num > max) {
                secondMax = max;
                max = num;
            } else if (num > secondMax && num != max) {
                secondMax = num;
            }
        }


        return new int[]{secondMin, secondMax};
    }

    
    public static void main(String[] args) {
       
        int[] arr = {1, 2, 4, 7, 7, 5};

       
        int[] result = getSecondOrderElements(arr.length, arr);

       
        if (result[0] == -1 || result[1] == -1) {
            System.out.println("Second Smallest: -1");
            System.out.println("Second Largest: -1");
        } else {
            System.out.println("Second Smallest: " + result[0]);
            System.out.println("Second Largest: " + result[1]);
        }
    }
}
