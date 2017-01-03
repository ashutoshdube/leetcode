/**
 * Created by Ashutosh on 1/1/17.
 */
public class TwoSum2 {

    public int[] twoSum(int[] numbers, int target) {

        int start = 0;
        int end = numbers.length - 1;

        while (start < end) {

            int sum = numbers[start] + numbers[end ];
            if(sum == target) {
                return new int[]{start + 1, end + 1};
            } else if(sum < target) {
                start++;
            } else {
                end --;
            }
        }

        return new int[]{};
    }


    public static void main(String[] args) {

    }
}
