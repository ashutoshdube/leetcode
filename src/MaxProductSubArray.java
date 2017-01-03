/**
 * Created by Ashutosh on 1/1/17.
 */
public class MaxProductSubArray {

    public int maxProduct(int[] nums) {


        if(nums.length == 0 || nums.length == 0) {
            return 0;
        }

        int max = nums[0];
        int min = nums[0];
        int output = nums[0];

        for (int i = 1 ;i < nums.length; i++) {

            int temp = max;
            max = Math.max(Math.max(max * nums[i], min * nums[i]), nums[i]);
            min = Math.min(Math.min(temp * nums[i], min * nums[i]), nums[i]);

            if(max > output) {
                output = max;
            }
        }

        return output;


    }

    public static void main(String[] args) {

    }
}
