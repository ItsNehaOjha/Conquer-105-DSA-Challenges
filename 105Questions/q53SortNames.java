public class q53SortNames {
    
//     2418. Sort the People
// You are given an array of strings names, and an array heights that consists of distinct positive integers. Both arrays are of length n.
// For each index i, names[i] and heights[i] denote the name and height of the ith person.
// Return names sorted in descending order by the people's heights.
// Input: names = ["Mary","John","Emma"], heights = [180,165,170]
// Output: ["Mary","Emma","John"]


    public static void main(String[] args) {
        Solution solution = new Solution();

        
        String[] names = {"Mary", "John", "Emma"};
        int[] heights = {180, 165, 170};

        
        String[] sortedNames = solution.sortPeople(names, heights);

        
        System.out.println(Arrays.toString(sortedNames));
    }

    public static String[] sortPeople(String[] names, int[] heights) {
        int n= names.length;
        Map<Integer, String> mapping = new HashMap<>();

        for(int i=0;i<n;i++){
            mapping.put(heights[i], names[i]);
        } 

        Arrays.sort(heights);

        //resort for descending order

        for(int i=0;i<n/2; ++i){
            int temp = heights[i];
            heights[i]= heights[n-1-i];
            heights[n-1-i]= temp;
        }

        for(int i=0;i<n;i++){
            names[i]= mapping.get(heights[i]);
        }
        return names;
    }

}
