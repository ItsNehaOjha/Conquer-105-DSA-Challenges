
public class q79MaxSumPathOfBST {
    // Maximum Sum Path in Binary Tree
    // Input:Binary Tree: -10 9 20 -1 -1 15 7
    // Explanation: Out of all the paths possible in the Binary Tree, 15 -> 20 -> 7 has the greatest sum ie. 42.

    public static class Node {
        int data;
        Node left;
        Node right;
    
        Node(int val) {
            data = val;
            left = null;
            right = null;
        }
    }

    public static int maxPathSum(Node root){
        int max[] = {Integer.MIN_VALUE};
        maxHeight(root,max);
        return max[0];
    }
    public static int maxHeight(Node root, int[] max){
        if(root == null){
            return 0;
        }
        int lh = Math.max(0, maxHeight(root.left, max));
        int rh = Math.max(0, maxHeight(root.right, max));
        max[0] = Math.max(max[0], lh+rh+root.data);

        return Math.max(lh, rh)+root.data;
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

        // Finding and printing the maximum path sum
        int maxPathSum = maxPathSum(root);
        System.out.println("Maximum Path Sum: " + maxPathSum);
    }

}
