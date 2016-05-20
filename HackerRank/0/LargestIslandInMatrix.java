//https://www.hackerrank.com/challenges/connected-cell-in-a-grid
// Recurcive Flood Fill Approach

public class LargestIslandInMatrix {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int rows = sc.nextInt();
        int cols = sc.nextInt();
        int max = 0;
        //Integer count = 0;
        int[] count = new int[1];
        int[][] arr = new int [rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                    arr[i][j] = sc.nextInt();
            }
        }
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                count[0] = 0;
                visit(arr, i, j, rows, cols, count);
                if (max < count[0]) {
                    max = count[0];
                }
            }
        }
        
        System.out.println(max);
    }
    
    private static void visit(int[][] arr, int i, int j, int rows, int cols, int[] count)  {
        if (i < 0 || j < 0 || i > rows - 1 || j > cols - 1) {
            return;
        }
        if (arr[i][j] == 0 || arr[i][j] == -1) {
            return;
        }
        arr[i][j] = -1;
        count[0]++;
        visit(arr, i - 1, j, rows, cols, count);  // up
        visit(arr, i + 1, j, rows, cols, count);  // down
        visit(arr, i, j - 1, rows, cols, count);  // left
        visit(arr, i, j + 1, rows, cols, count);  // right
        visit(arr, i - 1, j - 1, rows, cols, count);  // top-left
        visit(arr, i - 1, j + 1, rows, cols, count);  // top-right
        visit(arr, i + 1, j - 1, rows, cols, count);  // bottom-left
        visit(arr, i + 1, j + 1, rows, cols, count);  // bottom-right
    }
}

/*
You are given a matrix with  rows and  columns of cells, each of which contains either  or .
Two cells are said to be connected if they are adjacent to each other horizontally, vertically, or diagonally. 
The connected and filled (i.e. cells that contain a ) cells form a region. There may be several regions in the matrix. 
Find the number of cells in the largest region in the matrix.

Input Format
There will be three parts of t input:
The first line will contain , the number of rows in the matrix.
The second line will contain , the number of columns in the matrix.
This will be followed by the matrix grid: the list of numbers that make up the matrix.

Output Format
Print the length of the largest region in the given matrix.

Constraints



Sample Input:

4
4
1 1 0 0
0 1 1 0
0 0 1 0
1 0 0 0
Sample Output:

5
Task: 
Write the complete program to find the number of cells in the largest region.

Explanation

X X 0 0
0 X X 0
0 0 X 0
1 0 0 0  
The X characters indicate the largest connected component, as per the given definition. There are five cells in this component.
*/
