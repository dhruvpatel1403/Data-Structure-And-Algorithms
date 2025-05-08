package QueueDS;
public class CircQueue {
    static class Queue{
        static int arr[];
        static int size;
        static int front;
        static int rear;
        public Queue(int n){
            arr = new int[n];
            size = n;
            rear = -1;
            front = -1;
        }
        public boolean isEmpty(){
            return front == -1 && rear == -1;
        }
        public boolean isFull(){
            return (rear+1) % size == front;
        }
        public void add(int data){
            if(isFull()){
                System.out.println("Queue is already full");
                return;
            }
            if(front == -1){
                front =  0;
            }
            rear = (rear + 1) % size;
            arr[rear] = data;
        }
        public int remove(){
            if(isEmpty()){
                System.out.println("cannot delete the value beacuse queue is empty");
                return -1;
            }
           
            int val = arr[front];
            
            if(rear == front){
                rear = front = -1;
            }
            else{
                front = ( front+1 )% size;
            }
            return val;
        }
        public void peek(){
            if(isEmpty()){
                System.out.println("Queue is already empty");
                return;
            }
            System.out.println(arr[front]+" ");
        }
    }
    public static void main(String[] args) {
        Queue q = new Queue(10);
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);
        while(!q.isEmpty()){
            System.out.println(q.remove());
        }
    }
}
