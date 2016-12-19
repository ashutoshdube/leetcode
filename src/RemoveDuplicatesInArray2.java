import java.util.Arrays;

/**
 * Created by Ashutosh on 12/18/16.
 */
public class RemoveDuplicatesInArray2 {

    public int removeDuplicates(int[] nums) {

        int i, j;

        int prevNum = Integer.MAX_VALUE;
        int prevCount = Integer.MAX_VALUE;

        for(i = 0, j = 0; j < nums.length;) {

            if(i == 0 && j == 0) {
                prevNum = nums[i];
                prevCount = 1;
                i++;
                j++;
                continue;
            }

            if(nums[j] == prevNum && prevCount == 2) {
                while(j < nums.length && nums[j] == prevNum) {
                    j++;
                }

                if(j < nums.length) {
                    prevNum = nums[j];
                    prevCount = 1;
                    nums[i] = nums[j];
                    i++;
                    j++;
                    continue;
                } else {
                    System.out.println(Arrays.toString(nums));
                    System.out.println(i);
                    return i;
                }
            }

            if(nums[j] == prevNum) {
                nums[i] = nums[j];
                prevCount++;
                i++;
                j++;
                continue;
            }

            prevNum = nums[j];
            nums[i] = nums[j];
            i++;
            j++;
            prevCount = 1;
        }

        System.out.println(Arrays.toString(nums));
        System.out.println(i);
        return i;
    }

    public static void main(String[] args) {

        RemoveDuplicatesInArray2 obj = new RemoveDuplicatesInArray2();
        int[] test = { 1,1,1};
        obj.removeDuplicates(test);

    }

}

