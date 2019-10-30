import java.util.*;

public class LinkedList{

	private class Node{
		Node(int val){this.val = val;}
		int val;
		Node next;
	}

	Node head;

	void add(int val){
		if (head == null){
			head  = new Node(val);
		}else{
			// travel through the list
			Node current = head;
			while (current.next != null){
				current = current.next;
			}
			current.next = new Node(val);
		}
	}

	@Override
	public String toString(){

		String out = "";

		// travel throwugh the list
		Node current = head;
		while (current != null){
			out += current.val + " ";
			current = current.next;
		}
		return out;
	}

	// Algorithm using extra space. Mark visited nodes and check that you
	// only visit each node once.
	public boolean hasCycle() {
	    HashSet<Node> visited = new HashSet<Node>();
	    for (Node curr = head; curr != null; curr = curr.next) {
	        if (visited.contains(curr)) return true;
	        visited.add(curr);
	    }
	    
	    return false;
	}


	// Floyd's algorithm. Increment one pointer by one and the other by two.
	// If they are ever pointing to the same node, there is a cycle.
	public boolean hasCycleFloyd(Node n) {
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

		LinkedList list = new LinkedList();

		list.add(2);
		list.add(3);
		list.add(4);

		System.out.println(list);

		System.out.println( list.hasCycle() );

		Node node = list.head.next.next;
		node.next = list.head.next;

		System.out.println( list.hasCycle() );


	}
}