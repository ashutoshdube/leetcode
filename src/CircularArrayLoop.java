/**
 * Created by Ashutosh on 12/18/16.
 */
//leetcode : 457

public class CircularArrayLoop {
    public boolean circularArrayLoop(int[] nums) {

        if(nums == null || nums.length < 2){
            return false;
        }

        int slow = 0, fast = 0;

        int count = 0;
        for(int i = 0; i < nums.length; i++) {
            slow = fast = i;

            /*int temp1 = (slow + ((nums[slow] + nums.length) % nums.length)) % nums.length;
            if(nums[slow] * nums[temp1] < 0) {
                continue;
            }*/

            while (true) {

                slow = (slow + ((nums[slow] + nums.length) % nums.length)) % nums.length;
                fast = (fast + ((nums[fast] + nums.length) % nums.length)) % nums.length;
                fast = (fast + ((nums[fast] + nums.length) % nums.length)) % nums.length;

                if(nums[slow] * nums[fast] < 0) {
                    break;
                }

                if(slow == fast) {
                    int temp = (slow + ((nums[slow] + nums.length) % nums.length)) % nums.length;
                    if(temp == fast) {
                        break;
                    }
                    return true;
                }
            }
        }

        return false;

    }

    public static void main(String[] args) {
        CircularArrayLoop obj = new CircularArrayLoop();
        int[] test = {2, -1, 1, 2, 2};
        System.out.println(obj.circularArrayLoop(test));

    }
}
