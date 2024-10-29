public class q47GetEncryptedString {
    public static void main(String[] args) {
        // Test case 1
        String s1 = "hello";
        int k1 = 2;
        System.out.println("Test case 1: " + getEncryptedString(s1, k1)); // Expected output: "lohel"

        // Test case 2
        String s2 = "abcdef";
        int k2 = 3;
        System.out.println("Test case 2: " + getEncryptedString(s2, k2)); // Expected output: "defabc"

        // Test case 3
        String s3 = "rotation";
        int k3 = 4;
        System.out.println("Test case 3: " + getEncryptedString(s3, k3)); // Expected output: "ationrot"

        // Test case 4
        String s4 = "encryption";
        int k4 = 5;
        System.out.println("Test case 4: " + getEncryptedString(s4, k4)); // Expected output: "ptionency"
    }

    public static String getEncryptedString(String s, int k) {
        int n = s.length();
        k = k % n; // To handle cases where k > n
        StringBuilder enc = new StringBuilder();

        // Append last k characters followed by the first n-k characters
        enc.append(s.substring(n - k)).append(s.substring(0, n - k));
        
        return enc.toString();
    }
}
