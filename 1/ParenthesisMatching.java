import java.util.*;


public class ParenthesisMatching {

	public static void main(String[] args){
		String str = "()(){}{}{()}";
		String str1 = "((({}{}))()";
		String str2 = "{()([])()({}{})}";
		System.out.println(str + "  " + checkParenthesis(str));	
		System.out.println(str1 + "  " + checkParenthesis(str1));	
		System.out.println(str2 + "  " + checkParenthesis(str2));	
	}
	
	private static boolean checkParenthesis(String str){
		int i = 0;
		int len = str.length() - 1;
		if(str.charAt(0) == ']' || str.charAt(0) == '}' || str.charAt(0) == ')'){
			return false;
		}
		Stack<Character> stack = new Stack<Character>();
		while(i <= len){
			if(str.charAt(i) == '{' || str.charAt(i) == '(' || str.charAt(i) == '[') {
				stack.push(str.charAt(i));
			}
			else {
				if (stack.isEmpty()) return false;
				char c = str.charAt(i);
				if(c == ')'){
					if(stack.peek() != '(') return false;
				}
				else if(c == '}'){
					if(stack.peek() != '{') return false;
				}
				else if (c == ']'){
					if(stack.peek() != '[') return false;					
				}
				stack.pop();
			}
			i++;
		}
		return stack.isEmpty();
		}
		
		
	}
	

