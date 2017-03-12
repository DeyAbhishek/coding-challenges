/*
541. Reverse String II

Difficulty: Easy
Given a string and an integer k, you need to reverse the first k characters for every 2k characters counting from the start of the string. If there are less than k characters left, reverse all of them. If there are less than 2k but greater than or equal to k characters, then reverse the first k characters and left the other as original.
Example:
Input: s = "abcdefg", k = 2
Output: "bacdfeg"
Restrictions:
The string consists of lower English letters only.
Length of the given string and k will in the range [1, 10000]
*/

public class ReverseString {
    public String reverseStr(String s, int k) {
        int len=s.length();
        StringBuilder builder=new StringBuilder();
        int i=0;
        for (i=0;i+2*k<=len;i+=2*k) {
            builder.append(new StringBuilder(s.substring(i, i+k)).reverse());
            builder.append(s.substring(i+k, i+2*k));
        }
        if (i+k<=len) {
            builder.append(new StringBuilder(s.substring(i, i+k)).reverse());
            builder.append(s.substring(i+k, len));
        }
        else builder.append(new StringBuilder(s.substring(i, len)).reverse());
        return builder.toString();
    }
    
    /----------------/
    public String reverseStr2(String s, int k) {
        if (s.length() <= k) {
            return reverse(s);
        }
        int len = s.length();
        int iter = len / (2*k);
        StringBuilder br = new StringBuilder();
        for (int i = 0; i <= iter; i++) {
            int beg1 = i * 2 * k;
            int end1 = beg1  + k;
            int beg2 = beg1 + k;
            int end2 = beg2 + k;
            if (i == iter) {
                if (end1 > len) {
                    br.append(reverse(s.substring(beg1)));
                    break;
                }
                if (end2 != len) {
                    br.append(reverse(s.substring(beg1, end1)));
                    br.append(s.substring(beg2));
                    break;
                }
            }
            
                br.append(reverse(s.substring(beg1, end1)));
                br.append(s.substring(beg2, end2));
        }
        return br.toString();
    }
    
    private String reverse(String str) {
        StringBuilder br = new StringBuilder(str);
        return br.reverse().toString();
    }
}
