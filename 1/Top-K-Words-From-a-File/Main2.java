import java.util.*;
public class Main2{

    public static void main(String[] args){
		String[] str = {"aa", "bb", "aa", "bb", "aa", "cc", "dd", "cc", "bb", "bb", "bb"}; //As of now, taking an array of string instead of reading from FILE
		System.out.println(TopK(str, 2));
	
	}
    
	
	private static String TopK(String[] str, int k){
	
    HashMap<WordCount, Integer> map = new HashMap<WordCount, Integer>();
		
		for(String s : str){
			if(map.containsKey(new WordCount(s))){
			   
			int count = map.get(new WordCount(s)) + 1;
	
			map.remove(new WordCount(s));  //We need to remove previous entry since HashMap does NOT update the key 
								//when new entry with the same key is put again
			map.put(new WordCount(s, count), count);
		
			}
			else{
			    
				map.put(new WordCount(s, 1), 1);
	
			}
		}
		List<WordCount> set = new ArrayList<WordCount>(map.keySet());  
		Collections.sort(set);
		String str2 = "";
		int i = 0;
		System.out.println("Word :: Count\n"+"---------------");
		for(WordCount w : set){
		    i++;
			str2 += w.word + "\t   "+ w.count + "\n";//map.get(w) + "  ";
			if(i==k) break;
		}
		return str2;
	}
}
