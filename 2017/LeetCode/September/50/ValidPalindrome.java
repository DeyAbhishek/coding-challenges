/*
680. Valid Palindrome II
Given a non-empty string s, you may delete at most one character. Judge whether you can make it a palindrome.

Example 1:
Input: "aba"
Output: True
Example 2:
Input: "abca"
Output: True
Explanation: You could delete the character 'c'.
Note:
The string will only contain lowercase characters a-z. The maximum length of the string is 50000.
*/

class ValidPalindrome {
    public boolean validPalindrome(String s) {
        if (s.length() == 1) return true;
        return validPalindrome(s, 0, s.length() - 1, 0);
    }
    
    private boolean validPalindrome(String s, int beg, int end, int count) {
        if (count > 1) {
            return false;
        }
        if (beg >= end) {
            return true;
        }
        if (s.charAt(beg) == s.charAt(end)) {
            return validPalindrome(s, beg + 1, end - 1, count);
        }
        return validPalindrome(s, beg + 1, end, count + 1) || validPalindrome(s, beg, end - 1, count + 1);
    }
}
