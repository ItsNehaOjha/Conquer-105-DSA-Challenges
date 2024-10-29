public class q69ReversedLL {
    private static Node head;
    private Node tail;

    public class Node {
        private Node next;
        private int val;

        Node() {}
        Node(int val) {
            this.val = val;
        }
    }

    public Node append(int val) {
        Node node = new Node(val);
        if (head == null) {
            head = node;
            tail = node;
        } else {
            tail.next = node;
            tail = node;
        }
        return node;
    }

    public void revRec(Node node) {
        if (node == tail) {
            head = node;
            return;
        }
        
        revRec(node.next);
        tail.next = node;
        tail = node;
        tail.next = null;
    }

    public void display() {
        Node current = head;
        while (current != null) {
            System.out.print(current.val + " -> ");
            current = current.next;
        }
        System.out.println("END");
    }

    public static void main(String[] args) {
        q69ReversedLL ll = new q69ReversedLL();
        for (int i = 9; i > 0; i--) {
            ll.append(i);
        }
        System.out.print("Before reverse: ");
        ll.display();
        ll.revRec(head);
        System.out.print("Reversed: ");
        ll.display();
    }
}
