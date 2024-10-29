import java.util.Scanner;

// 3110. Score of a String
// You are given a string s. The score of a string is defined as the sum of the absolute difference between the 
// ASCII values of adjacent characters.
// Input: s = "hello"
// Output: 13

public class q41ScoreOfString {

    // Method to calculate the score of the string
    public int scoreOfString(String s) {
        int score = 0;
        int n = s.length();
        
        for (int i = 0; i < n - 1; i++) {
            // Calculate the absolute difference between ASCII values of adjacent characters
            score += Math.abs(s.charAt(i) - s.charAt(i + 1));
        }
        return score;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        q41ScoreOfString scorer = new q41ScoreOfString(); // Create an instance of the class

        // Input string
        System.out.print("Enter a string: ");
        String inputString = sc.nextLine();

        int result = scorer.scoreOfString(inputString); // Call the method on the instance
        
        System.out.println("The score of the string is: " + result);
        sc.close();
    }
}
