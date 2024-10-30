    public class q70ReverseLLInPlace {
        private static Node head;
        private Node tail;

        public class Node {
            private Node next;
            private int val;

            Node() {
            }

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

        public void display() {
            Node current = head;
            while (current != null) {
                System.out.print(current.val + " -> ");
                current = current.next;
            }
            System.out.println("END");
        }

        public Node reverseInPlace(Node head){
            Node current=head;
            Node next=null;
            Node prev=null;
            while(current!=null){
                next=current.next;
                current.next=prev;
                prev=current;
                current=next;
            }
            head=prev;
            return head;

        }
        public static void main(String[] args) {
            q70ReverseLLInPlace ll = new q70ReverseLLInPlace();
            for (int i = 9; i > 0; i--) {
                ll.append(i);
            }
            System.out.print("Before reverse: ");
            ll.display();
            head =ll.reverseInPlace(head);
            System.out.print("Reversed: ");
            ll.display();
        }
    }
