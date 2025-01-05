import java.lang.Math;
public class q77BalancedBT {
    // Input:Binary Tree: 3 9 20 -1 -1 15 7
    // Output: True, This is a Balanced Binary Tree.
    // Explanation: The difference in the height of left and right subtree is 1 hence the tree is balanced.
    public static class Node{
        int val;
        Node left;
        Node right;
        Node(int val){
            this.val = val;
        }
    }
    public static boolean isBalanced(Node root){
        return dfs(root) != -1;
    }
    public static int dfs(Node root){
        if(root == null){
            return 0;
        }
        int lh = dfs(root.left);
        if(lh == -1){
            return -1;
        }
        int rh = dfs(root.right);
        if(rh == -1){
            return -1;
        }
        if(Math.abs(lh - rh)>1){
            return -1;
        }
        return Math.max(lh,rh)+1;
    }
    public static void main(String[] args) {

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.left.right.right = new Node(6);
        root.left.right.right.right = new Node(7);

        if (isBalanced(root)) {
            System.out.println("The tree is balanced.");
        } else {
            System.out.println("The tree is not balanced.");
        }
    }
}
