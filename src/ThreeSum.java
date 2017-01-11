import java.lang.reflect.Array;
import java.util.*;

/**
 * Created by Ashutosh on 12/20/16.
 */
public class ThreeSum {

    HashSet<List<Integer>> set = new HashSet<>();

    public List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> output = new ArrayList<>();

        Arrays.sort(nums);

        for(int i = 0; i < nums.length - 2; i++ ) {
            if(i > 0 && nums[i] == nums[i-1]) continue;
            for(int j = i + 1, k = nums.length - 1; j < k;){

                int sum = nums[j] + nums[k];
                if(sum == -nums[i]) {
                    List<Integer> values = new ArrayList<>();
                    values.add(nums[i]);
                    values.add(nums[j]);
                    values.add(nums[k]);
                    //Collections.sort(values);
                    output.add(values);


                    while (j < k && nums[j] == nums[j + 1]) j++;
                    while (j < k && nums[k] == nums[k - 1]) k--;

                    j++;
                    k--;
                } else if(sum > -nums[i]) {
                    k--;
                } else {
                    j++;
                }
            }
        }

        return output;
    }

    public static void main(String[] args) {

        ThreeSum obj = new ThreeSum();
        int[] test = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> values = obj.threeSum(test);

        for(List<Integer> o : values) {
            System.out.println(Arrays.toString(o.toArray()));
        }

    }

}
