public class recursion1 {

    public static void main(String[] args) {
        int n=3;
        
        sum(n,0);
    }
    public static void sum(int n, int sum){
        if(n<1){
            System.out.print(sum);
            return;
        }
        sum(n-1, sum+n);
    }
}
