import java.util.*;

public class LinkedLists{

	private static class Node{
		Node(int val){this.val = val;}
		int val;
		Node next;
	}

	// Algorithm using extra space. Mark visited nodes and check that you
	// only visit each node once.
	public static boolean hasCycle(Node n) {
	    HashSet<Node> visited = new HashSet<Node>();
	    for (Node curr = n; curr != null; curr = curr.next) {
	        if (visited.contains(curr)) return true;
	        visited.add(curr);
	    }
	    
	    return false;
	}


	// Floyd's algorithm. Increment one pointer by one and the other by two.
	// If they are ever pointing to the same node, there is a cycle.
	public static boolean hasCycleFloyd(Node n) {
	    if (n == null) return false;
	    Node slow = n;
	    Node fast = n.next;
	        
	    while (fast != null && fast.next != null) {
	        if (fast == slow) return true;
	        fast = fast.next.next;
	        slow = slow.next;
	    }
	        
	    return false;
	}

	public static void main(String[] args) {

		Node start = new Node(1);
		Node current = start;

		current.next = new Node(2) ; current = current.next;
		current.next = new Node(3) ; current = current.next;
		current.next = new Node(4) ; 

		System.out.println( hasCycle(start) );

		current.next = start;

		System.out.println( hasCycleFloyd(start) );


	}
}