import java.util.Queue;

public class q81zigZagPath{
    public static class Node{
        int data;
        Node left;
        Node right;
        public Node(int val){
            data = val;
            left = null;
            right = null;

        }
    }
    public static List<List<Integer>> zigzagPath(Node root){
        List<List<Integer>> result = new Arraylist<>();
        if(root == null)return result;
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        boolean leftToRight = true;
        while(!q.isEmpty()){
            int size = q.size();
            List<Integer> row = new Arraylist<>();
            for(int i=0; i<size ; i++){
                Node node = q.poll();
                if(leftToRight){
                    row.add(node.val);
                }else{
                    row.add(0,node.val);
                }
            }
            leftToRight = !leftToRight;
            result.add(row);
        }
        return resut;
    }
    public static void main(String[] args) {
        // Node1
        Node root1 = new Node(1);
        root1.left = new Node(2);
        root1.right = new Node(3);
        root1.left.left = new Node(4);

        // Node2
        Node root2 = new Node(1);
        root2.left = new Node(2);
        root2.right = new Node(3);
        root2.left.left = new Node(4);


        if (isIdentical(root1, root2)) {
            System.out.println("The binary trees are identical.");
        } else {
            System.out.println("The binary trees are not identical.");
        }
    }
}