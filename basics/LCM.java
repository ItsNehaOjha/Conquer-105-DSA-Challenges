// Best method is by = (n1 * n2)/ GCD( n1 & n2);        GCD = LCM 
class L{
  public static void main(String [] args){
    int n1=12;
    int n2 = 18;
    int hcf=0;
    int lcm=0;
    int min = (n1<n2 ? n1 : n2 );
    for( int i=0; i <= min ; i++){

      if( n1 % i == 0 && n2 % i == 0 ){
        hcf =i;
        
      }
      
    }
    lcm = (( n1 * n2)/ hcf);                     //formulae 
    System.out.println(lcm); 
  }

}

