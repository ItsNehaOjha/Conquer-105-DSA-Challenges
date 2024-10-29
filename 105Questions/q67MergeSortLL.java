public class q67MergeSortLL {
    private LinkNode head;
    private LinkNode tail;
    
    public q67MergeSortLL() {
    }
    public class LinkNode {
        private LinkNode next;
        private int value;

        LinkNode(int val) {
            this.value = val;
            this.next = null; // Initialize next to null
        }
    }

    private void addFirst(int value) { 
        LinkNode node = new LinkNode(value);
        node.next = head;
        head = node;
        if (tail == null) {
            tail = node;
        }
    }

    private void addLast(int value) { 
        if (head == null) {
            addFirst(value);
            return;
        }
        LinkNode node = new LinkNode(value);
        tail.next = node;
        tail = node;
    }

     public LinkNode getMid(LinkNode head){
        LinkNode midPrev = null;
        while(head != null && head.next !=null){
            midPrev = (midPrev == null) ? head:midPrev.next;
            head = head.next.next;
        }
        LinkNode mid = midPrev.next;
        midPrev.next=null;
        return mid;
    }

    private LinkNode merge(LinkNode left, LinkNode right) {
        LinkNode dummyHead = new LinkNode(0); // Temporary dummy node
        LinkNode tail = dummyHead;

        // Merge two sorted linked lists
        while (left != null && right != null) {
            if (left.value < right.value) {
                tail.next = left;
                left = left.next;
            } else {
                tail.next = right;
                right = right.next;
            }
            tail = tail.next;
        }

        // Attach remaining nodes from left or right
        tail.next = (left != null) ? left : right;

        return dummyHead.next; // Return the merged list starting after dummy
    }

    public LinkNode sortList(LinkNode head) {
        // Base case: if the list is empty or has one element
        if (head == null || head.next == null) {
            return head;
        }
        LinkNode mid = getMid(head);
        LinkNode left = sortList(head);
        LinkNode right= sortList(mid);

        // Merge the sorted halves
        return merge(left, right);
    }

    public void printList() {
        LinkNode current = head;
        while (current != null) {
            System.out.print(current.value + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        q67MergeSortLL list = new q67MergeSortLL();
        
        // Adding elements to the linked list
        list.addLast(4);
        list.addLast(2);
        list.addLast(5);
        list.addLast(1);
        list.addLast(3);

        System.out.println("Original Linked List:");
        list.printList();

        // Sorting the linked list
        list.head = list.sortList(list.head);

        System.out.println("Sorted Linked List:");
        list.printList();
    }
}
