
import java.util.*;
public class PrintMatrixInSpiralForm{

    public static void main(String[] args){
	
    	int[][] matrix = {{1, 2, 3}, 
    			  {8, 9, 4}, 
    			  {7, 6, 5}};
    			  
    	int[][] matrix2 = {{1, 2, 3, 4}, 
    			   {12, 13, 14, 5}, 
    			   {11, 16, 15, 6}, 
    			   {10, 9, 8, 7}};
    			   
    	 printSpiral(matrix);
    	 printSpiral(matrix2);
	}
    
    public static void printSpiral(int[][] matrix){
    	int len = matrix.length; //n X n matrix....so both lengths are the same
    	
    	System.out.println( "   =======================================");
    	for(int i = 0; i <= len/2; i++){
		    		int first = i;
		    		int last = len - 1 - i;
		    		int j = first;
		    		for(j = first; j <= last; j++){  //no need to take care of avoiding reprint (NO avoid)
		    			System.out.print( matrix[i][j] + "  ->  ");
		    		}
		    		for(j = first + 1; j <= last; j++){  //avoiding reprint taken care of by doing j = first + 1 NOT j = first (1 avoid)
		    			System.out.print(matrix[j][last] + "  ->  ");
		    		}
		    		
		    		for(j = last - 1; j >= first; j--){ //avoiding reprint taken care of by doing j = last -1 NOT j = last (1 avoid)
		    			//System.out.println(last + "  " + j + "    ::  " + matrix[last][j] + "  ->  ");
		    			System.out.print(matrix[last][j] + "  ->  ");
		    		}
		    		for(j = last - 1; j > first; j--){  //notice it is j > first NOT >= to avoid reprint (both sides//2 avoids)
		    			System.out.print(matrix[j][first] + "  ->  ");
		    		}
    	}  // end for
    	System.out.println("end");
    	
    }
}


/*
Output:

   =======================================
1  ->  2  ->  3  ->  4  ->  5  ->  6  ->  7  ->  8  ->  9  ->  end
   =======================================
1  ->  2  ->  3  ->  4  ->  5  ->  6  ->  7  ->  8  ->  9  ->  10  ->  11  ->  12  ->  13  ->  14  ->  15  ->  16  ->  end
*/
