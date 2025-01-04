import java.util.*;


public class q75PostOrderUsing2Stack {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
                this.val = val;
                this.left = left;
                this.right = right;
        }
    }    
    public static List<Integer> BinaryTreePostorder(TreeNode root){
        List<Integer>preorder = new ArrayList<>();
        if(root == null){
            return preorder;
        }
        Stack<TreeNode> st1 = new Stack<>();
        Stack<TreeNode> st2 = new Stack<>();
        st1.push(root);
        while(!st1.isEmpty()){
            root = st1.pop();
            st2.push(root);
            if(root.left!=null){
                st1.push(root.left);
            }
            if(root.right!=null){
                st1.push(root.right);
            }
        }
        while(!st2.isEmpty()){
            preorder.add(st2.pop().val);
        }
        return preorder;
    }
    public static void printList(List<Integer> list) {
        // Iterate through the list
        // and print each element
        for (int num : list) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        // Creating a sample binary tree
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        // Getting postorder traversal
        List<Integer> result = BinaryTreePostorder(root);

        // Printing the postorder traversal result
        System.out.print("Postorder traversal: ");
        printList(result);
    }
}
