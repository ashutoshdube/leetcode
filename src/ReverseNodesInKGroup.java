import java.util.List;

/**
 * Created by Ashutosh on 12/30/16.
 */
public class ReverseNodesInKGroup {

    public class ListNode {
             int val;
             ListNode next;
             ListNode(int x) { val = x; }
    }

    public ListNode reverseKGroup(ListNode head, int k) {

        ListNode top = null;
        ListNode last = null;
        ListNode start = head;
        ListNode tail = head;
        int count = k;
        while (tail != null && count > 0) {
            tail = tail.next;
        }

        if(tail == null && count != 0) {
            return head;
        }

        ListNode prev = tail;
        ListNode curr = head;
        ListNode next = head.next;
        last = curr;

        count = k;

        while (true) {
            curr.next = prev;
            count--;
            if(count == 0) {
                break;
            }
            prev = curr;
            curr = next;
            next = curr.next;
        }

        if(head == null) {
            head = curr;
        }

        return null;

    }

    public static void main(String[] args) {

    }

}
