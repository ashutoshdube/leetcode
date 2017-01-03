/**
 * Created by Ashutosh on 1/2/17.
 */
public class PowAB {

    public double pow(double a, double b) {

        if(b == 0) {
            return 1;
        }

        if(b < 0) {
            a = 1/a;
            b = -b;
        }

        double x = pow(a , b - 1);

        return a*x;
    }



    public static void main(String[] args) {

        PowAB obj = new PowAB();
        System.out.println(obj.pow(1.00001,123456));

    }
}
