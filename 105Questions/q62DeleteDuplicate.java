/**
 * Question: Remove Duplicates from Sorted Linked List
 * 
 * Given a sorted linked list, delete all duplicates such that each element 
 * appears only once. 
 * 
 * For example:
 * Input: head = [1, 1, 2, 3, 3, 4]
 * Output: [1, 2, 3, 4]
 */

 public class q62DeleteDuplicate {
    private Node head;
    private Node tail;
    
    // Constructor to initialize the linked list
    public q62DeleteDuplicate() {
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

    // Insert node at the end of the list
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

    // Method to remove duplicates from the linked list
    public void deleteDublicate() {
        Node current = head; // Start with the head of the list
        while (current != null && current.next != null) {
            if (current.val == current.next.val) {
                current.next = current.next.next; // Skip the duplicate
            } else {
                current = current.next; // Move to the next node
            }
        }
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
        q62DeleteDuplicate list = new q62DeleteDuplicate();
        
        // Inserting values into the linked list (some duplicates)
        list.insertAtLast(1);
        list.insertAtLast(1);
        list.insertAtLast(2);
        list.insertAtLast(3);
        list.insertAtLast(3);
        list.insertAtLast(4);
        
        System.out.println("Original list:");
        list.display(); // Display the original list

        // Remove duplicates
        list.deleteDublicate();
        
        System.out.println("List after removing duplicates:");
        list.display(); // Display the updated list
    }
}
