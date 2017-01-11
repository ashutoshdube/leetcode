import org.omg.PortableInterceptor.INACTIVE;

import java.lang.reflect.Array;
import java.util.*;

/**
 * Created by Ashutosh on 1/8/17.
 */
public class Subsets {

    public List<List<Integer>> subsets(int[] nums) {

        Deque<Set<Integer>> queue = new LinkedList<>();
        Set<Set<Integer>> outputSet = new HashSet<>();
        List<List<Integer>> output = new ArrayList<>();

        for(int i = 0 ; i < nums.length; i++) {

            if(queue.isEmpty()) {
                for(int num : nums) {
                    Set<Integer> tmpSet = new HashSet<>();
                    tmpSet.add(num);
                    queue.offer(tmpSet);
                }
            } else {

                for(int j = 0; j < nums.length; j++) {

                    Set<Integer> temp = queue.poll();
                    outputSet.add(temp);
                    for(int num : nums) {
                        Set<Integer> toQueue = (Set)((HashSet) temp).clone();
                        if(toQueue.size() == temp.size()) continue;
                        toQueue.add(num);
                        queue.add(toQueue);
                    }
                }

            }

        }

        while (!queue.isEmpty()) {
            outputSet.add(queue.poll());
        }


        for(Set<Integer> val : outputSet) {
            output.add(new ArrayList<>(val));
        }

        List<Integer> finalList = new ArrayList<>();
        for(int num : nums) {
            finalList.add(num);
        }

        //output.add(finalList);
        output.add(new ArrayList<>());

        for(List<Integer> op : output) {
            System.out.println(Arrays.toString(op.toArray()));
        }

        return output;
    }

    public static void main(String[] args) {

        Subsets obj = new Subsets();
        obj.subsets(new int[] {1,2,3});

    }
}
