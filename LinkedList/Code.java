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
            head = tail =  newNode;
            return;
        }

        newNode.next = head;
        head = newNode;
    }
    public void printLinkedList(){
        Node temp = head;
        while(temp != null){
            System.out.print(temp.data+" --> ");
            temp = temp.next;

        }
        System.out.println("null");
    }
    public void addLast(int data){
        Node newNode = new Node(data);
        if(head == null){
            head = tail = newNode;
            return;
        }
        tail.next = newNode;
        tail = newNode;
    }
    public void addMiddle(int ind,int data){
        Node newNode = new Node(data);
        int i=0;
        Node temp = head;
        while( i < ind -1 && temp != null){
            temp = temp.next;
            i++;
        }
        newNode.next = temp.next;
        temp.next = newNode;
    }
    public static void main(String[] args) {
        Code ll = new Code();
        ll.addFirst(10);
        ll.addFirst(15);
        ll.addLast(20);
        ll.printLinkedList();
        ll.addMiddle(2, 0);
        ll.printLinkedList();
    }
}
