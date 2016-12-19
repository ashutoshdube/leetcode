/**
 * Created by Ashutosh on 12/18/16.
 */
public class CircularArrayLoop {
    public boolean circularArrayLoop(int[] nums) {

        if(nums == null || nums.length ==0){
            return false;
        }

        int i = 0, j = 0;

        int count = 0;
        while (true) {

            i = (i + (nums[i] + nums.length) % nums.length) % nums.length;
            j = (j + (nums[j] + nums.length) % nums.length) % nums.length;
            j = (j + (nums[j] + nums.length) % nums.length) % nums.length;
            count++;

            System.out.println(i);
            System.out.println(j);

            if(count > nums.length) {
                return false;
            }

            if(i == j && (i + (nums[i] + nums.length) % nums.length) % nums.length != j) {
                return true;
            }

        }

    }

    public static void main(String[] args) {
        CircularArrayLoop obj = new CircularArrayLoop();
        int[] test = {-2, 1, -1, -2, -2};
        System.out.println(obj.circularArrayLoop(test));

    }
}
