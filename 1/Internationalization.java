/*
i18n (where 18 stands for the number of letters between the first i and 
the last n in the word “internationalization,”) Wiki it. 

Generate all such possible i18n strings for any given string. 
for eg. "careercup"=>"c7p","ca6p","c6up","car5p","ca5up","care4p",
"car4up","caree3p","care3up"..till the count is 0 which means its the complete string again.
*/

public class Internationalization {

	public static void main(String[] args){
		
		String str = "Internationalization";
		int length = str.length();
		int count = 1;
		StringBuilder sb;
		if(length > 2){
			while(count < length - 1){
			sb = new StringBuilder();
			sb.append(str.substring(0, count));
			int k = length - count - 1;
			sb.append(String.valueOf(k));
			sb.append(str.charAt(length - 1));
			System.out.println(sb.toString());
			count++;
			}
		}
		System.out.println(str);
		
	}
	
}
