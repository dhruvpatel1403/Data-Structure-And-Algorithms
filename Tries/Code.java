package Tries;

public class Code {
    static class Node{
        Node children[] = new Node[26];
        boolean eow = false;
        public Node(){
            for(int i=0;i<26;i++){
                children[i] = null;
            }
        }
    }
    static Node root = new Node();
    public static void insert(String word){
        Node curr = root;
        for(int level=0;level<word.length();level++){
            int idx = word.charAt(level)-'a';
            if(curr.children[idx]==null){
                Node newNode = new Node();
                curr.children[idx] = newNode;
            }
            curr = curr.children[idx];
        }
        curr.eow = true;
    }
    
    public static void main(String[] args) {
        String arr[] = {"the","a","there","their","any","theee"};
        for(int i=0;i<arr.length;i++){
            insert(arr[i]);
        }
        System.out.println(search("thee"));
    }
}
