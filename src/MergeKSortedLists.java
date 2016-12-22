import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Created by Ashutosh on 12/21/16.
 */
public class MergeKSortedLists {


    public static class ListNode {
              int val;
              ListNode next;
              ListNode(int x) { val = x; }
    }

    public class Entry{
        Integer value;
        Integer index;

        public Entry(Integer value, Integer index) {
            this.value = value;
            this.index = index;
        }
    }

    public class EntryComparator implements Comparator<Entry> {
        @Override
        public int compare(Entry o1, Entry o2) {
            return o1.value.compareTo(o2.value);
        }
    }

    public ListNode mergeKLists(ListNode[] lists) {

        if(lists == null) {
            return null;
        }

        ListNode output = null;
        ListNode outputTail = output;
        int nullListCount = 0;
        PriorityQueue<Entry> minHeap = new PriorityQueue<>(new EntryComparator());
        ListNode[] headPointers = new ListNode[lists.length];

        for(int i = 0; i < lists.length; i++) {
            if(lists[i] != null) {
                headPointers[i] = lists[i];
                minHeap.add(new Entry(lists[i].val, i));
            } else {
                headPointers[i] = lists[i];
                nullListCount++;
            }
        }

        while(nullListCount != lists.length) {

            Entry entry = minHeap.poll();
            int outputVal = entry.value;
            if(outputTail == null) {
                outputTail = new ListNode(outputVal);
                output = outputTail;
            } else {
                outputTail.next = new ListNode(outputVal);
                outputTail = outputTail.next;
            }

            int index = entry.index;
            if(headPointers[index].next != null) {
                headPointers[index] = headPointers[index].next;
                minHeap.add(new Entry(headPointers[index].val, index));
            } else {
                nullListCount++;
            }
        }

        while (minHeap.size() != 0) {
            Entry entry = minHeap.poll();
            outputTail.next = new ListNode(entry.value);
            outputTail = outputTail.next;
        }

        ListNode printPointer = output;
        while(printPointer != null) {
            System.out.println(printPointer.val);
            printPointer = printPointer.next;
        }
        return output;
    }

    public static void main(String[] args) {

        MergeKSortedLists obj= new MergeKSortedLists();
        ListNode node2 = new ListNode(1);
        node2.next = new ListNode(2);
        node2.next.next = new ListNode(3);
        ListNode[] nodes = {node2};

        obj.mergeKLists(nodes);

    }
}
