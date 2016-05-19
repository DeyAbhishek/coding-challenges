// https://www.hackerrank.com/challenges/missing-numbers

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class MissingNumbers {

    public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
       int t = sc.nextInt();
       int[] arr = new int[10001];
       for (int k =0; k < t; k++) {
           arr[sc.nextInt()]--;
       }
       t = sc.nextInt();
        for (int k = 0; k < t; k++) {
            arr[sc.nextInt()]++;
        }
        String str = "";
        for (int k = 0; k < 10001; k++) {
            if (arr[k] != 0) {
                str += k + " ";
            }
        }
        
        System.out.println(str);
    }
}

/*
Numeros, the Artist, had two lists  and , such that  was a permutation of . Numeros was very proud of these lists.
Unfortunately, while transporting them from one exhibition to another, some numbers were left out of . 
Can you find the missing numbers?

Notes

If a number occurs multiple times in the lists, you must ensure that the frequency of that number
in both lists is the same. If that is not the case, then it is also a missing number.
You have to print all the missing numbers in ascending order.
Print each missing number once, even if it is missing multiple times.
The difference between maximum and minimum number in  is less than or equal to .
Input Format 
There will be four lines of input:

 - the size of the first list 
This is followed by  space-separated integers that make up the first list. 
 - the size of the second list 
This is followed by  space-separated integers that make up the second list.

Output Format 
Output the missing numbers in ascending order.

Constraints 
 
 

Sample Input

10
203 204 205 206 207 208 203 204 205 206
13
203 204 204 205 206 207 205 208 203 206 205 206 204
Sample Output

204 205 206
Explanation 
204 is present in both arrays. Its frequency in A is 2, while its frequency in B is 3. Similarly, 205 and 206 occur twice in A,
but thrice in B. So, these three numbers are our output. The rest of the numbers have thesame frequency in both lists.
*/
