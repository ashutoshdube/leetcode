/**
 * Created by Ashutosh on 12/28/16.
 */
//leetcode : 237

public class DeleteNodeInLinkedList {


    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }

    public void deleteNode(ListNode node) {

        node.val=node.next.val;
        node.next=node.next.next;

    }

}
