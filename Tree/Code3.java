package Tree;
public class Code3 {
    public static class Node{
        int data;
        Node left;
        Node right;
        public Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
    static int idx = -1;
    public static Node buildTree(int arr[]){
        
        idx++;

        if(arr[idx] == -1){
            return null;
        }
        
        Node curr = new Node(arr[idx]);
        curr.left = buildTree(arr);
        curr.right = buildTree(arr);
        return curr;
    }
    public static void preOrder(Node root){
        if(root == null){
            return;
        }
        System.out.print(root.data+" ");
        preOrder(root.left);
        preOrder(root.right);
    }
    public static void main(String[] args) {
        int nodes[] = {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
        Node root = buildTree(nodes);
        preOrder(root);
    }
}
