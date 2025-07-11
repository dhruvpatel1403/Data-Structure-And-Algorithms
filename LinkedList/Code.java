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
    public int removeFirst(){
        if(head.next == null){
            int data = head.data;
            head = tail = null;
            return data;
        }
        int val = head.data;
        head = head.next;
        return val;
    }
    public int removeLast(){
        if(head == tail){
            int val = head.data;
            head = tail = null;
            return val;
        }
        int val = tail.data;
        Node temp = head;
        while(temp.next != tail){
            temp = temp.next;
        }
        temp.next = null;
        return val;
    }
    public void reverse(){
        Node prev= null;
        Node curr = head;
        Node next;
        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head = prev;
    }
    public static boolean isPalindrome(){
        Node slow = head;
        Node fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        Node prev = null;
        Node curr = slow;
        Node next;
        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        Node right = prev;
        Node left = head;
        while(right != null){
            if(left.data != right.data){
                return false;
            }
            left = left.next;
            right = right.next;
        }
        return true;
    }
    public boolean isCycle(){
        Node slow = head;
        Node fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        Code ll = new Code();
        // ll.addFirst(10);
        // ll.addFirst(15);
        // ll.addLast(20);
        // ll.printLinkedList();
        // ll.addMiddle(2, 0);
        // ll.removeFirst();
        // ll.removeLast();
        ll.addLast(10);
        ll.addLast(20);
        ll.addLast(30);
        ll.addLast(20);
        ll.addLast(10);
        ll.reverse();
        ll.printLinkedList();
        System.out.println(ll.isCycle());
        // System.out.println(ll.isPalindrome());
    }
}
