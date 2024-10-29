/**
 * Question: Find the Middle Node of a Linked List
 * 
 * Given the head of a singly linked list, return the middle node of the linked list.
 * 
 * If there are two middle nodes, return the second middle node.
 * 
 * For example:
 * Input: 1 -> 2 -> 3 -> 4 -> 5
 * Output: 3
 * 
 * Input: 1 -> 2 -> 3 -> 4 -> 5 -> 6
 * Output: 4
 */

 public class q66MiddleOfLL {
    // Definition for singly-linked list
    public class ListNode {
        int val;
        ListNode next;

        ListNode() {}

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    // Method to find the middle node of the linked list
    public ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        
        while (fast != null && fast.next != null) {
            fast = fast.next.next; // Move fast pointer two steps
            slow = slow.next;       // Move slow pointer one step
        }
        return slow; // Slow will be at the middle node when fast reaches the end
    }

    // Method to insert a new node at the end of the list
    public ListNode insertAtEnd(ListNode head, int val) {
        ListNode newNode = new ListNode(val);
        if (head == null) {
            return newNode; // If the list is empty, return new node as head
        }

        ListNode temp = head;
        while (temp.next != null) {
            temp = temp.next; // Traverse to the end of the list
        }
        temp.next = newNode; // Link the new node at the end
        return head; // Return the unchanged head
    }

    // Method to display the linked list
    public void display(ListNode head) {
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.val + " -> ");
            temp = temp.next;
        }
        System.out.println("END");
    }

    public static void main(String[] args) {
        q66MiddleOfLL list = new q66MiddleOfLL();
        ListNode head = null;

        // Creating a linked list: 1 -> 2 -> 3 -> 4 -> 5
        head = list.insertAtEnd(head, 1);
        head = list.insertAtEnd(head, 2);
        head = list.insertAtEnd(head, 3);
        head = list.insertAtEnd(head, 4);
        head = list.insertAtEnd(head, 5);

        System.out.println("Linked List:");
        list.display(head); // Display the linked list

        ListNode middle = list.middleNode(head); // Find the middle node
        System.out.println("Middle Node Value: " + middle.val); // Display middle node value
    }
}
