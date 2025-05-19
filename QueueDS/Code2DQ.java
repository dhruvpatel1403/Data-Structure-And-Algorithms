package QueueDS;

public class Code2DQ {
    static class Node{
        int data;
        Node next;
        public Node(int data){
            this.data = data;
            this.next = null;
        }
    }
    static class Deque{
        static Node head = null;
        static Node tail = null;
        public static boolean isEmpty(){
            return head == null;
        }
        public static void addFirst(int data){
            Node newNode = new Node(data);
            if(isEmpty()){
                head = tail = newNode;
                return;
            }
            newNode.next = head;
            head = newNode;
        }
        public static void addLast(int data){
            Node newNode = new Node(data);
            if(isEmpty()){
                head = tail = newNode;
                return;
            }
            tail.next = newNode;
            tail = newNode;
        }
        public static int removeFirst(){
            if(isEmpty()){
                System.out.println("Queue is already empty");
                return -1;
            }
            int val = head.data;
            if(head == tail){
                head = tail = null;
                return val;
            }
            head = head.next;
            return val;
        }
        public static int removeLast(){
            if(isEmpty()){
                System.out.println("Queue is already empty");
                return -1;
            }
            int val = tail.data;
            if(head == tail){
                head = tail = null;
                return val;
            }
            Node temp = head;
            while(temp.next != tail){
                temp = temp.next;
            }
            temp.next = null;
            tail = temp;
            return val;
        }
        public static int getFirst(){
            if(isEmpty()){
                System.out.println("Queue is already empty");
                return -1;
            }
            return head.data;
        }
        public static int getLast(){
            if(isEmpty()){
                System.out.println("Queue is already empty");
                return -1;
            }
            return tail.data;
        }
    }
    public static void main(String[] args) {
        Deque q = new Deque();
        q.addFirst(3);
        q.addFirst(2);
        q.addFirst(1);
        q.addLast(4);
        q.addLast(5);
        while(!q.isEmpty()){
            System.out.println(q.getLast());
            q.removeLast();
        }
    }
}
