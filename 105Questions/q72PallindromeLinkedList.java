public class q72PallindromeLinkedList {
    private static Node head;
    private Node tail;

    public class Node{
        Node next;
        int val;
        Node(){

        }
        Node(int val){
            this.val=val;
        }
    }
    public Node append(int val){
        Node node = new Node(val);
        if(head==null){
            head=node;
            tail=node;
        }else{
            tail.next=node;
            tail=node;
        }
        return node;
    }
    public Node getMid(Node head){
        Node fast=head;
        Node slow = head;
        while(fast!=null && fast.next!=null){
            slow= slow.next;
            fast= fast.next.next;
        }
        return slow;
    }
    public Node reverseLink(Node head){
        Node current=head;
        Node next=null;
        Node prev= null;
        while(current!=null){
            next= current.next;
            current.next= prev;
            prev= current;
            current= next;
        }
        head=prev;
        return head;
    }
    public void display(){
        Node current=head;
        while(current!=null){
            System.out.print(current.val + " -> ");
            current= current.next;
        }
        System.out.println("END");
    }

    //Check Pallindrome 
    public boolean pallindrome(Node head){
        Node mid = getMid(head);
        Node secondHalfHead= reverseLink(mid);
        Node rereverseHead= secondHalfHead;

        while(head !=null && secondHalfHead !=null){
            if(head.val != secondHalfHead.val){
                break;
            }
            head= head.next;
            secondHalfHead= secondHalfHead.next;
        }
        reverseLink(rereverseHead);
        return head == null || secondHalfHead==null ;
    }

    public static void main(String[] args) {
        q72PallindromeLinkedList llist = new q72PallindromeLinkedList();
        llist.append(1);
        llist.append(2);
        llist.append(2);
        llist.append(1);
        System.out.print("List: ");
        llist.display();
        System.out.println(llist.pallindrome(head));

    }

}
