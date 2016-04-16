// https://www.hackerrank.com/challenges/stockmax

import java.io.BufferedReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.io.InputStreamReader;
public class StockMaximization {
    public static void main(String arg[]) throws IOException {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int t=Integer.parseInt(br.readLine());
            while(t!=0){
                int n=Integer.parseInt(br.readLine());
                int arr[]=new int[n];
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int i=0;i<n;i++){
                arr[i]=Integer.parseInt(st.nextToken());
                }
                int p=0;
                long pp=0;
                
                
                while(p<n){
                    int max=0,k=p;
                    
                        for(int i=p;i<n;i++){
                            if(arr[i]>max){
                                max=arr[i];
                                p=i+1;
                            }
                        } // end for

                    
                        for(int i=k;i < p;i++){
                            pp += (max-arr[i]);
                        } // end for
                    
                }  // end while
                
                
                System.out.println(pp);
            t--;
            }
        } catch (Exception e) {
        }
    }    
}

/*
Your algorithms have become so good at predicting the market that you now know what the share price of Wooden Orange Toothpicks Inc. 
(WOT) will be for the next N days.

Each day, you can either buy one share of WOT, sell any number of shares of WOT that you own, or not make any transaction at all. 
What is the maximum profit you can obtain with an optimum trading strategy?

Input

The first line contains the number of test cases T. T test cases follow:

The first line of each test case contains a number N. The next line contains N integers, denoting the predicted price of 
WOT shares for the next N days.

Output

Output T lines, containing the maximum profit which can be obtained for the corresponding test case.

Constraints

1 <= T <= 10 
1 <= N <= 50000

All share prices are between 1 and 100000

Sample Input

3
3
5 3 2
3
1 2 100
4
1 3 1 2
Sample Output

0
197
3
Explanation

For the first case, you cannot obtain any profit because the share price never rises. 
For the second case, you can buy one share on the first two days, and sell both of them on the third day. 
For the third case, you can buy one share on day 1, sell one on day 2, buy one share on day 3, and sell one share on day 4.
*/
