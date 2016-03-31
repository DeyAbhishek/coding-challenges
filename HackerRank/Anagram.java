import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
// https://www.hackerrank.com/challenges/make-it-anagram
public class Anagram {

    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        String str1 = scanner.nextLine();
        String str2 = scanner.nextLine();
        char[] a = str1.toCharArray();
        char[] b = str2.toCharArray();
        int count1 = 0;
        int count2 = 0;
        Arrays.sort(a);
        Arrays.sort(b);
        int result = 0;
        while (count1 < str1.length() && count2 < str2.length()) {
            if(a[count1] > b[count2]) {
                count2++;
                result++;
            } else if (a[count1] < b[count2]) {
                count1++;
                result++;
            } else {
                count1++;
                count2++;
            }
        }
        System.out.println(result + (str1.length() - count1) + (str2.length() - count2) );
    }
}

/*
Alice recently started learning about cryptography and found that anagrams are very useful. Two strings are anagrams of 
each other if they have same character set (and frequency of characters) and same length. For example strings "bacdc" and
"dcbac" are anagrams, while strings "bacdc" and "dcbad" are not.

Alice decides on an encryption scheme involving 2 large strings where encryption is dependent on the minimum number of 
character deletions required to make the two strings anagrams. She need your help in finding out this number.

Given two strings (they can be of same or different length) help her in finding out the minimum number of character 
deletions required to make two strings anagrams. Any characters can be deleted from any of the strings.

Input Format 
Two lines each containing a string.

Constraints 
1 <= Length of A,B <= 10000 
A and B will only consist of lowercase latin letter.

Output Format 
A single integer which is the number of character deletions.

Sample Input #00:

cde
abc
Sample Output #00:

4
Explanation #00: 
We need to delete 4 characters to make both strings anagram i.e. 'd' and 'e' from first string and 'b' and 'a' from second string.
*/
