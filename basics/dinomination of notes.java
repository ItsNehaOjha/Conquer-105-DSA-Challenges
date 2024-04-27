//using if else
class HelloWorld {
    public static void main(String[] args) {
        System.out.println("Hello, World!");
        int n=1370;
        int hund=0,fifty=0,twenty=0,ten=0;
        while(n!=0){
            
            if (n >= 100){
                hund ++;
                n-=100;
            }
           
            else if(n>=50){
                fifty ++;
                n-=50;
            }
            
            else if (n>=20){
                twenty ++;
                n-=20;
            }
           
            else if (n>=10){
                ten ++;
                n-=10;
            }
            
        }
         System.out.println("total 100 notes: "+hund);
         System.out.println("Total 50 notes: "+fifty);
          System.out.println("total 20 notes: "+twenty);
          System.out.println("total 10 notes: "+ten);

    }
}
