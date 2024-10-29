class q01Recursion{
    public static void main(String[]args){
        // Given a number ‘N’, find out the sum of the first N natural numbers. USING RECURSION
        // Input: N=5
        // Output: 15
        // Explanation: 1+2+3+4+5=15
        int n=5;
        System.err.println(sum(n));

    };
    public static int sum(int n){
        if(n<=0){
            return 0;
        }
        return n+sum(n-1);

    }
}