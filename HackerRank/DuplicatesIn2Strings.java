// https://www.hackerrank.com/challenges/two-strings

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class DuplicatesIn2Strings {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scanner = new Scanner(System.in);
        int testcases = scanner.nextInt();
        int j = 0;
        while ( j < testcases) {
            String a = scanner.next();
            String b = scanner.next();
            char[] aa = a.toCharArray();
            Arrays.sort(aa);
            char[] bb = b.toCharArray();
            Arrays.sort(bb);
            int c1 = 0;
            int c2 = 0;
            boolean duplicate = false;
            while(c1 < a.length() && c2 < b.length()) {
                if (aa[c1] == bb[c2]) {
                    System.out.println("YES");
                    duplicate = true;
                    break;
                } else if (aa[c1] > bb[c2]) {
                    c2++;
                } else {
                    c1++;
                }
            }
            if (!duplicate) System.out.println("NO");
            j++;
        }
    }
}

/*
PROBLEM STATEMENT:
You are given two strings, AA and BB. Find if there is a substring that appears in both AA and BB.

Input Format

Several test cases will be given to you in a single file. The first line of the input will contain a single 
integer TT, the number of test cases.

Then there will be TT descriptions of the test cases. Each description contains two lines. The first line 
contains the string AA and the second line contains the string BB.

Output Format

For each test case, display YES (in a newline), if there is a common substring. Otherwise, display NO.

Constraints

All the strings contain only lowercase Latin letters.
1<=T<=101<=T<=10
1<=|A|,|B|<=1051<=|A|,|B|<=105
Sample Input

2
hello
world
hi
world
Sample Output

YES
NO
Explanation

For the 1st test case, the letter o is common between both strings, hence the answer YES. (Furthermore, the letter l
is also common, but you only need to find one common substring.) 
For the 2nd test case, hi and world do not have a common substring, hence the answer NO.
*/
