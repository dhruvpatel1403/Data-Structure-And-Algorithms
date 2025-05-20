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
        public static boolean search(Node root,int key){
            if(root == null){
                return false;
            }
            else if(root.data == key){
                return true;
            }
            else if(root.data > key){
                return search(root.left, key);
            }
            else{
                return search(root.right, key);
            }
        }
        public static Node InorderSuccessor(Node root){
            while(root.left != null){
                root = root.left;
            }
            return root;
        }
        public static Node delete(Node root,int val){
            if(root == null){
                return null;
            }
            if(root.data > val){
                root.left =  delete(root.left, val);
            }else if(root.data < val){
                root.right = delete(root.right, val);
            }
            else{
                //case 1
                if(root.left == null && root.right == null){
                    return null;
                }
                //case 2
                else if(root.left == null){
                    return root.right;
                }
                else if(root.right == null){
                    return root.left;
                }
                //case 3
                else{
                    Node IS = InorderSuccessor(root.right);
                    root.data = IS.data;
                    root.right =  delete(root.right, IS.data);
                }
            }
            return root;
        }
    public static void main(String[] args) {
        int arr[] = {5,1,3,4,2,7};
        Node root= null;
        for(int i=0;i<arr.length;i++){
            root = buildTree(arr[i],root);
        }
        inOrder(root);
        System.out.println();
        delete(root, 3);
        inOrder(root);
    }
    
}
