/**
 * Created by Ashutosh on 12/16/16.
 */
public class SumOfTwoIntegers {

    public int getSum(int a, int b) {

        int sum = 0, carry = 0;

        while( b != 0) {

            sum  = a ^ b;
            carry = (a & b) << 1;
            b = carry;
            a = sum;

        }

        return sum;

    }

    public static void main(String[] args){

        SumOfTwoIntegers obj = new SumOfTwoIntegers();
        System.out.println(obj.getSum(-269,232));

    }

}
