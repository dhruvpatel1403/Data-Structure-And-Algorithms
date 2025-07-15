package Tree;

public class Code4 {
    static class Node{
        int data;
        Node left;
        Node right;
        public Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
    public static int idx = -1;
    public static Node buildetree(int arr[]){
        idx++;
        if(arr[idx] == -1){
            return null;
        }
        Node newNode = new Node(arr[idx]);
        newNode.left = buildetree(arr);
        newNode.right = buildetree(arr);
        return newNode;
    }
    
    public static void main(String[] args) {
        int arr[] = {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
        Node root = buildetree(arr);
        preorder(root);
        System.out.println();
        inOrder(root);
    }
}
