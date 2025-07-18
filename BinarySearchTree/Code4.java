package BinarySearchTree;

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
    public static Node buildTree(Node root,int val){
        if(root == null){
            return new Node(val);
        }
        if(root.data > val){
            root.left = buildTree(root.left, val);
        }
        else if(root.data < val){
            root.right = buildTree(root.right, val);
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
    public static boolean search(Node root,int val){
        if(root == null){
            return false;
        }
        if(root.data == val){
            return true;
        }
        else if(root.data > val){
            return search(root.left, val);
        }
        else{
            return search(root.right, val);
        }
    }
    public static Node delete(Node root,int val){
        if(root == null){
            return null;
        }
        if(root.data > val){
            root.left =  delete(root.left, val);
        }
        else if(root.data < val){
            root.right = delete(root.right, val);
        }
        else{
            if(root.left == null && root.right == null){
                return null;
            }
            else if(root.left == null){
                return root.right;
            }
            else if(root.right == null){
                return root.left;
            }
            else{
                Node inOrder = findInOder(root.right);
                root.data = inOrder.data;
                root.right = delete(root.right, inOrder.data);

            }
        }
        return root;
    }
    public static Node findInOder(Node root){
        while(root.left != null){
            root = root.left;
        }
        return root.left;
    }
    public static void printInRange(Node root,int n1,int n2){
        if(root == null){
            return;
        }
        printInRange(root.left, n1, n2);
        if(n1<=root.data && root.data<= n2){
            System.out.print(root.data+" ");
        }
        printInRange(root.right, n1, n2);
    }
    public static void main(String[] args) {
        int arr[] = {1,2,3,4,5,6};
        Node root = null;
        for(int i=0;i<arr.length;i++){
            root = buildTree(root, arr[i]);
        }
        // inOrder(root);
        // System.out.println(search(root, 5));
        // root = delete(root, 5);
        // inOrder(root);
        printInRange(root, 3, 5);
    }
}
