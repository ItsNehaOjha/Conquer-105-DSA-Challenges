public class q45ReverseStringII {
    public static void main(String[] args) {
        // Test case 1
        String s1 = "abcdefg";
        int k1 = 2;
        System.out.println("Test case 1: " + reverseStr(s1, k1)); // Expected output: "bacdfeg"
        
        // Test case 2
        String s2 = "abcd";
        int k2 = 2;
        System.out.println("Test case 2: " + reverseStr(s2, k2)); // Expected output: "bacd"
        
        // Test case 3
        String s3 = "abcdef";
        int k3 = 3;
        System.out.println("Test case 3: " + reverseStr(s3, k3)); // Expected output: "cbadef"
        
        // Test case 4
        String s4 = "a";
        int k4 = 2;
        System.out.println("Test case 4: " +reverseStr(s4, k4)); // Expected output: "a"
    }

    public static String reverseStr(String s, int k) {
        // Convert the string into an array
        char[] arr = s.toCharArray();
        int n = arr.length;
        int i = 0;
        while (i < n) {
            int j = Math.min(i + k - 1, n - 1);
            reverse(arr, i, j);
            i += 2 * k;
        }
        return new String(arr);
    }

    public static void reverse(char[] arr, int i, int j) {
        while (i < j) {
            char temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
    }
}
