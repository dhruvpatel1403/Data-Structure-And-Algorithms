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
    public static int size = 0;

    public void addFirst(int data){
        size++;
        Node newNode = new Node(data);

        if(head==null){
            head=tail= newNode;
            return;
        }

        newNode.next = head;

        head = newNode;
    }
    public void addLast(int data){
        size++;
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
        if(index == 0){
            addFirst(data);
            return;
        }
        size++;
        Node temp=head;
        int i=0;
        
        while(i<index-1){
            temp=temp.next;
            i++;
        }

        Node newNode = new Node(data);
        // i = ind-1 and temp = prev element
        newNode.next = temp.next;
        temp.next = newNode;
    }
    public void size(){
        System.out.println(size);
    }
    public void removeFirst(){
        if(size==0){
            System.out.println("Can Not Remove element");
            return;
        }
        size--;
        if(size==1){
            head = tail = null;
            return;
        }
        head = head.next;
        
    }
    public void removeLast(){
        if(size==0){
            System.out.println("Empty Linked list");
            return;
        }
        else if(size==1){
            head=tail=null;
            size=0;
            return;
        }
        Node prev = head;
        for(int i=0;i<size-2;i++){
            prev = prev.next;
        }
        prev.next = null;
        tail = prev;
        size--;
    }
    public int search(int key){
        if(size==0){
            return -1;
        }
        Node temp = head;
        // for(int i=0;i<size;i++){
        //     if(temp.data==key){
        //         return i;
        //     }
        //     temp = temp.next;
        // }
        int i=0;
        while(temp != null){
            if(temp.data==key){
                return i;
            }
            temp = temp.next;
            i++;
        }
        return -1;
    }
    public int recSearch(int key,Node temp,int i){
        if(temp == null){
            System.out.println("key Not found");
            return -1;
        }
        if(temp.data == key){
            return i;
        }
        return recSearch(key, temp.next, ++i);
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
        System.out.println(ll.size);
        ll.removeFirst();
        ll.printLinkedList();
        ll.removeLast();
        ll.printLinkedList();
        System.out.println(ll.search(5));
        Node temp = head;
        int i=0;
        System.out.println(ll.recSearch(6,temp,i));
    } 
}