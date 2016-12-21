import java.lang.reflect.Array;
import java.util.*;

/**
 * Created by Ashutosh on 12/20/16.
 */
public class ThreeSum {

    HashSet<List<Integer>> set = new HashSet<>();

    public List<List<Integer>> threeSum(int[] nums) {

        int count = nums.length;

        Arrays.sort(nums);

        int first = 0;
        while(first < nums.length - 2){

            if(nums[first] > 0 ) {
                break;
            }

            int second = first + 1;
            int third = second + 1;
            while(second != nums.length - 1) {

                int sum = nums[first] + nums[second] + nums[third];
                if(sum == 0) {
                    List<Integer> entry = new ArrayList<>(Arrays.asList(nums[first], nums[second], nums[third]));
                    Collections.sort(entry);
                    set.add(entry);
                }

                while(second < nums.length - 1 && nums[second] == nums[second + 1]) {
                    second++;
                }

                while(third < nums.length - 1 && nums[third] == nums[third + 1]) {
                    third++;
                }

                third++;

                if(third == nums.length) {
                    second++;
                    third = second + 1;
                }
            }

            first++;

        }

        List<List<Integer>> output = new ArrayList<>();
        for(List<Integer> list : set ) {
            output.add(list);
        }

        for(List<Integer> list : output) {
            System.out.println(Arrays.toString(list.toArray()));
        }
        return output;

    }

    public static void main(String[] args) {

        ThreeSum obj = new ThreeSum();
        int[] test = {0, 0, 0};
        obj.threeSum(test);


    }

}
