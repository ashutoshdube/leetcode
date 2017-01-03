import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * Created by Ashutosh on 12/30/16.
 */
public class UglyNumber2 {

    public int nthUglyNumber(int n) {

        int[] ugly = new int[n];
        ugly[0] = 1;

        int i2 = 0, i3 = 0, i5 = 0;
        int n2 = ugly[i2] * 2;
        int n3 = ugly[i3] * 3;
        int n5 = ugly[i5] * 5;

        for(int i = 1; i < n; i++) {

            ugly[i] = Math.min(n2, Math.min(n3,n5));

            if(ugly[i] == n2){
                n2 = ugly[++i2] * 2;
            }

            if(ugly[i] == n3){
                n3 = ugly[++i3] * 3;
            }

            if(ugly[i] == n5){
                n5 = ugly[++i5] * 5;
            }

        }

        System.out.println(Arrays.toString(ugly));
        return ugly[n-1];
    }

    public static void main(String[] args) {

        UglyNumber2 obj = new UglyNumber2();
        System.out.println(obj.nthUglyNumber(10));

    }
}
