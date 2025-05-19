package QueueDS;
public class Codep {
    static class Queue{
        static int array[];
        static int size;
        static int rear;
        static int front;
        public Queue(int n){
            array = new int[n];
            size = n;
            rear = -1;
            front = -1;
        }
        public static boolean isEmpty(){
            return rear == -1 && front ==-1;
        }
        public static boolean isFull(){
            return (rear+1)%size == front;
        }
        public static void add(int val){
            if(isFull()){
                System.out.println("Queue is already full");
                return;
            }
            if(isEmpty()){
                rear = front = 0;
                array[rear] = val;
                return;
            }
            rear= ( rear + 1 ) % size;
            array[rear] = val;
        }
        public static int remove(){
            if(isEmpty()){
                System.out.println("Array is already empty");
                return -1;
            }
            if(front == rear){
                int val = array[front];
                front = rear = -1;
                return val;
            }
            int val = array[front];
            front = ( front + 1 ) % size;
            return val;
        }
    }
    public static void main(String[] args) {
        Queue q = new Queue(10);
        q.add(5);
        q.add(6);
        while (!q.isEmpty()) {
            System.out.println(q.remove());
        }
    }
}
