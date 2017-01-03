/**
 * Created by Ashutosh on 12/29/16.
 */
public class IncreasingTripletSequence {

    public boolean increasingTriplet(int[] nums) {

        int firstMin = Integer.MAX_VALUE, secondMin = Integer.MAX_VALUE;
        for(int num : nums) {

            if(num <= firstMin) firstMin = num;
            else if(num < secondMin) secondMin = num;
            else if(num > secondMin) return true;

        }

        return false;

    }

    public static void main(String[] args) {

        IncreasingTripletSequence obj = new IncreasingTripletSequence();
        System.out.println(obj.increasingTriplet(new int[]{2,4,-2,-3}));


    }

}
