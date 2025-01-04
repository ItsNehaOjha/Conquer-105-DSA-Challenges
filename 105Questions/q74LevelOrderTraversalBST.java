import java.util.*;



public class q74LevelOrderTraversalBST {
//     // Input: Binary Tree: 4 2 5 3 -1 7 6 -1 9 -1 -1 8 -1 1
//     Output:[ [4],[ 2, 5 ],[ 3, 7, 6],[ 9, 8],[ 1 ]] 
// Explanation: We traverse the binary tree level by level using the following traversal:

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

        public static List<List<Integer>> levelOrder(TreeNode root){
                List<List<Integer>> res = new ArrayList<>();
                if(root == null){
                        return res;
                }
                Queue<TreeNode> q = new LinkedList<>();
                q.offer(root);
                while(!q.isEmpty()){
                        int levelSize = q.size();
                        List<Integer>currentLevel = new ArrayList<>();
                        for(int i=0;i<levelSize;i++){
                                TreeNode node = q.poll();
                                currentLevel.add(node.val);
                                if(node.left!=null){
                                        q.offer(node.left);
                                }
                                if(node.right!=null){
                                        q.offer(node.right);
                                }
                        }
                        res.add(currentLevel);
                }
                return res;

        }
        public static void main(String[] args) {
        // Create a sample binary tree (you might need to adjust this based on your input format)
                TreeNode root = new TreeNode(4);
                root.left = new TreeNode(2);
                root.right = new TreeNode(5);
                root.left.left = new TreeNode(3);
                root.left.right = new TreeNode(7);
                root.right.right = new TreeNode(6);
                root.left.left.left = new TreeNode(9);
                root.left.left.right = new TreeNode(8);
                root.left.right.right = new TreeNode(1);

                // Perform level order traversal
                List<List<Integer>> result = levelOrder(root);

                // Print the result
                System.out.println(result); 
        }
}


