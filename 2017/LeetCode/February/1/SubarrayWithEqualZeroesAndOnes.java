// Reference: http://www.geeksforgeeks.org/largest-subarray-with-equal-number-of-0s-and-1s/

/*
525. Contiguous Array.

Given a binary array, find the maximum length of a contiguous subarray with equal number of 0 and 1.

Example 1:
Input: [0,1]
Output: 2
Explanation: [0, 1] is the longest contiguous subarray with equal number of 0 and 1.
Example 2:
Input: [0,1,0]
Output: 2
Explanation: [0, 1] (or [1, 0]) is a longest contiguous subarray with equal number of 0 and 1.
Note: The length of the given binary array will not exceed 50,000.
*/

/* Algo # 1:
A simple method is to use two nested loops. The outer loop picks a starting point i. 
The inner loop considers all subarrays starting from i.
If size of a subarray is greater than maximum size so far, then update the maximum size.
In the below code, 0s are considered as -1 and sum of all values from i to j is calculated. 
If sum becomes 0, then size of this subarray is compared with largest size so far.

Time Complexity => O(n * n)
Space Complexity => O ( 1 )
*/
public class SubarrayWithEqualZeroesAndOnes {
 
    // This function Prints the starting and ending
    // indexes of the largest subarray with equal  
    // number of 0s and 1s. Also returns the size 
    // of such subarray.
    int findSubArray(int arr[], int n) 
    {
        int sum = 0;
        int maxsize = -1, startindex = 0;
        int endindex = 0;
 
        // Pick a starting point as i
        for (int i = 0; i < n - 1; i++) 
        {
            sum = (arr[i] == 0) ? -1 : 1;
 
            // Consider all subarrays starting from i
            for (int j = i + 1; j < n; j++) 
            {
                if(arr[j] == 0)  
                    sum += -1; 
                else
                    sum += 1;
 
                // If this is a 0 sum subarray, then 
                // compare it with maximum size subarray
                // calculated so far
                if (sum == 0 && maxsize < j - i + 1) 
                {
                    maxsize = j - i + 1;
                    startindex = i;
                }
            }
        }
        endindex = startindex+maxsize-1;
        if (maxsize == -1)
            System.out.println("No such subarray");
        else
            System.out.println(startindex+" to "+endindex);
 
        return maxsize;
    }
 
    /* Driver program to test the above functions */
    public static void main(String[] args) 
    {
        LargestSubArray sub;
        sub = new LargestSubArray();
        int arr[] = {1, 0, 0, 1, 0, 1, 1};
        int size = arr.length;
 
        sub.findSubArray(arr, size);
    }
}
