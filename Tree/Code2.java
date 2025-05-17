package Tree;
import java.util.*;
public class Code2 {
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
    static class BinaryTree{
        static int idx = -1;
        public static Node buildTree(int arr[]){
            idx++;
            if(arr[idx] == -1){
                return null;
            }
            Node newNode = new Node(arr[idx]);
            newNode.left = buildTree(arr);
            newNode.right = buildTree(arr);

            return newNode;
        }
        
        public static void preOrder(Node root){
            if(root == null){
                return;
            }
            System.out.print(root.data+ " ");
            preOrder(root.left);
            preOrder(root.right);
        }
        public static void inOrder(Node root){
            if(root == null){
                return;
            }
            inOrder(root.left);
            System.out.print(root.data+" ");
            inOrder(root.right);
        }
        public static void postOrder(Node root){
            if(root == null){
                return;
            }
            postOrder(root.left);
            postOrder(root.right);
            System.out.print(root.data+" ");
        }
        public static void levelOrder(Node root){
            Queue<Node> q= new LinkedList<>();
            q.add(root);
            q.add(null);
            while(!q.isEmpty()){
                Node curr = q.remove();
                if(curr == null){
                    System.out.println();
                    if(q.isEmpty()){
                        break;
                    }else{
                        q.add(null);
                    }
                }else{
                    System.out.print(curr.data+ " ");
                    if(curr.left != null){
                        q.add(curr.left);
                    }
                    if(curr.right != null){
                        q.add(curr.right);
                    }
                }
            }
        }
        public static int heightOfBT(Node root){
            if(root == null){
                return 0;
            }
            int lh = heightOfBT(root.left);
            int rh = heightOfBT(root.right);
            return Math.max(lh,rh)+1;
        }
        
    }
    
    public static void main(String[] args) {
        int nodes[] = {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
        BinaryTree tree = new BinaryTree();
        Node root = tree.buildTree(nodes);
        // System.out.println(root.data);
        // tree.preOrder(root);
        // System.out.println();
        // tree.inOrder(root);
        // System.out.println();
        // tree.postOrder(root);
        // System.out.println();
        // tree.levelOrder(root);
        System.out.println(tree.heightOfBT(root));

    }
}
