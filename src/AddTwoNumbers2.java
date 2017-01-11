import java.util.Stack;

/**
 * Created by Ashutosh on 12/28/16.
 */
//leetcode : 445

public class AddTwoNumbers2 {

    public class ListNode {
             int val;
             ListNode next;
             ListNode(int x) { val = x; }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        Stack<Integer> number1 = new Stack<>();
        Stack<Integer> number2 = new Stack<>();


        ListNode head = l1;

        while(head != null) {
            number1.add(head.val);
            head = head.next;
        }

        head = l2;

        while(head != null) {
            number1.add(head.val);
            head = head.next;
        }

        ListNode prev = null;
        int carry = 0;
        while (number1.size() != 0 && number2.size() != 0) {

            int sum = number1.pop() + number2.pop() + carry;
            ListNode node = new ListNode(sum%10);
            carry = sum/10;
            node.next = prev;
            prev = node.next;

        }

        while(number1.size() != 0) {

            int sum = number1.pop() + carry;
            ListNode node = new ListNode(sum%10);
            carry = sum/10;
            node.next = prev;
            prev = node.next;

        }

        while(number2.size() != 0) {

            int sum = number2.pop() + carry;
            ListNode node = new ListNode(sum%10);
            carry = sum/10;
            node.next = prev;
            prev = node.next;

        }

        if (carry  != 0) {
            ListNode node = new ListNode(carry);
            node.next = prev;
            prev = node;
        }

        return  prev;
    }

    public static void main(String[] args) {

    }
}
