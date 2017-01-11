import java.util.Arrays;

/**
 * Created by Ashutosh on 1/8/17.
 */
public class RotateImage {

    public void rotate(int[][] matrix) {

        //mirror image
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[0].length / 2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][matrix[0].length - j - 1];
                matrix[i][matrix[0].length - j - 1] = temp;
            }
        }

        for(int[] val : matrix) {
            System.out.println(Arrays.toString(val));
        }

        //diagonal image
        int columnLength = matrix[0].length - 1;
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < columnLength; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[matrix[0].length - 1 - j][matrix.length - 1 - i];
                matrix[matrix[0].length - 1 - j][matrix.length - 1 - i] = temp;
            }
            columnLength--;
        }

        for(int[] val : matrix) {
            System.out.println(Arrays.toString(val));
        }

    }

    public static void main(String[] args) {

        int[][] test = {{1 ,2, 3}, {4, 5, 6}, {7, 8, 9}};
        RotateImage obj = new RotateImage();
        obj.rotate(test);
    }
}
