/**
 * Created by Ashutosh on 1/1/17.
 */
public class CountNumberOfOccurences {

    public int countOccurences(int[] nums, int n) {

        int low = 0;
        int high = nums.length - 1;
        int mid = low + (high - low) / 2;

        while(low < high) {

            if(nums[mid] == n){
                break;
            } else if(nums[mid] > n) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }

            mid = low + (high - low) / 2;

        }

        if(low > high) {
            return 0;
        }

        int count = 0;
        int i = mid;
        while(i >=0 && nums[i] == n) {
            count++;
            i--;
        }

        i = mid + 1;
        while(i < nums.length && nums[i] == n) {
            count++;
            i++;
        }

        return count;

    }

    public static void main(String[] args) {

        CountNumberOfOccurences obj = new CountNumberOfOccurences();
        System.out.println(obj.countOccurences(new int[]{1,2,3,4}, 3));

    }
}
