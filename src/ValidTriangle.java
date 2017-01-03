import java.util.Arrays;

/**
 * Created by Ashutosh on 1/1/17.
 */
public class ValidTriangle {

    public int[] getValidTriangle(int[] input){

        Arrays.sort(input);
        int[] output = new int[3];

        for (int i = 0, j = i + 1; j < input.length - 2;) {

            if(input[i] + input[j] > input[j+1]) {
                output[0] = input[i];
                output[1] = input[j];
                output[2] = input[j+1];
                return output;
            }

            i++;
            j++;

        }

        return output;

    }

    public static void main(String[] args) {

        ValidTriangle obj = new ValidTriangle();
        int[] test = {10, 5, 3, 7, 4, 1};
        System.out.println(Arrays.toString(obj.getValidTriangle(test)));

    }
}
