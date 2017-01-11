import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Ashutosh on 1/5/17.
 */
public class MinHeap {


    List<Integer> heap;

    public MinHeap() {

        heap = new LinkedList<>();

    }

    public void addValue(Integer value) {

        heap.add(value);
        percolateUp(heap.size() - 1);

    }

    private void percolateUp(Integer index) {

        if(index == 0) {
            return;
        }

        int parent = index / 2;

        if(heap.get(parent) > heap.get(index)) {
            int temp = heap.get(parent);
            heap.set(parent, heap.get(index));
            heap.set(index, temp);
            percolateUp(parent);
        }

        return;

    }

    private boolean isLeaf(Integer index) {

        if(heap.size() < (2*index + 1)) {
            return true;
        } else {
            return false;
        }
    }

    private void heapify(Integer index) {

        if(isLeaf(index)) {
            return;
        }

        int left = 2*index + 1;
        int right = 2*index + 2;
        int smallest = index;

        if(left < heap.size() && heap.get(left) < heap.get(smallest)) {
            smallest = left;
        }

        if (right < heap.size() && heap.get(right) < heap.get(smallest)) {
            smallest = right;
        }

        if(smallest != index) {
            int temp = heap.get(smallest);
            heap.set(smallest, heap.get(index));
            heap.set(index, temp);
            heapify(smallest);
        }

    }

    public Integer getValue() {
        if(heap.size() == 0) {
            return null;
        }

        int returnValue = heap.get(0);

        if(heap.size() > 1) {

            heap.set(0, heap.get(heap.size() - 1));
            heap.remove(heap.size() - 1);
            heapify(0);

        } else {
            heap.remove(0);
        }

        return returnValue;

    }

    public void printHeap() {

       for (int i = 0; i < heap.size(); i++) {
           System.out.print(heap.get(i));
       }
    }

    public static void main(String[] args) {

        MinHeap obj = new MinHeap();
        obj.addValue(4);
        obj.addValue(2);
        obj.addValue(3);
        obj.addValue(9);
        obj.addValue(7);
        obj.addValue(5);
        obj.addValue(6);
        obj.addValue(1);
        obj.addValue(0);
        obj.addValue(1);
        obj.printHeap();

        System.out.println();

        Integer val = obj.getValue();
        while (val != null ) {
            System.out.println(val);
            val = obj.getValue();
        }

    }

}
