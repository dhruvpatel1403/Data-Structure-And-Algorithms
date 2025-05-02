package LinkedList;

public class DoubllyLL {
    public class Node{
        int data;
        Node next;
        Node prev;
        public Node(int data){
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }
    public static Node head;
    public static Node tail;
    public static int size=0;
    
    public void addFirst(int data){
        Node newNode = new Node(data);
        size++;

        if(head == null){
            head= tail = newNode;
            return;
        }

        head.prev = newNode;
        newNode.next = head;
        head = newNode;
    }
    public void printLL(){
        Node temp = head;
        while(temp != null){
            System.out.print(temp.data+"<-->");
            temp = temp.next;
        }
        System.out.print("null");
        System.out.println();
    }
    public void addLast(int data){
        Node newNode = new Node(data);
        size++;
        if(head == null){
            head=tail=newNode;
            return;
        }
        tail.next = newNode;
        newNode.prev = tail;
        tail=newNode;
    }
    public static void main(String args[]){
        DoubllyLL dll = new DoubllyLL();
        dll.addFirst(1);
        dll.addFirst(2);
        dll.addFirst(3);
        dll.addLast(0);
        dll.printLL();
    }
}
