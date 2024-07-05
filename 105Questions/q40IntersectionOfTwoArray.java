public class q40IntersectionOfTwoArray{
    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] nums1 = {1, 2, 2, 1};
        int[] nums2 = {2, 2};

        int[] result = intersect(nums1, nums2);

        System.out.println(Arrays.toString(result));
    }
    public static int[] intersection(int[] A, int[] B){
        int i=0;
        int j=0;
        int n= A.length;
        int m= B.length;
        ArrayList<Integer> ans = new ArrayList<>();
        while(i<n && j<m){
            if(A[i]== B[j]){
                ans.add(A[i]);
                i++;
                j++;
            }else is(A[i]< B[j]){
                i++;
            }else{
                j++;
            }
        }
        int[] res= new int[ans.size()];
        for(int k=0;k<ans.size();k++){
            res[k]= ans.get(k);
        }
        return res;
    }
}