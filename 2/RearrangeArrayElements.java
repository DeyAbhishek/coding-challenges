// If [a1,a2,a3...,an,b1,b2...bn] is given input 
// Change this to [a1,b1,a2,b2.....an,bn] 
// Solution should be in-place.


import java.util.*;
public class RearrangeArrayElements{

    public static void main(String[] args){

    String[] arr = {"a1", "a2", "a3", "a4", "b1", "b2", "b3", "b4"};
    	 for(String str : arr){
    		 System.out.print(str + "   ");
    	 }
    	 System.out.println();
    	 Arrays.sort(arr, new Comparator<String>(){
    		 @Override
    		 public int compare(String a, String b){
    			 int index1 = (int)a.charAt(1);
    			 int index2 = (int)b.charAt(1);
    			 if(index1 != index2){
    				 return index1 - index2;
    			 }
    			 else{
    				 return (int)a.charAt(0) - (int)b.charAt(0);
    			 }
    		 }
    	 });		// This solution is basically IN-PLACE,
    	 		// because Java's Arrays.sort uses a combination of quick sort
    	 		// and insertion sort depending on the
    	 		// nature of the data set, and both insertion and
    	 		// quick sorts are IN-PLACE.
    	 for(String str : arr){
    		 System.out.print(str + "   ");
    	 }
    	 System.out.println();
	}
    
    
    /*
    OUTPUT:
    a1   a2   a3   a4   b1   b2   b3   b4   
    a1   b1   a2   b2   a3   b3   a4   b4   

    */
