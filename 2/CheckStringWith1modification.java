/*
Given a string and array of strings, find whether the array contains a string with one character difference from the given string. 
Array may contain string of different lengths. 

Ex: Given string:
banana
and array is
[bana, apple, banaba, bonanza, banamf]
and the outpost should be true as banana and banaba are one character difference.

The aray
[bana, apple, cbanana, bonanza, banamf]
also returns true as banana and cbanana are one character difference.
*/


import java.util.*;
public class CheckStringWith1modification{

    public static void main(String[] args){
	
    	String[] arr = {"bana", "apple", "banaba", "bonanza", "banamf"};
    	String[] arr2 = String[] arr = {"bana", "apple", "cbanana", "bonanza", "banamf"};
	System.out.println(checkStringWith1modification("banana", arr));
	System.out.println(checkStringWith1modification("banana", arr));
	}
	 public static boolean checkStringWith1modification(String str, String[] arr){
    int len = str.length();
    	
    	for(String s : arr){
    		int l = s.length();
    		if(Math.abs(len - l) > 1) continue;
    		int count1=0;
    		int count2 = 0;
    		int diff= 0;
    		while(count1 <= len - 1 && count2 <= l - 1){
    			if(str.charAt(count1) == s.charAt(count2)){  //if both of same length then increment both counter
    				count2++;
    				count1++;
    			}else{
    				diff++;  //else there is character difference
    				if(l - len > 0) count2++; //if the array string is of greater length then increase array string counter (banana and cbanana)
    				else if (l - len == 0){ count1++; count2++;} ////if both strings are of equal length then increase both counters
    										//eg. banana and banaba OR banana and banacc
    				else count1++; //if the input string is of greater length then increase array string counter (banana and bana)
    			}
    		} //end while
    		if(diff == 1) 	return true;
    	} //end foreach
    	return false;  //not found string with 1 character diff
    }
}
