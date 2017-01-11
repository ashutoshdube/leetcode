/**
 * Created by Ashutosh on 1/2/17.
 */
public class SqrtX {

    public int sqrt(int x) {

        long r = x;
        while (r*r > x) {
            r = (r + x/r)/2;
        }
        return (int) r;
    }


    public static void main(String[] args) {

        SqrtX obj = new SqrtX();
        System.out.println(obj.sqrt(64));

    }
}
