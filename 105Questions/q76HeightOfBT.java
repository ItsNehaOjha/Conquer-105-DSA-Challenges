
public class q76HeightOfBT {
    // two approaches : LOT and Recursion 
    // prefer recursion

    public static class Node {
        int val;
        Node left;
        Node right;
        
        Node(int val) { this.val = val; }
        Node(int val, Node left, Node right) {
                this.val = val;
                this.left = left;
                this.right = right;
        }
    } 

    public static int height(Node root){
        if(root == null){
            return 0;
        }
        int l = height(root.left);
        int r = height(root.right);

        return Math.max(l,r)+1; 
    }
    public static void main(String[] args) {
        // Creating a sample binary tree
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.left.right.right = new Node(6);
        root.left.right.right.right = new Node(7);

       
        int depth = height(root);
        System.out.println("Maximum depth of the binary tree: " + depth);
    }

}
