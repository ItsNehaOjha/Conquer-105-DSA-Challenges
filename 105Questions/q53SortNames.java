import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class q53SortNames {
    
    // 2418. Sort the People
    // You are given an array of strings names, and an array heights that consists of distinct positive integers.
    // Both arrays are of length n. For each index i, names[i] and heights[i] denote the name and height of the ith person.
    // Return names sorted in descending order by the people's heights.
    // Input: names = ["Mary","John","Emma"], heights = [180,165,170]
    // Output: ["Mary","Emma","John"]

    public static void main(String[] args) {
        String[] names = {"Mary", "John", "Emma"};
        int[] heights = {180, 165, 170};

        String[] sortedNames = sortPeople(names, heights);

        System.out.println(Arrays.toString(sortedNames));
    }

    public static String[] sortPeople(String[] names, int[] heights) {
        int n = names.length;
        // Create a mapping of height to names
        Map<Integer, String> mapping = new HashMap<>();

        for (int i = 0; i < n; i++) {
            mapping.put(heights[i], names[i]);
        }

        // Create an array of heights for sorting
        Integer[] sortedHeights = new Integer[n];
        for (int i = 0; i < n; i++) {
            sortedHeights[i] = heights[i];
        }

        // Sort heights in descending order
        Arrays.sort(sortedHeights, (a, b) -> b - a);

        // Create an array for sorted names
        String[] sortedNames = new String[n];

        // Map the sorted heights to names
        for (int i = 0; i < n; i++) {
            sortedNames[i] = mapping.get(sortedHeights[i]);
        }
        
        return sortedNames;
    }
}
