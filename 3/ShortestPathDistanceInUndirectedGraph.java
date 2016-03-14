Source of the problem statement: https://www.hackerrank.com/challenges/bfsshortreach
/*
Given an undirected graph consisting of NN nodes (labelled 1 to N) where a specific given node SS represents the start position and an edge between any two nodes is of length 66 units in the graph.

It is required to calculate the shortest distance from start position (Node S) to all of the other nodes in the graph.

Note 1: If a node is unreachable , the distance is assumed as −1−1. 
Note 2: The length of each edge in the graph is 66 units.

Input Format

The first line contains TT, denoting the number of test cases. 
First line of each test case has two integers NN, denoting the number of nodes in the graph and MM, denoting the number of edges in the graph. 
The next MM lines each consist of two space separated integers x yx y, where xx and yy denote the two nodes between which the edge exists. 
The last line of a testcase has an integer SS, denoting the starting position.

Constraints 
1≤T≤101≤T≤10 
2≤N≤10002≤N≤1000 
1≤M≤N×(N−1)21≤M≤N×(N−1)2 
1≤x,y,S≤N1≤x,y,S≤N

Output Format

For each of TT test cases, print a single line consisting of N−1N−1 space-separated integers, denoting the shortest distances of the N-1 nodes from starting position SS. This will be done for all nodes same as in the order of input 1 to N.

For unreachable nodes, print −1−1.

Sample Input

2
4 2
1 2
1 3
1
3 1
2 3
2
Sample Output

6 6 -1
-1 6
*/

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class ShortestPathDistanceInUndirectedGraph {

    public static void main(String[] args) {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //int testcases = Integer.parseInt(br.readLine());
       
        Scanner scanner = new Scanner(System.in);
        int testcases = scanner.nextInt();
        while (testcases > 0) {
            
            HashMap<Integer, ArrayList<Integer>> graph = new HashMap<Integer, ArrayList<Integer>>();
            
            int nodes = scanner.nextInt();
            int edges = scanner.nextInt();
            while (edges > 0) {
                int a = scanner.nextInt();
                int b = scanner.nextInt();
                if (!graph.containsKey(a)) {
                    graph.put(a, new ArrayList<Integer>());
                }
                ArrayList<Integer> children = graph.get(a);
                if(!children.contains(b)) {
                    children.add(b);
                    graph.put(a, children);
                    
                    //Mapping should be done both ways : a -> b, b -> a in undirected graph
                    if (!graph.containsKey(b)) {
                        graph.put(b, new ArrayList<Integer>());
                    }
                    ArrayList<Integer> children2 = graph.get(b);
                    children2.add(a);
                    graph.put(b, children2);
                }
                     
                edges--;
            }
               
            int start = scanner.nextInt();
             
            HashMap<Integer, Integer> result = new HashMap<Integer, Integer>();
            
            result.put(start, 0);
            Queue<Integer> queue = new LinkedList<Integer>();
             
            HashSet<Integer> visited = new HashSet<Integer>();
            
            queue.add(start);
            visited.add(start);
            
            while (!queue.isEmpty()) {
                int parent = queue.poll();
                if (graph.containsKey(parent)) {
                    for (Integer node : graph.get(parent)) {
                        if (!visited.contains(node)) {
                            visited.add(node);
                            queue.add(node);
                            result.put(node, result.get(parent) + 6);
                        }
                    }
               }
            }
            
            int count = 1;
            
            String str = "";
            
            while (count <= nodes) {
                if (count !=start) {
                    if (result.get(count) != null) {
                        str += result.get(count) + " ";
                    } else {
                       str += "-1 "; 
                    }
                }
                count++;
            }
            
            System.out.println(str);
            
            testcases--;
        }
    }
}

Input:
1
10 6
3 1
10 1
10 1
3 1
1 8
5 2
3

Output:
6 -1 -1 -1 -1 -1 12 -1 12

======================================================================
LEARNING:
A very silly mistake that I was making while coding it:
Not mapping the nodes both ways in the graph HashMap since it is an Undirected graph.
If there is a node 1 - 3
Then what we need to do is:
graph.put(1, 3);
graph.put(3, 1);

Instead what I was doing was like :
graph.put(1, 3) only.
