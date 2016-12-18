/**
 * Created by Ashutosh on 12/17/16.
 */
public class IntegerToHexadecimal {
    public String toHex(int num) {

        if(num == 0) {
            return "0";
        }

        StringBuilder output = new StringBuilder();
        char[] hexDigits = {'a', 'b' ,'c', 'd', 'e', 'f'};

        while (num != 0) {

            int value = (num & 15);
            if(value > 9) {
                output.insert(0, hexDigits[value - 10]);
            } else {
                output.insert(0, value);
            }

            num = num >>> 4;

        }

        return output.toString();
    }

    public static void main(String[] args) {
        IntegerToHexadecimal obj = new IntegerToHexadecimal();
        System.out.println(obj.toHex(-1));
    }
}
