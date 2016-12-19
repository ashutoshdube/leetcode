import java.util.Collections;
import java.util.PriorityQueue;

/**
 * Created by Ashutosh on 12/18/16.
 */
public class KthLargestInArray {

    public int findKthLargest(int[] nums, int k) {

        PriorityQueue<Integer> maxHeap =new PriorityQueue<>(Collections.reverseOrder());
        for(int num : nums) {
            maxHeap.offer(num);
        }

        while(k != 1) {
            maxHeap.poll();
            k--;
        }

        return maxHeap.poll();

    }

    public static void main(String[] args) {

        KthLargestInArray obj = new KthLargestInArray();
        int[] test = {3,2,1,5,6,4};
        System.out.println(obj.findKthLargest(test, 4));

    }

}
