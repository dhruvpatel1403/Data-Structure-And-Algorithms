package Tree;
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
    }  
    public static void main(String[] args) {
        int nodes[] = {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
        BinnaryTree tree = new BinnaryTree();
        Node root  = tree.buildeTree(nodes);
        System.out.println(root.data);
        tree.preOrder(root);
        tree.inOrder(root);

    }
}
