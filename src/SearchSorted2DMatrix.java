/**
 * Created by Ashutosh on 1/5/17.
 */

//leetcode : 74

public class SearchSorted2DMatrix {

    public boolean searchMatrix(int[][] matrix, int target) {

        int rows = matrix.length;
        int columns = matrix[0].length;

        int low = 0;
        int high = (rows*columns) - 1;
        int mid = low + (high - low) / 2;

        while(low <= high) {

            if(matrix[mid/columns][mid%columns] == target) {
                return true;
            } else if (matrix[mid/columns][mid%columns] < target) {

                low = mid + 1;

            } else {
                high =  mid - 1;
            }

            mid = low + (high - low) / 2;
        }

        return false;
    }

    public static void main(String[] args) {

    }
}
