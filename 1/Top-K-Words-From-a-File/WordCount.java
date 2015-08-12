
public class WordCount implements Comparable<WordCount>{
	public String word;
	public int count;
	
	public WordCount(String str, int count){
		word = str;
		this.count = count;
	}
	
	public int hashCode(){
		return word.length();
	}
	public boolean equals(Object ob){
		if(ob instanceof WordCount){
			return word.equals(((WordCount) ob).word);
		}
		return false;
	}
	
	public int compareTo(WordCount ob){
		
			return ob.count - this.count;  //Since I want the result in DESCending order
		
	}

}
