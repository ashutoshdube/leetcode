import java.util.Collections;
import java.util.PriorityQueue;

/**
 * Created by Ashutosh on 12/21/16.
 */
public class FindMedian {

    PriorityQueue<Integer> minHeap = new PriorityQueue<>(Collections.reverseOrder());
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>();

    public void addNum(int num) {

        if(minHeap.size() ==0 && maxHeap.size() == 0) {
            minHeap.add(num);
            return;
        }

        if(num <= minHeap.peek()) {
            minHeap.add(num);
            if(Math.abs(minHeap.size() - maxHeap.size()) > 1) {
                maxHeap.add(minHeap.poll());
            }
            return;
        } else {
            maxHeap.add(num);
            if(Math.abs(minHeap.size() - maxHeap.size()) > 1) {
                minHeap.add(maxHeap.poll());
            }
            return;
        }

    }

    public void printQueues() {

    }

    public double findMedian() {

        if(minHeap.size() != 0 && maxHeap.size() != 0) {
            if(minHeap.size() == maxHeap.size()) {
                return (minHeap.peek() + maxHeap.peek()) / 2.0;
            } else {
                return minHeap.size() > maxHeap.size() ? minHeap.peek() : maxHeap.peek();
            }
        }

        if(maxHeap.size() == 0 && minHeap.size() == 0) {
            return 0;
        }

        return minHeap.peek();

    }

    public static void main(String[] args) {

        FindMedian obj = new FindMedian();
        obj.addNum(1);
        obj.addNum(2);
        obj.addNum(3);
        obj.addNum(4);
        System.out.println(obj.findMedian());

    }
}
