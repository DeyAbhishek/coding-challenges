// https://www.hackerrank.com/challenges/candies

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Candies {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        //int a = scanner.nextInt();
        int count = 0;
        int sum = 1;
        int prev = 1;
        int[] arr = new int[n];
        int[] candies = new int[n];
        while (count <= n - 1) {
            arr[count++] = scanner.nextInt();
        }
        int a = arr[0];
        if ( n <= 1) {
            candies[0] = 1;
        } else if (arr[0] <= arr[1]) {
            candies[0] = 1;
            count = 1;
        } else if (arr[0] > arr[1]) {
            count = 0;
        }
        while (count <= n - 2) {
                if (count > 0 && arr[count - 1] == arr[count]) {
                    //System.out.println("---------------1--------------" + arr[count] + "  " + count);
                    candies[count++] = 1;
                } else if (count > 0 && arr[count - 1] < arr[count]) {
                    //System.out.println("---------------2--------------" + arr[count] + "  " + count);
                    candies[count] = candies[count - 1] + 1;
                    count++;
                }
                else {
                //System.out.println("---------------3--------------" + arr[count] + "  " + count );
                int k = count - 1;
                if ( k == -1) {
                    k = 0; count++;
                        /*The above two lines handled the following type of input:
                        4
                        10
                        9
                        8
                        7
                        */
                }
                    
                while (count > 0 && count <= n - 1 && arr[count] < arr[count - 1]) {
                    count++;
                }
                int diff = count - k;
                while (k < count) {
                    candies[k] = Math.max(candies[k++],diff--);
                }
            }
        }
        if (n >= 2 && arr[ n - 1 ] > arr[ n - 2 ]) {
            candies[n-1] = candies[n-2] +1;
        } else if (arr[ n - 1 ] <= arr[ n - 2 ]) {
            candies[n-1] = 1;
        }
        
        sum = 0;
        for (int i = 0; i < n ; i++) {
           //System.out.println(candies[i]);
            sum += candies[i];
        }
        
        
        System.out.println(sum);
        
    }
}

/*
Alice is a kindergarden teacher. She wants to give some candies to the children in her class.  All the children sit in a line
( their positions are fixed), and each  of them has a rating score according to his or her performance in the class.  
Alice wants to give at least 1 candy to each child. If two children sit next to each other, then the one with the higher
rating must get more candies. Alice wants to save money, so she needs to minimize the total number of candies given to the children.

Input Format

The first line of the input is an integer N, the number of children in Alice's class. Each of the following N lines contains an 
integer that indicates the rating of each child.

1 <= N <= 105 
1 <= ratingi <= 105

Output Format

Output a single line containing the minimum number of candies Alice must buy.

Sample Input

3  
1  
2  
2
Sample Output

4
Explanation

Here 1, 2, 2 is the rating. Note that when two children have equal rating, they are allowed to have different number of candies.
Hence optimal distribution will be 1, 2, 1.

*/
