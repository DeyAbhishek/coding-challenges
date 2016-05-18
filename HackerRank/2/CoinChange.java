// https://www.hackerrank.com/challenges/coin-change

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class CoinChange {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[m];
        int i = 0;
        while (i < m) {
            arr[i] = sc.nextInt();
            i++;
        } 
        Map<String, Long> memo = new HashMap<String, Long>();
        System.out.println(getResult(n, arr, m - 1, memo));
        
    }
    
    private static long getResult(int n, int[] denom, int index, Map<String, Long> memo) {
        if (memo.containsKey("" + n + " " + index)) {
            return memo.get("" + n + " " + index);
        }
        if (n == 0){
            return 1;
        }
        if (n < 0) {
            return 0;
        }
        if (n > 0 && index < 0) {
            return 0;
        }
        // you either include that coin or you don't
        long res = getResult(n, denom, index - 1, memo) + getResult(n - denom[index], denom, index, memo);
        memo.put("" + n + " " + index, res);
        return res;
    }
}

/*

How many different ways can you make change for an amount, given a list of coins? In this problem, your code will need to
efficiently compute the answer.

Task

Write a program that, given

The amount NN to make change for and the number of types MM of infinitely available coins
A list of MM coins - C={C1,C2,C3,..,CM}C={C1,C2,C3,..,CM}
Prints out how many different ways you can make change from the coins to STDOUT.

The problem can be formally stated:

Given a value NN, if we want to make change for NN cents, and we have infinite supply of each of C={C1,C2,…,CM}C={C1,C2,…,CM} 
valued coins, how many ways can we make the change? The order of coins doesn’t matter.

Constraints

1≤Ci≤501≤Ci≤50
1≤N≤2501≤N≤250
1≤M≤501≤M≤50
The list of coins will contain distinct integers.
Solving the overlapping subproblems using dynamic programming

You can solve this problem recursively, but not all the tests will pass unless you optimise your 
solution to eliminate the overlapping subproblems using a dynamic programming solution

Or more specifically;

If you can think of a way to store the checked solutions, then this store can be used to avoid checking the same solution
again and again.
Input Format

First line will contain 2 integer N and M respectively. 
Second line contain M integer that represent list of distinct coins that are available in infinite amount.

Output Format

One integer which is the number of ways in which we can get a sum of N from the given infinite supply of M types of coins.

Sample Input

4 3
1 2 3 
Sample Output

4
Sample Input #02

10 4
2 5 3 6
Sample Output #02

5
Explanation

Example 1: For N=4N=4 and C={1,2,3}C={1,2,3} there are four solutions: {1,1,1,1},{1,1,2},{2,2},{1,3}{1,1,1,1},{1,1,2},{2,2},{1,3}

Example 2: For N=10N=10 and C={2,5,3,6}C={2,5,3,6} there are five solutions: 
{2,2,2,2,2},{2,2,3,3},{2,2,6},{2,3,5},{5,5}{2,2,2,2,2},{2,2,3,3},{2,2,6},{2,3,5},{5,5}.

Hints

Think about the degenerate cases:

How many ways can you give change for 0 cents?
How many ways can you give change for >0 cents, if you have no coins?
If you are having trouble defining your solutions store, then think about it in terms of the base case (n=0)

*/
