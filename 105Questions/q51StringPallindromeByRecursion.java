public class q51StringPallindromeByRecursion{

    // 125. Valid Palindrome (By recursion)
    // A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and removing
    // all non-alphanumeric characters, it reads the same forward and backward. Alphanumeric characters include letters and numbers.
    // Given a string s, return true if it is a palindrome, or false otherwise.

    // Input: s = "A man, a plan, a canal: Panama"
    // Output: true
    // Explanation: "amanaplanacanalpanama" is a palindrome.


    // brute force approach 

    public static boolean isPallindrome(String s){
       
        s= s.toLowerCase().replaceAll("[^A-Za-z0-9]","");  //xoring everything else then the listed characters

        int i=0;
        int j= s.length()-1;
        while(i<=j){
            if(s.charAt(i) != s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    public static boolean isPallindromeByRecursion(String s){

        s = s.toLowerCase().replaceAll("[^A-Za-z0-9]", "");

        if(s.isEmpty()){
            return true;
        }

        return recursion(0, s);

    }
    public static boolean recursion(int i, String s ){

        if(i > s.length()/2){
            return true;
        }

        if( s.charAt(i) != s.charAt(s.length() - i - 1)) return false;

        return recursion( i+1, s);

    }

}