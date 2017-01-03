/**
 * Created by Ashutosh on 12/28/16.
 */
public class UniquePaths {


    public int uniquePaths(int m, int n) {

        int[][] a = new int[m][n];

        for(int i = 0; i < m; i++) {
            a[i][0] = 1;
        }

        for(int j = 0; j < n; j++) {
            a[0][j] = 1;
        }

        for(int i = 1; i < m; i++) {
            for(int j = 1; j < n; j++) {
                a[i][j] = a[i-1][j] + a[i][j-1];
            }
        }
        return a[m-1][n-1];
    }


    public static void main(String[] args) {

        UniquePaths obj = new UniquePaths();
        System.out.println(obj.uniquePaths(23, 12));

    }

}
