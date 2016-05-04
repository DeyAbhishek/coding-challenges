//https://www.hackerrank.com/challenges/balanced-parentheses

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class BalancedParenthesis {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < t; i++) {
            String input = sc.nextLine();
            if (input.charAt(0) == ']' || input.charAt(0) == '}' || input.charAt(0) == ')') {
                System.out.println("NO");
                continue;
            }
            int len = input.length();
            Stack<Character> stack = new Stack<Character>();
            for(int j = 0; j < len; j++) {
                if (input.charAt(j) == '}') {
                    if (stack.size() > 0 && stack.peek() == '{') {
                        stack.pop();
                    }
                } else  if (input.charAt(j) == ']') {
                    if (stack.size() > 0 && stack.peek() == '[') {
                        stack.pop();
                    }
                } else  if (input.charAt(j) == ')') {
                    if (stack.size() > 0 && stack.peek() == '(') {
                        stack.pop();
                    }
                } else {
                    stack.push(input.charAt(j));
                }
            }
            
            if (stack.isEmpty()) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
            
        }
    }
}
