// Convert a decimal number into binary
// Steps for conversion:
// 1. Divide the number by 2.
// 2. Store the remainder as part of the binary answer.
// 3. Repeat steps 1 and 2 until the number becomes 0.
// 4. Reverse the stored answer to get the final binary representation.

// By bitwise approach:
public class DecimalToBinary {

    public static String decimalToBinary(int n) {
        if (n == 0) {
            return "0"; // Special case for decimal number 0
        }

        StringBuilder binary = new StringBuilder();

        // Convert decimal number to binary using repeated division by 2
        while (n > 0) {
            int remainder = n % 2;
            binary.insert(0, remainder); // Prepend remainder to binary string
            n = n / 2; // Use integer division to reduce n
        }

        return binary.toString();
    }

    public static void main(String[] args) {
        int decimalNumber = 10;
        String binaryRepresentation = decimalToBinary(decimalNumber);
        System.out.println("Binary representation of " + decimalNumber + " is: " + binaryRepresentation);
    }
}
