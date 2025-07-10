package LinkedList;
public class Code {
    public static class Node{
        int data;
        Node next;
        public Node(int data){
            this.data = data;
            this.next = null;
        }
    }
    public static Node head = null;
    public static Node tail = null; 
    public void addFirst(int data){

        Node newNode = new Node(data);

        if(head == null){
            head = newNode;
            return;
        }

        newNode.next = head;
        head = newNode;
    }
    
    public static void main(String[] args) {
        Code ll = new Code();
        ll.addFirst(10);
        ll.addFirst(15);
        System.out.println("hii");
    }
}
