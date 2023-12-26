// 1st program to find LCM of two number::
class HelloWorld(){
  public static void main(String[] args){
    int n1=2;
    int n2=6;
    int hcf=0;
    int min=(n1<n2)?n1:n2;   //conditional statement 
    for(int i=1;i<=min;i++){
      if(n1%i==0 && n2%i==0 ){
        hcf=i;
      }
    }System.out.println(hcf);
  }
}

