import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ashutosh on 12/30/16.
 */
public class FindAllDuplicatesInArray {

    public List<Integer> findDuplicates(int[] nums) {

        List<Integer> output = new ArrayList<>();

        for(int i = 0; i < nums.length; i++) {

            int index = Math.abs(nums[i]) - 1;
            if(nums[index] < 0) {
                output.add(Math.abs(index) + 1);
            }
            nums[index] = -nums[index];
        }

        return output;
    }

    public static void main(String[] args) {

    }
}
