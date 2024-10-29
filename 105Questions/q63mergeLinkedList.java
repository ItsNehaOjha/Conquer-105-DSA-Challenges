/**
 * Question: Merge Two Sorted Linked Lists
 * 
 * Given two sorted linked lists, merge them so that the resulting linked 
 * list is also sorted. The merge should be done without using any extra space. 
 * 
 * For example:
 * Input: 
 * List1: 1 -> 2 -> 4
 * List2: 1 -> 3 -> 4
 * Output: 1 -> 1 -> 2 -> 3 -> 4 -> 4
 */

 public class q63mergeLinkedList {
    private Node head;
    private Node tail;
    
    // Constructor to initialize the linked list
    public q63mergeLinkedList() {
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

    // Method to merge two sorted linked lists
    public q63mergeLinkedList merge(q63mergeLinkedList first, q63mergeLinkedList second) {
        Node f = first.head;
        Node s = second.head;

        q63mergeLinkedList ans = new q63mergeLinkedList();

        while (f != null && s != null) {
            if (f.val < s.val) {
                ans.insertAtLast(f.val);
                f = f.next;
            } else {
                ans.insertAtLast(s.val);
                s = s.next;
            }
        }
        while (f != null) {
            ans.insertAtLast(f.val);
            f = f.next;
        }
        while (s != null) {
            ans.insertAtLast(s.val);
            s = s.next;
        }

        return ans;
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
        q63mergeLinkedList list1 = new q63mergeLinkedList();
        list1.insertAtLast(1);
        list1.insertAtLast(2);
        list1.insertAtLast(4);

        q63mergeLinkedList list2 = new q63mergeLinkedList();
        list2.insertAtLast(1);
        list2.insertAtLast(3);
        list2.insertAtLast(4);

        System.out.println("List 1:");
        list1.display(); // Display the first list

        System.out.println("List 2:");
        list2.display(); // Display the second list

        q63mergeLinkedList mergedList = list1.merge(list1, list2);
        
        System.out.println("Merged List:");
        mergedList.display(); // Display the merged list
    }
}
