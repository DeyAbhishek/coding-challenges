package package1;

import java.util.HashMap;

public class SameInorder {

	public static void main(String[] args){
		
		Node a = new Node(null, null, 20);
		Node c = new Node(null, null, 21);
		Node b = new Node(a, c, 15);
		
		
		Node c1 = new Node(null, null, 21);
		Node b1 = new Node(null, c1, 15);
		Node a1 = new Node(null, b1, 20);
		
		String str1="";
		String str2 = "";
		System.out.println(sameInorder(b, a1, str1, str2));
		System.out.println(str1 + "    " + str2);
		
	}
	
	public static boolean sameInorder(Node node1, Node node2, String str1, String str2){
		if(node1 == null && node2!=null) return false;
		if(node1 != null && node2==null) return false;
		if(node1 == null && node2==null) return true;
		
		
		if(!sameInorder(node1.left,node2.left, str1, str2)) return false;
		
		System.out.println(node1.value + "    " + node2.value);
	
	
		if(node1.value != node2.value) return false;
	
		str1+= "  " + Integer.toString(node1.value);
		str2+= "  " + Integer.toString(node2.value);
		
	
		if(!sameInorder(node1.right, node2.right, str1, str2)) return false;
		
		return true;
	}
	
}
