/*
* Given an bunch of airline tickets with [from, to], for example [MUC, LHR], [CDG, MUC], [SFO, SJC], [LHR, SFO], 
* please reconstruct the itinerary in order, 
* for example: [ CDG, MUC, LHR, SFO, SJC ]. 
//tickets can be represented as nodes
*/

import java.util.HashMap;

public class FlightItinerary {

	public static void main(String[] args){
		System.out.println("HERE");
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("MUC", "LHR");
		map.put("CDG", "MUC");
		map.put("LHR", "SFO");
		map.put("SFO", "SGC");
		String start = "";
		for(String str : map.keySet()){
			if(!map.values().contains(str)){
				start = str;
				break;
			}
		}
		String res = "[ " + start;
		int i = 0;
		while(i < map.size()){
			res += "  " +  map.get(start);
			start = map.get(start);
			i++;
		}
		res += " ]";
		System.out.println("Result: " + res);
	}
	
}
