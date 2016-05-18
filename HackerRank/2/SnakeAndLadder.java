// https://www.hackerrank.com/challenges/the-quickest-way-up
// http://www.geeksforgeeks.org/snake-ladder-problem-2/
// http://theoryofprogramming.com/2014/12/25/snakes-and-ladders-game-code/

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class SnakeAndLadder {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        for (int i = 0; i < t; i++) {
            int[] moves = new int[101];
            int ladder = sc.nextInt();
            for (int j = 0; j < ladder; j++) {
                int a = sc.nextInt();
                int b = sc.nextInt();
                moves[a] = b;
            }
            int snakes = sc.nextInt();
            for (int k = 0; k < snakes; k++) {
                int c = sc.nextInt();
                int d = sc.nextInt();
                moves[c] = d;
            }
            Queue<Node> queue = new LinkedList<Node>();
            Node s = new Node(1, 0);
            Node end = new Node(0,0);
            boolean[] visited = new boolean[101];
            visited[1] = true;
            queue.add(s);
            while(!queue.isEmpty()) {
                end = queue.poll();
                int v = end.value;
                if (v == 100) {
                    break;
                }
                for (int k = v + 1; k <= 100 && k <= v + 6; k++) {
                    if (!visited[k]) {
                        Node n = new Node(k, end.dist + 1);
                        visited[k] = true;
                        if (moves[k] != 0) {
                            n.value = moves[k];
                        }
                        n.parent = end;
                        queue.add(n);
                    }
                }
            }
            if (end.value == 100) {
                System.out.println(end.dist);
            } else {
                System.out.println("-1");
            }
            
            /*while (end != null) {
                System.out.print(end.value + "  <-- ");
                end = end.parent;
            }*/
        }
    }
    
    private static class Node {
        public int value;
        public int dist;
        public Node parent = null;
        public Node(int v, int d) {
            value = v;
            dist = d;
        }
    }
}

/*
Markov takes out his Snakes and Ladders game and stares at the board, and wonders: If he had absolute control on the die, and
could get it to generate any number (in the range 1-6) he desired, what would be the least number of rolls of the die in which
he'd be able to reach the destination square (Square Number 100) after having started at the base square (Square Number 1)?

Rules

Markov has total control over the die and the face which shows up every time he tosses it. You need to help him figure out
the minimum number of moves in which he can reach the target square (100) after starting at the base (Square 1).

A die roll which would cause the player to land up at a square greater than 100, goes wasted, and the player remains at his
original square. Such as a case when the player is at Square Number 99, rolls the die, and ends up with a 5.

If a person reaches a square which is the base of a ladder, (s)he has to climb up that ladder, and he cannot come down on it.
If a person reaches a square which has the mouth of the snake, (s)he has to go down the snake and come out through the tail - there
is no way to climb down a ladder or to go up through a snake.

Constraints

The board is always of the size 10 x 10 and Squares are always numbered 1 to 100. 
1 <= T <= 10 
1 <= Number of Snakes <= 15 
1 <= Number of Ladders <= 15 
Square number 1 and 100 will not be the starting point of a ladder or a snake. 
No square will have more than one of the starting or ending point of a snake or ladder (e.g. snake 56 to 44 and 
ladder 44 to 97 is not possible because 44 has both ending of a snake and a starting of a ladder)

Input Format

The first line contains the number of tests, T. T testcases follow.

For each testcase, the first line contain N(Number of ladders) and after that N line follow. Each of the N line
contain 2 integer representing the starting point and the ending point of a ladder respectively.

The next line contain integer M(Number of snakes) and after that M line follow. Each of the M line contain 2
integer representing the starting point and the ending point of a snake respectively.

Output Format

For each of the T test cases, output one integer, each in a new line, which is the least number of moves
(or rolls of the die) in which the player can reach the target square (Square Number 100) after starting at the base 
(Square Number 1). This corresponds to the ideal sequence of faces which show up when the die is rolled. 
If there is no solution, print -1.

Sample Input

2
3
32 62
42 68
12 98
7
95 13
97 25
93 37
79 27
75 19
49 47
67 17
4
8 52
6 80
26 42
2 72
9
51 19
39 11
37 29
81 3
59 5
79 23
53 7
43 33
77 21 
Sample Output

3
5
Explanation

For the first test: To traverse the board via the shortest route, the player first rolls the die to get a 5, 
and ends up at square 6. He then rolls the die to get 6. He ends up at square 12, from where he climbs the ladder to square 98. 
He then rolls the die to get '2', and ends up at square 100, which is the target square. So, the player required 3 rolls of the 
die for this shortest and best case scenario. So the answer for the first test is 3.
*/
