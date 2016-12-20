import java.util.*;

/**
 * Created by Ashutosh on 12/19/16.
 */
public class Subsets2 {

    public List<List<Integer>> subsetsWithDup(int[] nums) {

        if(nums == null || nums.length == 0) {
            return new ArrayList<>(new ArrayList<>());
        }

        Arrays.sort(nums);

        Queue<List<Integer>> queue = new ArrayDeque<>();

        List<Integer> initList = new ArrayList<>();
        initList.add(nums[0]);
        queue.offer(initList);

        HashSet<List<Integer>> outputSet = new HashSet<>();
        outputSet.add(initList);

        for(int i = 1; i < nums.length; i++) {

            int count = queue.size();
            while (count != 0) {

                List<Integer> popped = queue.poll();
                queue.offer(popped);
                List<Integer> newList = new ArrayList<>(popped);
                newList.add(nums[i]);
                queue.offer(newList);
                outputSet.add(newList);
                count--;
            }

            List<Integer> singleElementSubset = new ArrayList<>();
            singleElementSubset.add(nums[i]);
            queue.offer(singleElementSubset);
            outputSet.add(singleElementSubset);

        }

        outputSet.add(new ArrayList<>());
        List<List<Integer>> outputList = new ArrayList<>(outputSet);


        return outputList;
    }

    public static void main(String[] args) {

        Subsets2 obj = new Subsets2();
        int[] test = {4, 4, 4, 1, 4};
        obj.subsetsWithDup(test);

    }

}
