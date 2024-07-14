class q06RotateByOne{
    public static void main(String[] args) {
        // Left Rotate the Array by One
        // NOTE: make sure in new array you are putting the rotated elements

        int[] arr= {1, 2, 3, 4, 5};
        int n=arr.length;
        int[] num=new int[n];
        for(int i=0;i<n;i++){
            num[i]=arr[(i+1)%n];
        }
        for(int i=0;i<n;i++){
            arr[i]= num[i];        // NOTE that int the previous array we have to put the new changed element 
            System.out.print(num[i] +" ");
        }
        
    }
}