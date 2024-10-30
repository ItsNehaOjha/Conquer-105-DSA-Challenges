public class q71ReverseSegment {
    private static Node head;
    private Node tail;

    public class Node{
        private Node next;
        private int val;
        Node(){
        }
        Node(int val){
            this.val=val;
        }
    }
    public Node append(int val){
        Node node= new Node(val);
        if(head==null){
            head=node;
            tail=node;
        }else{
            tail.next=node;
            tail=node;
        }
        return node;
    }
    public void display(){
        Node current=head;
        while(current!=null){
            System.out.print( current.val+" -> ");
            current=current.next;
        }    
        System.out.println("END ");
    }
    public Node reverseSegment(Node head,int left,int right){
        Node current=head;
        Node next=null;
        Node prev=null;
        //shift left
        for(int i=0;i<left-1;i++){
            prev=current;
            current=current.next;
        }
        Node last=prev;
        Node newEnd=current;
        //reverse
        for(int i=0;i<right-left+1;i++){
            next=current.next;
            current.next=prev;
            prev=current;
            current=next;
        }
        if(last!=null){
            last.next=prev;
        }else{
            head=prev;
        }
        newEnd.next=current;
        return head;
    }
    public static void main(String[] args) {
        q71ReverseSegment list= new q71ReverseSegment();
        for(int i=5;i>0;i--){
            list.append(i);
        }
        list.display();
        head=list.reverseSegment(head,2, 4);
        list.display();
    }
}
