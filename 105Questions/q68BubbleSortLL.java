public class q68BubbleSortLL  {
    
    private Node head;
    private Node tail;
    public class Node{
        Node next;
        int val;
        Node(){
        }
        Node(int val){
            this.val =val;
        }
    }

    public Node append(int val){
        Node node = new Node(val);
        if(head == null){
            head=node;
            tail = node;
        }else{
            tail.next=node;
            tail=node;
        }
        return node;
    }

    public void display(){
        Node current =head;
        while(current!=null){
            System.out.print(current.val + " -> ");
            current=current.next;
        }
        System.out.println("END");
    }
    public Node getNode(int index){
        Node current = head;
        for(int i=0;i<index;i++){
            current=current.next;
        }
        return current;
    }
    public void bubbleSort(int row,int col){
        if(row==0){
            return;
        }
        if(col<row){
            Node first = getNode(col);
            Node second = getNode(col+1);

            //cases
            if(first.val > second.val){
                //swap
                if(first == head){
                    head=second;
                    first.next=second.next;
                    second.next=first;
                }else if(second==tail){
                    Node prev = getNode(col-1);
                    prev.next= second;
                    tail=first;
                    first.next=null;
                    second.next=tail;
                }else{
                    Node prev = getNode(col-1);
                    prev.next=second;
                    first.next=second.next;
                    second.next=first;
                }
            }
            bubbleSort(row, col+1);
        }else{
            bubbleSort(row-1, 0);
        }
    }
    public static void main(String[]args){
        q68BubbleSortLL  ll = new q68BubbleSortLL();
        for(int i=9 ; i>0 ; i--){
            ll.append(i);
        }
        System.out.print("Before sort: ");
        ll.display();
        ll.bubbleSort(8, 0);
        System.out.print("After sort: ");
        ll.display();
    }
}
