public class LinkedList {
    private Node head;

    Node insertNotRecursive(Node node){
        if (head == null) {
            head = node;
        } else {
            // travers until the tail of the list
            Node curret = head;
            while(curret.getNext() != null){
                curret = curret.getNext();
            }
            // set the the last node
            curret.setNext( node );
        }
        return node;
    }

    private static Node insertRecursive(Node node, Node new_node){
        if (node == null){
            node = new_node;
        }else{
            node.setNext( insertRecursive( node.getNext(), new_node ) );
        }
        return node;
    }

    private static void printRecursive(Node node){
        if (node != null){
            System.out.println(node.getData());
            printRecursive(node.getNext());
        }
    }

    private static int lenghtRecursive(Node node){
        if (node == null){
            return 0;
        }else{
            return 1 + lenghtRecursive(node.getNext());
        }
    }

    int length(){
        return lenghtRecursive(head);
    }

    Node insert(Node node){
        return insertRecursive(head, node);
    }

    void print(){
        printRecursive(head);
    }



    // delete first occurrence from the list by the given key
    boolean deleteByKey(int key){
        Node current = head;
        Node prev = null;

        // case head got the key
        if (current!= null && current.getData() == key){
            head = current.getNext();
            return true;
        }

        else{
            while(current != null && current.getData() != key){
                prev = current;
                current = current.getNext();
            }

            // case found so current not null
            if (current != null){
                prev.setNext( current.getNext() );
                return true;
            }

            return false;
        }

    }

    boolean deleteAtPosition(int pos){
        // case pos = 0
        if (pos == 0 && head != null){
            head = head.getNext();
            return true;
        }

        // case pos between 0 nad list length
        int count = 0;
        Node current = head;
        Node prev = null;
        while( current != null ){
            if (count != pos){
                prev = current;
                current = current.getNext();
                count++;
            } else {
                // found
                prev.setNext( current.getNext() );
                return true;
            }
        }

        return false;
    }

    void printNotRecursive(){
        Node current = head;
        while (current != null) {
            System.out.println(current.getData());
            current = current.getNext();
        }

    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();

        list.insertNotRecursive(new Node(1));
        list.insertNotRecursive(new Node(1));
        list.insertNotRecursive(new Node(2));
        list.insert(new Node(5));
        list.insert(new Node(10));

        list.deleteByKey(1);
        list.deleteByKey(5);

        list.print(); // 1 2 10
        System.out.println("Lenght : " + list.length()); // 3
    }
}


class Node {
    private int data;
    private Node next;

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    Node(int data){
        this.data = data;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }
}
