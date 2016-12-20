/**
 * Created by Ashutosh on 12/19/16.
 */
public class OneThreeTwoPattern {
    public boolean find132pattern(int[] nums) {

        if(nums.length < 3) {
            return false;
        }

        int one = 0;
        int three, two;

        while(one < nums.length - 2) {

            while(one < nums.length - 2 && nums[one] > nums[one + 1]) {
                one++;
            }

            if(one == nums.length - 2) {
                return false;
            }

            three = one + 1;
            while(three < nums.length - 1&& nums[three] < nums[three + 1]) {
                three++;
            }

            if(three == nums.length - 1) {
                return false;
            }

            two = three + 1;

            while(two < nums.length) {

                if(nums[two] < nums[three] && nums[two] > nums[one]) {
                    return true;
                } else if(nums[two] > nums[three]) {
                    three = two;
                    two ++;
                } else {
                    two++;
                }

            }

            one++;
        }

        return false;

    }

    public static void main(String[] args) {

        OneThreeTwoPattern obj = new OneThreeTwoPattern();

        int[] nums = {1, 3, 6, -1};

        System.out.println(obj.find132pattern(nums));

    }
}
