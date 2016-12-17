import com.sun.deploy.util.ArrayUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * Created by Ashutosh on 12/16/16.
 */
public class LexicographicalNumbers {
    public List<Integer> lexicalOrder(int n) {

        List<Integer> output = new ArrayList<>();

        int mult = 1;
        int factor = 1;
        int count = n - 1;

        int number = 0;

        while (count >= 0) {

            while (factor < n && count >= 0) {
                output.add(mult * factor);
                count--;
                factor = factor * 10;
            }

            factor = factor / 10;
            while (factor > 1) {
                number = (mult * factor) + 1;
                while (number < (mult * factor) + 10 && number < n && count >= 0) {
                    output.add(number);
                    number++;
                }
                factor = factor/10;
            }

            mult += 1;
            factor = 1;

        }

        return output;
    }

    public static void main(String[] args) {

        LexicographicalNumbers obj = new LexicographicalNumbers();
        System.out.println(Arrays.toString(obj.lexicalOrder(234).toArray()));


    }

}
