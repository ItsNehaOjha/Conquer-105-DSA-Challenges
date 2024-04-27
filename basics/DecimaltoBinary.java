// convert a decimal number into binary:
// there is 4 major steps :                            n=10;   n=5       n=2;     n=1;
// step 1: n/2;                                        10/2=5  5/2=2     2/2=1    1/2=0
// step 2: store the remainder in aswer:               ans=0,  ans = 01  ans=010  ans = 0101
// step 3: repeat the step 1 and 2 until n !=0;        5!=0;   2!=0;     1!=0     0==0    loop stopped
// step 4: reverse answer                              ans = 1010

// by bitwise approach: 
public class decimaltoBinary {

  public static String decimalToBinary(int n) {
      if (n == 0) {
          return "0"; // Special case for decimal number 0
      }

      StringBuilder binary = new StringBuilder();

      // Convert decimal number to binary using repeated division by 2
      while (n > 0) {
          int remainder = n % 2;
          binary.insert(0, remainder); // Prepend remainder to binary string
          n = n / 2;
      }

      return binary.toString();
  }

  public static void main(String[] args) {
      int decimalNumber = 10;
      String binaryRepresentation = decimalToBinary(decimalNumber);
      System.out.println("Binary representation of " + decimalNumber + " is: " + binaryRepresentation);
  }
}
