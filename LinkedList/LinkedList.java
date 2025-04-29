package LinkedList;
public class LinkedList{
    public class Node{
        int data;
        Node next;
        public Node(int data){
            this.data=data;
            this.next=null;
        }
    }
    public static Node head;
    public static Node tail;
    public void addFirst(int data){
        Node newNode = new Node(data);

        if(head==null){
            head=tail= newNode;
            return;
        }

        newNode.next = head;

        head = newNode;
    }
    public void addLast(int data){
        Node newNode = new Node(data);

        if(head == null){
            head=tail=newNode;
            return;
        }

        tail.next = newNode;

        tail = newNode;
    } 

    public void printLinkedList(){
        if(head==null){
            System.out.println("Empty Linked List");
            return;
        }
        Node temp = head;

        while(temp != null){
            System.out.print(temp.data+ " --> ");
            temp = temp.next;
        }
        System.out.println("null");
    }
    public void addInMiddle(int index,int data){
        Node temp=head;
        int i=0;
        
        while(i<index-1){
            temp=temp.next;
            i++;
        }

        Node newNode = new Node(data);
        newNode.next = temp.next;
        temp.next = newNode;
    }
    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        ll.printLinkedList();
        ll.addFirst(5);
        ll.addFirst(6);
        ll.addLast(7);
        ll.printLinkedList();
        ll.addInMiddle(1,6);
        ll.printLinkedList();

    }
}