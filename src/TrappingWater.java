/**
 * Created by Ashutosh on 1/6/17.
 */
public class TrappingWater {

    public int trap(int[] height) {

        int i = 0;
        int j = height.length - 1;
        int leftMax = 0;
        int rightMax = 0;
        int sum = 0;

        while (i < j) {

            leftMax = Math.max(leftMax, height[i]);
            rightMax = Math.max(rightMax, height[j]);

            if(leftMax < rightMax) {

                sum += (leftMax - height[i]);
                i++;

            } else {

                sum += (rightMax - height[j]);
                j--;
            }

        }

        return sum;
    }

    public static void main(String[] args) {

    }

}
