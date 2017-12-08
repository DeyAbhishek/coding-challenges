/*
Implement atoi to convert a string to an integer.

Hint: Carefully consider all possible input cases. If you want a challenge, 
please do not see below and ask yourself what are the possible input cases.

Notes: It is intended for this problem to be specified vaguely 
(ie, no given input specs). You are responsible to gather all the input requirements up front.


spoilers alert... 

Requirements for atoi:
The function first discards as many whitespace characters as necessary 
until the first non-whitespace character is found. Then, starting from 
this character, takes an optional initial plus or minus sign followed by 
as many numerical digits as possible, and interprets them as a numerical value.

The string can contain additional characters after those that form the integral 
number, which are ignored and have no effect on the behavior of this function.

If the first sequence of non-whitespace characters in str is not a valid integral 
number, or if no such sequence exists because either str is empty or it contains only 
whitespace characters, no conversion is performed.

If no valid conversion could be performed, a zero value is returned. If the correct 
value is out of the range of representable values, INT_MAX (2147483647) or INT_MIN (-2147483648) is returned.

*/

class Atoi {
    public int myAtoi(String str) {
        if (str == null || str.isEmpty()) {
            return 0;
        }
        int res = 0;
        boolean neg = false;
        str = str.trim();
        int i = 0;
        if (str.charAt(i) == '-') {
            i++;
            neg = true;
        } else if (str.charAt(i) == '+') {
            i++;
        }
        
        int lastDigit_MIN_VALUE = Math.abs(Integer.MIN_VALUE % 10);
        int lastDigit_MAX_VALUE = Integer.MAX_VALUE % 10;
        
        while (i < str.length() && (str.charAt(i) <= '9' && str.charAt(i) >= '0')) {
            // handle overflow
            if (res > Integer.MAX_VALUE / 10) {
                if (neg) {
                    return Integer.MIN_VALUE;
                } else {
                    return Integer.MAX_VALUE;
                }
            } 
            if (res == Integer.MAX_VALUE / 10) {
                if (neg) {
                    if (str.charAt(i) - '0' > lastDigit_MIN_VALUE) {
                        return Integer.MIN_VALUE;
                    }
                } else {
                    if (str.charAt(i) - '0' > lastDigit_MAX_VALUE) {
                        return Integer.MAX_VALUE;
                    }
                }
            }
            res = res * 10 + (str.charAt(i++) - '0');
        }
        
        if (neg) {
            res = -res;
        }
        return res;
    }
}
