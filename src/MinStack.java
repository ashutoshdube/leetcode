import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ashutosh on 1/1/17.
 */
public class MinStack {

    List<Integer> stack;
    List<Integer> minimum;
    int top;

    /** initialize your data structure here. */
    public MinStack() {
        stack = new ArrayList<>();
        minimum = new ArrayList<>();
        top = -1;
    }

    public void push(int x) {
        stack.add(++top, x);
        if(top == 0 || x < minimum.get(top - 1)) {
            minimum.add(top, x);
        } else {
            minimum.add(minimum.get(top - 1));
        }
    }

    public void pop() {
        if(top >= 0)
            top--;
    }

    public int top() {
        if(top == -1) {
            return -1;
        } else {
            return stack.get(top);
        }
    }

    public int getMin() {
        if(top == -1) {
            return -1;
        } else {
            return minimum.get(top);
        }
    }

    public int getMiddle() {
        if(top == -1) {
            return -1;
        } else {
            return stack.get(top/2);
        }
    }

    public static void main(String[] args) {

    }
}
