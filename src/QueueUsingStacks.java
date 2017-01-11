import java.util.Stack;

/**
 * Created by Ashutosh on 1/4/17.
 */
public class QueueUsingStacks {

    Stack<Integer> tail = new Stack<>();
    Stack<Integer> head = new Stack<>();

    // Push element x to the back of queue.
    public void push(int x) {

        if(tail.isEmpty() && !head.isEmpty()) {
            while (!head.isEmpty()){
                tail.push(head.pop());
            }
        }

        tail.push(x);

    }

    // Removes the element from in front of queue.
    public void pop() {

        if(head.isEmpty() && !tail.isEmpty()) {
            while (!tail.isEmpty()){
                head.push(tail.pop());
            }
        }

        head.pop();

    }

    // Get the front element.
    public int peek() {

        if(head.isEmpty() && !tail.isEmpty()) {
            while (!tail.isEmpty()){
                head.push(tail.pop());
            }
        }

        return head.peek();

    }

    // Return whether the queue is empty.
    public boolean empty() {

        return head.isEmpty() && tail.isEmpty();
    }

}
