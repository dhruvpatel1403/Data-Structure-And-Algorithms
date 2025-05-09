package LinkedList;
public class LinkedList{
    public static class Node{
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
    public void reverse(){
        Node prev = null;
        Node curr = tail = head;
        Node next;

        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        head = prev;
    }
    public void deleteNthFromEnd(int n){
        Node temp = head;
        if(n==size){
            head = head.next;
            return;
        }

        for(int i=1;i<size-n;i++){
            temp = temp.next;
        }
        Node curr = temp.next;
        temp.next = curr.next;
    }

    public Node findMyMid(Node head){
        Node slow=head;
        Node fast = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public boolean palindrom(){
        if(head ==null || head.next == null){
            return true;
        }

        // 1) find middle
        Node mid = findMyMid(head);

        // 2) Reverse Second half rigth part
        Node prev = null;
        Node curr = mid;
        Node next;

        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        Node right = prev;
        Node left = head;
        
        // 3) compare left with rigth

        while(right != null){
            if(left.data != right.data){
                return false;
            }
            right = right.next;
            left = left.next;
        }

        return true;
    }
    public static void isCycle(Node head){
        Node slow = head;
        Node fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                System.out.println("Cycle is present");
                return;
            }
        }
        System.out.println("cycle not found");
    }
    public static void removeCycle(Node head){
        Node slow = head;
        Node fast = head;
        int cycle = 0;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow==fast){
                cycle = 1;
                break;
            }
        }
        if(cycle==1){
            if (slow == head) {
                while (fast.next != slow) {
                    fast = fast.next;
                }
                fast.next = null;
                System.out.println("Cycle removed (head was part of the cycle)");
                return;
            }
            slow = head;
            Node prev = null;
            while(slow != fast){
                slow = slow.next;
                prev = fast;
                fast = fast.next;
            }
            prev.next = null;
            System.out.println("Cycle is removed");
        }
        
    }
    public void zigZagLL(){
        //mid
        Node slow = head;
        Node fast = head.next;
        while(fast != null && fast.next !=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        // reverse after mid
        Node mid = slow.next;

        slow.next = null;

        Node prev = null;
        Node curr = mid;
        Node next;
        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        
        // connect left with right
        Node left = head;
        Node right = prev;

        while(left != null && right != null){
            Node leftNext = left.next;
            Node rightNext = right.next;
            left.next = right;
            right.next = leftNext;

            left = leftNext;
            right = rightNext;
        }
    }
    public static Node mergeLL(Node head){
        if(head == null || head.next == null){
            return head;
        }
        Node mid = getMid(head);
        Node right = mid.next;
        mid.next = null;
        Node left = head;
        Node newLeft = mergeLL(left);
        Node newRight = mergeLL(right);
        return merge(newLeft , newRight);
    }
    public static Node getMid(Node head){
        Node slow= head;
        Node fast = head.next;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    public static Node merge(Node left,Node right){
        Node mergedLL = new Node(-1);
        Node temp = mergedLL;
        while(left!= null && right!= null){
            if(left.data <=right.data){
                temp.next = left;
                temp = temp.next;
                left = left.next;
            }
            else{
                temp.next = right;
                temp = temp.next;
                right = right.next;
            }
        }
        while(left != null){
            temp.next = left;
            temp = temp.next;
            left = left.next;
        }
        while(right != null){
            temp.next = right;
            temp = temp.next;
            right = right.next;
        }

        return mergedLL.next;
    }
    public static void main(String[] args) {
        // LinkedList ll = new LinkedList();
        // ll.printLinkedList();
        // ll.addFirst(2);
        // ll.addFirst(1);
        // // ll.addLast(1);
        // // ll.printLinkedList();
        // ll.addInMiddle(1,2);
        // // ll.printLinkedList();
        // // System.out.println(ll.size);
        // // ll.removeFirst();
        // // ll.printLinkedList();
        // // ll.removeLast();
        // // ll.printLinkedList();
        // // System.out.println(ll.search(6));
        // // System.out.println(ll.recSearch(6,head,0));
        // // ll.reverse();
        // ll.printLinkedList();
        // // ll.deleteNthFromEnd(4);
        // // ll.printLinkedList();
        // System.out.println(ll.palindrom());
        // head = new Node(1);
        // head.next = new Node(2);
        // head.next.next = new Node(3);
        // head.next.next.next = new Node(4);
        // head.next.next.next.next = new Node(5);
        // head.next.next.next.next.next = head;
        // // isCycle(head);
        // removeCycle(head);
        // isCycle(head);
        LinkedList ll = new LinkedList();
        ll.addLast(5);
        ll.addLast(4);
        ll.addLast(3);
        ll.addLast(2);
        ll.addLast(1);
        ll.printLinkedList();
        ll.head = ll.mergeLL(ll.head);
        ll.printLinkedList();

    } 
}