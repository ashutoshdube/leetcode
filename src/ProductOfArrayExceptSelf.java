import java.util.Arrays;

/**
 * Created by Ashutosh on 12/19/16.
 */
public class ProductOfArrayExceptSelf {

    public int[] productExceptSelf(int[] nums) {

        if(nums == null || nums.length == 0) {
            return new int[]{};
        }

        int[] output = new int[nums.length];
        output[0] = nums[0];

        for(int i = 1; i < nums.length; i++) {
            output[i] = nums[i] * output[i-1];
        }

        output[nums.length - 1] = output[nums.length - 2];
        int product = nums[nums.length - 1];
        for(int j = nums.length - 2; j > 0; j--) {

            output[j] = output[j-1] * product;
            product = product * nums[j];

        }
        output[0] = product;
        System.out.println(Arrays.toString(output));
        return output;
    }

    public static void main(String[] args) {

        ProductOfArrayExceptSelf obj = new ProductOfArrayExceptSelf();
        int[] test = {3, 4};
        obj.productExceptSelf(test);

    }

}
