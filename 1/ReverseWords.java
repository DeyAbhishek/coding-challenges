import java.util.*;


public class ReverseWords {

	public static void main(String[] args){
			String input = "Hello World, From The Developer!";
			System.out.println(input);		// Hello World, From The Developer!
			System.out.println();
			System.out.println(reverseWords1(input));  // olleH ,dlroW morF ehT !repoleveD
			System.out.println(reverseWords2(input));	 // Developer! The From World, Hello 
			System.out.println(reverseWords3(input));	// !repoleveD ehT morF ,dlroW olleH 
			System.out.println();
			System.out.println(reverseWords1NotPunctuation(input));  // olleH dlroW, morF ehT repoleveD!
			System.out.println(reverseWords3NotPunctuation(input));   // repoleveD! ehT morF dlroW, olleH
	}
	
	private static String reverseWords1(String str){	// olleH ,dlroW morF ehT !repoleveD
		String[] arr = str.split("\\s");
		int count = 0, len = arr.length - 1;
		StringBuilder helper = new StringBuilder();
		StringBuilder sb =new StringBuilder();
		while(count <= len){
		helper.append(arr[count]).reverse();
		sb.append(helper + " ");
		helper.setLength(0);
		count++;
		}
		return sb.toString();
	}
	
	private static String reverseWords2(String str){	// Developer! The From World, Hello
		String[] arr = str.split("\\s");
		int count = arr.length - 1;
		StringBuilder sb =new StringBuilder();
		while(count >= 0){
			sb.append(arr[count] + " ");
		count--;
		}
		return sb.toString();
		}
	
	
	private static String reverseWords3(String str){	// !repoleveD ehT morF ,dlroW olleH
		String[] arr = str.split("\\s");
		int count = arr.length - 1;
		StringBuilder helper = new StringBuilder();
		StringBuilder sb =new StringBuilder();
		while(count >= 0){
		helper.append(arr[count]).reverse();
		sb.append(helper + " ");
		helper.setLength(0);
		count--;
		}
		return sb.toString();
	}
	
	private static String reverseWords1NotPunctuation(String str){	// olleH dlroW, morF ehT repoleveD!
		String[] arr = str.split("\\s");
		int count = 0, len = arr.length - 1;
		StringBuilder helper = new StringBuilder();
		StringBuilder sb =new StringBuilder();
		while(count <= len){String word = arr[count];
		if(word.charAt(word.length() - 1) == ',' || word.charAt(word.length() - 1) == '!'){
			helper.append(word.substring(0, word.length() - 1)).reverse().append(word.charAt(word.length() - 1));
		}
		else{
			helper.append(arr[count]).reverse();
		}
	
		sb.append(helper + " ");
		helper.setLength(0);
		count++;
		}
		return sb.toString();
	}
	
	private static String reverseWords3NotPunctuation(String str){		// repoleveD! ehT morF dlroW, olleH
		String[] arr = str.split("\\s");
		int count = arr.length - 1;
		StringBuilder helper = new StringBuilder();
		StringBuilder sb =new StringBuilder();
		while(count >= 0){
			String word = arr[count];
			if(word.charAt(word.length() - 1) == ',' || word.charAt(word.length() - 1) == '!'){
				helper.append(word.substring(0, word.length() - 1)).reverse()
										   .append(word.charAt(word.length() - 1));
			}
			else{
				helper.append(arr[count]).reverse();
			}
		
		sb.append(helper + " ");
		helper.setLength(0);
		count--;
		}
		return sb.toString();
	}
		
	}
	


// Output:
//
// Hello World, From The Developer!
//
// olleH ,dlroW morF ehT !repoleveD 
// Developer! The From World, Hello 
// !repoleveD ehT morF ,dlroW olleH 
//
// olleH dlroW, morF ehT repoleveD! 
// repoleveD! ehT morF dlroW, olleH 


