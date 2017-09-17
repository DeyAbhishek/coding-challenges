/*
678. Valid Parenthesis String

Given a string containing only three types of characters: '(', ')' and '*', 
write a function to check whether this string is valid. We define the validity of a string by these rules:

Any left parenthesis '(' must have a corresponding right parenthesis ')'.
Any right parenthesis ')' must have a corresponding left parenthesis '('.
Left parenthesis '(' must go before the corresponding right parenthesis ')'.
'*' could be treated as a single right parenthesis ')' or a single left parenthesis '(' or an empty string.
An empty string is also valid.

Example 1:
Input: "()"
Output: True
Example 2:
Input: "(*)"
Output: True
Example 3:
Input: "(*))"
Output: True
Note:
The string size will be in the range [1, 100].
*/

public class ValidParenthesisString {

    public boolean isvalidParenthesisString(String input) {
        return isvalidParenthesisStringHelper(input, 0);
    }
    
    private boolean isvalidParenthesisStringHelper(String input, int leftParenthesisLeftToBeMatched) {
    
        //while scanning the input string from left to right we cannot have 
        //no. of closing brackets ')' > no. of opening brackets '('
        if (leftParenthesisLeftToBeMatched < 0) return false;
        
        if (input.size() == 0) return leftParenthesisLeftToBeMatched == 0;
        
        if (input.chatAt(0) == ')') {
          return isvalidParenthesisString(s.substring(1), leftParenthesisLeftToBeMatched + 1);
        }
        
        if (input.chatAt(0) == '(') {
          return isvalidParenthesisString(s.substring(1), leftParenthesisLeftToBeMatched - 1);
        }
        
        if (input.charAt(0) == '*') {
          return isvalidParenthesisString(s.substring(1), leftParenthesisLeftToBeMatched + 1)  // '*' treated as '('
                  || isvalidParenthesisString(s.substring(1), leftParenthesisLeftToBeMatched - 1)  // '*' treated as ')'
                  || isvalidParenthesisString(s.substring(1), leftParenthesisLeftToBeMatched);  // '*' treated as enmpty string
        }
    }

}
