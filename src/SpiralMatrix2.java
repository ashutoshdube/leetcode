import java.util.Arrays;

/**
 * Created by Ashutosh on 12/20/16.
 */
public class SpiralMatrix2 {

    public int[][] generateMatrix(int n) {

        if(n == 0) {
            return new int[0][0];
        }

        int rowStart = 0;
        int rowEnd = n - 1;
        int columnStart = 0;
        int columnEnd = n - 1;
        int count = n*n;
        int[][] output = new int[n][n];
        int number = 1;

        while(count != 0) {


            int i = rowStart;
            int j;

            for(j = columnStart; j <= columnEnd; j++) {

                output[i][j] = number;
                number++;
                count--;

            }

            j = columnEnd;
            for(i = rowStart + 1; i <= rowEnd; i++) {

                output[i][j] = number;
                number++;
                count--;
            }

            i = rowEnd;
            for(j = columnEnd - 1; j >= columnStart; j--) {

                output[i][j] = number;
                number++;
                count--;

            }

            j = columnStart;
            for(i = rowEnd - 1; i > rowStart; i--) {

                output[i][j] = number;
                number++;
                count--;
            }

            rowStart++;
            rowEnd--;
            columnStart++;
            columnEnd--;

        }

        for(int[] list : output) {
            System.out.println(Arrays.toString(list));
        }

        return output;
    }

    public static void main(String[] args) {

        SpiralMatrix2 obj = new SpiralMatrix2();
        obj.generateMatrix(0);
    }
}
