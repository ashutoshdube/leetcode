import java.util.Arrays;

/**
 * Created by Ashutosh on 12/23/16.
 */
public class SortColors {

    public void sortColors(int[] nums) {

        int[] count = new int[3];

        for(int i = 0; i < nums.length; i++) {
            count[nums[i]]++;
        }

        int j = 0;
        for(int i = 0; i < nums.length;) {
            while(count[j] != 0) {
                nums[i++] = j;
                count[j]--;
            }
            j++;
        }
    }

    public static void main(String[] args) {

        SortColors obj = new SortColors();
        int[] test = new int[]{};
        obj.sortColors(test);
        System.out.println(Arrays.toString(test));

    }

}
