// https://www.hackerrank.com/challenges/manasa-and-stones

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class ManasaAndStones {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int stones = sc.nextInt();
            int a = sc.nextInt();
            int b = sc.nextInt();
            
            /*
            Here is the gist: Compute the difference between a and b, start a while loop at lowest possible answer; a * n-1. 
            Then add difference to this value & string.
            Then iterate until value = maxium output of b * n-1.
            */
            
            
            if (a > b) {
                int temp = a;
                a = b;
                b =  temp;
            }
            int smallest = (stones - 1) * a;
            int largest = (stones - 1) * b;
            String res = "";
            int diff = b - a;
            while (smallest < largest) {  //handling the case where a = b. That's why (smallest < largest) and NOT (smallest <= largest)
                res += smallest + " ";
                smallest = smallest + diff;
            }
            System.out.println(res + largest);
        }
    }
}

/*
Manasa is out on a hike with friends. She finds a trail of stones with numbers on them. She starts following the trail and notices that two consecutive stones have a difference of either  or . Legend has it that there is a treasure trove at the end of the trail and if Manasa can guess the value of the last stone, the treasure would be hers. Given that the number on the first stone was , find all the possible values for the number on the last stone.

Note: The numbers on the stones are in increasing order.

Input Format 
The first line contains an integer , i.e. the number of test cases.  test cases follow; each has 3 lines. The first line contains  (the number of stones). The second line contains , and the third line contains .

Output Format 
Space-separated list of numbers which are the possible values of the last stone in increasing order.

Constraints 
 

Sample Input

2
3 
1
2
4
10
100
Sample Output

2 3 4 
30 120 210 300 
Explanation

All possible series for the first test case are given below:

0,1,2
0,1,3
0,2,3
0,2,4
Hence the answer 2 3 4.

Series with different number of final steps for second test case are the following:

0, 10, 20, 30
0, 10, 20, 120
0, 10, 110, 120
0, 10, 110, 210
0, 100, 110, 120
0, 100, 110, 210
0, 100, 200, 210
0, 100, 200, 300
Hence the answer 30 120 210 300.
*/
