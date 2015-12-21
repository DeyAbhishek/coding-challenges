/*
Given a string and array of strings, find whether the array contains a string with one character difference from the given string. 
Array may contain string of different lengths. 

Ex: Given string:
banana
and array is
[bana, apple, banaba, bonanza, banamf]
and the outpost should be true as banana and banaba are one character difference.
*/


import java.util.*;
public class CheckStringWith1modification{

    public static void main(String[] args){
	
    	String[] arr = {"bana", "apple", "banaba", "bonanza", "banamf"};
		System.out.println(checkStringWith1modification("banana", arr));
	}
	 public static boolean checkStringWith1modification(String str, String[] arr){
    	int len = str.length();
    	
    	for(String s : arr){
    		int l = s.length();
    		if(Math.abs(len - l) > 1) continue;
    		boolean samelength = false;
    		if(Math.abs(len - l) == 0) samelength = true; 
    		int count1=0;
    		int count2 = 0;
    		int diff= 0;
    		while(count1 <= len - 1 && count2 <= l - 1){
    			if(str.charAt(count1) == s.charAt(count2)){
    				count2++;
    			}else{
    				diff++;
    				if(samelength) count2++;
    			}
    			count1++;
    		} //end while
    		if(diff == 1) 
				return true;
    	} //end foreach
    	return false;
    }
}
