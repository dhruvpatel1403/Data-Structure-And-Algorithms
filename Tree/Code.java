package Tree;
import java.util.*;
public class Code {
    static class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }

    }
    static class BinnaryTree{
        static int idx = -1;
        public static Node buildeTree(int nodes[]){

            idx++;

            if(nodes[idx]==-1){
                return null;
            }

            Node newNode = new Node(nodes[idx]);

            newNode.left = buildeTree(nodes);
            newNode.right = buildeTree(nodes);

            return newNode;
        }
        public static void preOrder(Node root){

            if(root == null){
                System.out.print(-1+" ");
                return;
            }

            System.out.print(root.data+" ");
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
            if(root == null){
                return;
            }
            Queue<Node> q = new LinkedList<>();
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
                    System.out.print(curr.data+" ");
                    if(curr.left != null){
                        q.add(curr.left);
                    }
                    if(curr.right != null){
                        q.add(curr.right);
                    }
                }
            }
        }
        public static int height(Node root){
            if(root == null){
                return 0;
            }
            int lh = height(root.left);
            int rh = height(root.right);
            return Math.max(lh,rh) + 1;   
        }
        public static int countNodes(Node root){
            if(root == null){
                return 0;
            }
            int lh = countNodes(root.left);
            int rh = countNodes(root.right);
            return lh + rh + 1;   
        }
        public static int sumNodes(Node root){
            if(root == null){
                return 0;
            }
            int lh = sumNodes(root.left);
            int rh = sumNodes(root.right);
            return lh + rh + root.data;   
        }
        public static int diameter(Node root){
            if(root==null){
                return 0;
            }
            int ld = diameter(root.left);
            int lh = height(root.left);
            int rh = height(root.right);
            int rd = diameter(root.right);
    
            return Math.max(Math.max(ld,rd),lh+rh+1);
        }
    }  
    public static void main(String[] args) {
        int nodes[] = {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
        BinnaryTree tree = new BinnaryTree();
        Node root  = tree.buildeTree(nodes);
        // System.out.println(root.data);
        // tree.preOrder(root);
        // System.out.println();
        // tree.inOrder(root);
        // System.out.println();
        // tree.postOrder(root);
        // System.out.println();
        // tree.levelOrder(root);
        // System.out.println();
        // System.out.println(tree.height(root));
        // System.out.println(tree.countNodes(root));
        // System.out.println(tree.sumNodes(root));
        System.out.println(tree.diameter(root));
    }
}
