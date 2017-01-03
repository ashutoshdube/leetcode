/**
 * Created by Ashutosh on 12/29/16.
 */
public class MinimumSizeSubArraySum {

    public int minSubArrayLen(int s, int[] nums) {

        if(nums.length == 0 || nums == null) {
            return 0;
        }

        int i =0, j =0, sum = 0, minDist = Integer.MAX_VALUE;


        while(j < nums.length) {

            sum += nums[j++];

            while (sum >= s) {

                minDist = Math.min(minDist, j - i);
                sum -= nums[i++];

            }
        }

        return minDist == Integer.MAX_VALUE ? 0 : minDist;
    }

    public static void main(String[] args) {


    }

}
