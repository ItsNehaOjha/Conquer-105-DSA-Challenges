import java.util.Stack;

public class q73QueueUsingStack {
    private Stack<Integer> s1;
    private Stack<Integer> s2;

    public q73QueueUsingStack(){
        s1 = new Stack<>();
        s2 = new Stack<>();
    }
    public void push(int x) {
        s1.push(x);
    } 
    
    public int pop() throws Exception {
        if (s1.isEmpty() && s2.isEmpty()) {
            throw new Exception("Queue is empty");
        }
        
        // Move elements from s1 to s2 if s2 is empty
        if (s2.isEmpty()) {
            while (!s1.isEmpty()) {
                s2.push(s1.pop());
            }
        }
        
        return s2.pop();
    }
    public int peek() throws Exception {
        if (s1.isEmpty() && s2.isEmpty()) {
            throw new Exception("Queue is empty");
        }
        
        // Move elements from s1 to s2 if s2 is empty
        if (s2.isEmpty()) {
            while (!s1.isEmpty()) {
                s2.push(s1.pop());
            }
        }
        
        return s2.peek();
    }
    public boolean empty() {
        return s1.isEmpty() && s2.isEmpty();
    }
    public static void main(String[] args) {
        q73QueueUsingStack queue = new q73QueueUsingStack();
        queue.push(20);
        queue.push(28);
        queue.push(27);
        try {
            System.out.println("Front element (peek): " + queue.peek()); 
            
            // Pop an element from the queue
            System.out.println("Popped element: " + queue.pop());
            
            // Check the front element again
            System.out.println("Front element after pop (peek): " + queue.peek()); 
            
            // Check if the queue is empty
            System.out.println("Is queue empty? " + queue.empty());
            
            // Pop remaining elements
            System.out.println("Popped element: " + queue.pop()); 
            System.out.println("Popped element: " + queue.pop()); 
            
            // Check if the queue is empty now
            System.out.println("Is queue empty? " + queue.empty());
            // Try to pop from an empty queue (this will throw an exception)
            System.out.println("Attempting to pop from empty queue: " + queue.pop());
        } catch (Exception e) {
            System.out.println(e.getMessage()); 
        }

    }
}
