import java.util.*;

/**
 * Created by Ashutosh on 12/20/16.
 */
public class ThirdMaxNumber {
    public int thirdMax(int[] nums) {

        List<Integer> order = new LinkedList<>();

        for(int num : nums) {

            if(order.size() == 0) {
                order.add(num);
                continue;
            }

            if(order.get(0) < num) {
                order.add(0, num);
                continue;
            }

            if(order.get(0) > num) {
                if(order.size() < 2) {
                    order.add(num);
                    continue;
                }

                if(order.get(1) < num) {
                    order.add(1, num);
                    continue;
                }

                if(order.get(1) > num) {

                    if(order.size() < 3) {
                        order.add(num);
                        continue;
                    }

                    if(order.get(2) < num) {
                        order.add(2, num);
                        continue;
                    }

                }


            }

        }

        if(order.size() < 3) {
            return order.get(0);
        } else {
            return order.get(2);
        }
    }

    public static void main(String[] args) {

        ThirdMaxNumber obj = new ThirdMaxNumber();
        int[] test = {1, 2 , 2};
        System.out.println(obj.thirdMax(test));

    }
}
