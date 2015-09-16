// A data structure with insertion, deletion, conains, random accesss all in O(1) time :)  \m/
// only works with distinct elements

import java.util.*;
public class EfficientDataStructure{

     int SIZE;
     String[] arr;
     HashMap<String, Integer> map;
     int count;
     
     public EfficientDataStructure(int size){
     arr = new String[size];    
     map = new HashMap<String, Integer>();
     count = 0;
     SIZE = size;
     }
     
     private boolean insert(String str){
         count++;
         if(count >= SIZE) return false;
         arr[count] = str;
         map.put(str, count);
         return true;
     }
     
     private boolean delete(String str){
         if(!map.containsKey(str)) return false;
         int index = map.get(str);
         String replaceWith = arr[count];
         arr[index] = replaceWith;
         count--;
         map.remove(str);
         map.put(replaceWith, index);
         return true;
     }
     
     private boolean delete(int index){
         if(index >= map.size()) return false;
         String elementToDelete = arr[index];
         String replaceWith = arr[count];
         arr[index] = replaceWith;
         count--;
         map.remove(elementToDelete);
         map.put(replaceWith, index);
         return true;
     }
     
     private boolean contains(String str){
         return map.containsKey(str);
     }
     
     private String getElementAtIndex(int index){
         return arr[index];
     }
     
     private String getRandom(){
         int index = rand(0, map.size());
         return arr[index];
     }
     private int size(){
         return map.size();
     }
     
     private int rand(int beg, int end){
         int range = end - beg + 1;
         return beg + (int)(Math.random() * range);
     }
        public static void main(String []args){
        EfficientDataStructure ds = new EfficientDataStructure(100);
        System.out.println(ds.arr.length);
        System.out.println("Size now: " + ds.size());
        ds.insert("Hello");
        ds.insert("World");
        System.out.println("Size after 2 insertions: " + ds.size());
        System.out.println("Random Access: " + ds.getRandom() );
        System.out.println(ds.contains("IamNotThere"));
        System.out.println(ds.contains("Hello"));
        ds.delete("Hello");
        System.out.println("Size after deletion: " + ds.size());
        System.out.println(ds.getElementAtIndex(1));
        System.out.println(ds.delete(0));
        System.out.println("Size After Another Deletion: " + ds.size() + "  " + ds.getRandom() + "  "  + ds.arr.length);
     }
     
}
