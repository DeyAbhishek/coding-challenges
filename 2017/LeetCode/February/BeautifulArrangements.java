/*
526. Beautiful Arrangement.

Suppose you have N integers from 1 to N. We define a beautiful arrangement as an array that is constructed by these N numbers successfully if one of the following is true for the ith position (1 ≤ i ≤ N) in this array:

The number at the ith position is divisible by i.
i is divisible by the number at the ith position.
Now given N, how many beautiful arrangements can you construct?

Example 1:
Input: 2
Output: 2
Explanation: 

The first beautiful arrangement is [1, 2]:

Number at the 1st position (i=1) is 1, and 1 is divisible by i (i=1).

Number at the 2nd position (i=2) is 2, and 2 is divisible by i (i=2).

The second beautiful arrangement is [2, 1]:

Number at the 1st position (i=1) is 2, and 2 is divisible by i (i=1).

Number at the 2nd position (i=2) is 1, and i (i=2) is divisible by 1.
Note:
N is a positive integer and will not exceed 15.
*/

import java.util.*;
import java.math.*;
import java.util.stream.*;

public class BeautifulArrangements {

    boolean[] visited;
    int ans = 0;

    private void dfs(int t, int n) {
        if (t > n) ans++;
        else {
            for (int i = 1; i <= n; i++)
                if (!visited[i] && (i % t == 0 || t % i == 0)) {
                    visited[i] = true;
                    dfs(t + 1, n);
                    visited[i] = false;
                }
        }
    }


    public int countArrangement(int N) {
        visited = new boolean[30];
        ans = 0;
        dfs(1, N);
        return ans;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.countArrangement(15));
    }
}
