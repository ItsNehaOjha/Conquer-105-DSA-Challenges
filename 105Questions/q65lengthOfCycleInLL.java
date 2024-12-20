/**
 * Question: Length of the Cycle in a Linked List
 * 
 * Given a linked list, if it contains a cycle, find the length of the cycle.
 * 
 * For example:
 * Input:
 * List: 3 -> 2 -> 0 -> -4
 * Cycle: 2 -> 0 -> -4 -> 2 (the tail connects back to the second node)
 * Output: 3 (the length of the cycle)
 */

 public class q65lengthOfCycleInLL {
    private Node head;
    private Node tail;
    
    // Constructor to initialize the linked list
    public q65lengthOfCycleInLL() {
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

    // Method to find the length of the cycle in the linked list
    public int lengthCycle(Node head) {
        Node fast = head;
        Node slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                // Calculate length of the cycle
                Node temp = slow;
                int length = 0;
                do {
                    temp = temp.next; // Move to the next node
                    length++;
                } while (temp != slow);
                return length; // Return the length of the cycle
            }
        }
        return 0; // No cycle
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
        q65lengthOfCycleInLL list = new q65lengthOfCycleInLL();
        list.insertAtLast(3);
        list.insertAtLast(2);
        list.insertAtLast(0);
        list.insertAtLast(-4);

        // Creating a cycle for demonstration
        list.head.next.next.next.next = list.head.next; // Cycle: -4 -> 2

        System.out.println("Linked List:");
        list.display(); // Display the list

        int cycleLength = list.lengthCycle(list.head);
        if (cycleLength > 0) {
            System.out.println("Length of Cycle: " + cycleLength); // Display cycle length
        } else {
            System.out.println("No Cycle Detected."); // No cycle detected
        }
    }
}
