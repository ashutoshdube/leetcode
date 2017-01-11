/**
 * Created by Ashutosh on 1/5/17.
 */
//leetcode : 2

public class AddTwoNumbers {


    public class ListNode {
             int val;
             ListNode next;
             ListNode(int x) { val = x; }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        if(l1 == null && l2 == null) {
            return null;
        } else if(l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        }

        ListNode head = null;
        ListNode tracker = null;
        int carry = 0;
        int n1, n2;
        int sum;

        while (l1 != null || l2 != null) {

            if(l1 != null) {
                n1 = l1.val;
                l1 = l1.next;
            } else {
                n1 = 0;
            }

            if(l2 != null) {
                n2 = l2.val;
                l2 = l2.next;
            } else {
                n2 = 0;
            }

            sum = n1 + n2 + carry;
            carry = sum/10;

            if(head == null) {
                head = new ListNode(sum%10);
                tracker = head;
            } else {
                tracker.next = new ListNode(sum%10);
                tracker = tracker.next;
            }
        }

        if(carry != 0) {
            tracker.next = new ListNode(carry);
        }

        return head;

    }

    public static void main(String[] args) {

    }
}
