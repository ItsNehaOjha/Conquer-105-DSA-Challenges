public class recursion1 {

    public static void main(String[] args) {
        int n=3145;
        int rev=0;
        int ans = reverse(n,rev);
        System.out.print(ans);
    }
    // public static void sum(int n, int sum){
    //     if(n<1){
    //         System.out.print(sum);
    //         return;
    //     }
    //     sum(n-1, sum+n);
    // }
    public static int reverse(int n,int rev){
        if(n==0){
            return rev;
        }
        rev = rev*10 + n%10;
        return reverse(n/10,rev);
    }
    public static void bubble(int[] arr, int s, int e){
        
    }
}
