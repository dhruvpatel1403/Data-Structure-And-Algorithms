package BinarySearchTree;
public class Code {
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
        public static Node buildTree(int val,Node root){
            if(root == null){
                // I null then create new Node and then return it.
                Node newNode = new Node(val);
                return newNode;
            }
            else if(root.data >= val){
                root.left = buildTree(val, root.left);
            }
            else{
                root.right = buildTree(val, root.right);
            }
            return root;
        }
        public static void inOrder(Node root){
            if(root == null){
                return;
            }
            inOrder(root.left);
            System.out.print(root.data+" ");
            inOrder(root.right);
        }
    public static void main(String[] args) {
        int arr[] = {5,1,3,4,2,7};
        Node root= null;
        for(int i=0;i<arr.length;i++){
            root = buildTree(arr[i],root);
        }
        inOrder(root);
    }
    
}
