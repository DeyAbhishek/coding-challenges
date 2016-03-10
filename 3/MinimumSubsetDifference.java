// Given a set of numbers divide the numbers into two subset so that 
// the difference of the sum of the elements of the subsets is minimum.
// Your method should return only the difference.
// Example: If the set of numbers is { 2, 1000, 3, 100, 12}
// The to get the minimum sum the two subsets would be
// Subset 1: {2, 3, 100, 12}
// Subset 2: {1000}
// Sum of Subset 1: 117
// Sum of subset 2: 1000
// Diff: 1000 - 117 = 883

/**
 * @author Abhishek
 */
public class MinimumSubsetDifference{

    public static void main(String []args) {
  		int[] arr = { 2, 1000, 3, 100, 12};
  		System.out.println(subsetDiff(arr, 0, 0, arr.length - 1));
		
    }
     
  	private static int subsetDiff(int[] arr, int sumA, int sumB, int index) {
  		if (index == -1) {
  			return Math.abs(sumA - sumB);
  		}
  		
  		return Math.min(subsetDiff(arr, sumA + arr[index], sumB, index - 1), 
  				subsetDiff(arr, sumA, sumB + arr[index], index - 1));
  		
  	}


}

//Output:
883
