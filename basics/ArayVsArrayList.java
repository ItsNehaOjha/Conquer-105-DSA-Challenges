import java.util.ArrayList;
import java.util.Arrays;
public class ArayVsArrayList{
    public static void main(String[] args){

    
                            // ARRAYS
    //collections of same type of elements having a fixed size, 
    //after declaration it can not be shrinked or enlarged: array
    //------------------direct initialization------------------
    String[] friendsArray = {"Neha","Sneha","Namrata","Shivani" }; 
    //---------------------not specified elements initiallization-----------------
    // String[] friendsArray2 = new String[4];
                                 // ARRAYSList
    //-------------------not specified elements initiallization---------also import java.util.ArrayList----------
    // ArrayList<String> friendsArrayList= new ArrayList<>();  //NO SIZE needs to be given:- 
    // (here we do not have to specify the size because the size in arrayList is not fixed as in array )

    //-------------------------direct initialization:     // Converting the array to a List using Arrays.asList()
    ArrayList<String> friendsArrayList2 = new ArrayList<>(Arrays.asList("Neha", "Sneha", "Namrata","Shivani"));

    // --------------Diffrence:=----------------------
    // 1. SIZE= Arrayas have a fixed size , ArrayList have completely dynamic size
    // 2. DATA= Arrays  can hold anything , primitive or objects like string, cal , dog etc
                // ArrayList can only hold objects , But SUPPORTS WRAPPER TYPES FOR PRIMITIVES 
                //e.g. ArrayList<INTEGER> is a wrapper class of int

    //-------------getting any value from array or arraylist-------------

                            // ARRAYS by index
    System.out.println(friendsArray[1]);
                            // ARRAYSLIST by get method
    System.out.println(friendsArrayList2.get(1));

    //------------geting the sizes of both------------

    System.out.println(friendsArray.length);
    System.out.println(friendsArrayList2.size());

    //------------adding element in the end ----------

    //cant do this in array as they have a fixed size can be changed but can do in arrayList

    friendsArrayList2.add("Saishree");
    System.out.println(friendsArrayList2.get(4));

    //-----------------set an element-------------
    //array
    friendsArray[0]= "ojha";
    System.out.println(friendsArray[0]);
    //arrayList
    friendsArrayList2.set(0,"ojha");
    System.out.println(friendsArrayList2.get(0));

    //-------------Remove an element----------------

    //can't do this with array

    friendsArrayList2.remove("Namrata"); //or I can pass the index also


    //-------------printing the whole array or arraylist---------------

    System.out.println(friendsArray);   //have to do a for loop to print each element this will just give the address
    System.out.println(friendsArrayList2);  // here it will give a proper list output
    
    



    
                
    


    }

}