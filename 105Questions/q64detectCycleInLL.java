/**
 * Question: Detect Cycle in a Linked List
 * 
 * Given a linked list, determine if it has a cycle in it. 
 * A cycle occurs when a node's next pointer points to an earlier node in the list.
 * 
 * For example:
 * Input: 
 * List: 3 -> 2 -> 0 -> -4
 * Cycle: 2 -> 0 -> -4 -> 2 (the tail connects back to the second node)
 * Output: true
 */

 public class q64detectCycleInLL {
    private Node head;
    private Node tail;
    
    // Constructor to initialize the linked list
    public q64detectCycleInLL() {
        this.head = null;
        this.tail = null;
    }

    // Definition of Node class
    public class Node {
        private int val;
        private Node next;

        public Node(int val) {
            this.val = val;
            this.next = null; // Initializes next as null
        }
    }

    // Method to insert node at the end of the list
    public void insertAtLast(int val) {
        Node newNode = new Node(val);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
    }

    // Method to detect cycle in the linked list
    public boolean hasCycle(Node head) {
        Node fast = head;
        Node slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                return true; // Cycle detected
            }
        }
        return false; // No cycle
    }

    // Display the linked list
    public void display() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.val + " -> ");
            temp = temp.next;
        }
        System.out.println("END");
    }

    public static void main(String[] args) {
        q64detectCycleInLL list = new q64detectCycleInLL();
        list.insertAtLast(3);
        list.insertAtLast(2);
        list.insertAtLast(0);
        list.insertAtLast(-4);

        // Creating a cycle for demonstration
        list.head.next.next.next.next = list.head.next; // Cycle: -4 -> 2

        System.out.println("Linked List:");
        list.display(); // Display the list

        boolean hasCycle = list.hasCycle(list.head);
        System.out.println("Cycle Detected: " + hasCycle); // Display cycle detection result
    }
}
