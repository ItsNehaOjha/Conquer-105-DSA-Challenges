// convert a decimal number into binary:
// there is 4 major steps :                            n=10;   n=5       n=2;     n=1;
// step 1: n/2;                                        10/2=5  5/2=2     2/2=1    1/2=0
// step 2: store the remainder in aswer:               ans=0,  ans = 01  ans=010  ans = 0101
// step 3: repeat the step 1 and 2 until n !=0;        5!=0;   2!=0;     1!=0     0==0    loop stopped
// step 4: reverse answer                              ans = 1010

// by bitwise approach: 
class solution{
 public in binarytodecimal(int n){
   int ans=0;
   int i=0;
   while(n!=0){
     int bit = (n & 1);
       ans = (bit * pow(10,i)) +ans;
       n =>>1;
     i++;
     }
   return ans;
   }
 }
}
