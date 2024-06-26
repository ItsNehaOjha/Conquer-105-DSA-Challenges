import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class q32PhoneCombination {

    // 17. Letter Combinations of a Phone Number

    // Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number
    // could represent. Return the answer in any order. A mapping of digits to letters (just like on the telephone 
    // buttons) is given below. Note that 1 does not map to any letters.

    // Example 1:
    // Input: digits = "23"
    // Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]

    public static List<String> letterCombination(String digits) { // Changed to List<String>
        if (digits.isEmpty()) {
            return Collections.emptyList();
        }

        String[] phoneMap = {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        List<String> output = new ArrayList<>();
        backtrack("", digits, phoneMap, output);
        return output;
    }

    private static void backtrack(String p, String up, String[] maps, List<String> output) {
        if (up.isEmpty()) {
            output.add(p);
        } else {
            String letters = maps[up.charAt(0) - '2']; // Correct mapping index calculation
            for (char letter : letters.toCharArray()) { // Convert string to char array for iteration
                backtrack(p + letter, up.substring(1), maps, output);
            }
        }
    }

    public static void main(String[] args) {
        // Example usage
        String digits = "23";
        List<String> combinations = letterCombination(digits);
        System.out.println(combinations); // Output: [ad, ae, af, bd, be, bf, cd, ce, cf]
    }
}
