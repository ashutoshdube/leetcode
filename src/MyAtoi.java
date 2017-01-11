/**
 * Created by Ashutosh on 1/2/17.
 */
public class MyAtoi {

    public int myAtoi(String str) {

        str = str.trim();
        long value = 0;
        long factor = 10;
        boolean hasNonZeroCharachter = false;
        boolean isNegative = false;
        long intMax = Integer.MAX_VALUE;

        for(int i = 0; i < str.length(); i++) {

            if(str.charAt(i) == '-') {
                if(i != 0) return 0;
                isNegative = true;
            } else if(str.charAt(i) == '+') {
                if(i != 0) return 0;
                isNegative = false;
            } else if(str.charAt(i) == '0') {
                if(!hasNonZeroCharachter) continue;
                else {
                    value *= 10;
                    if(isNegative && value >= (long)Integer.MIN_VALUE * -1){
                        return Integer.MIN_VALUE;
                    } else if(!isNegative && value >= Integer.MAX_VALUE) {
                        return Integer.MAX_VALUE;
                    }
                }
            } else if(str.charAt(i) >= '1' && str.charAt(i) <= '9') {
                hasNonZeroCharachter = true;
                value = value * factor + (str.charAt(i) - '0');
                //factor *= 10;

                if(isNegative && value >= (long)Integer.MIN_VALUE * -1){
                    return Integer.MIN_VALUE;
                } else if(!isNegative && value >= Integer.MAX_VALUE) {
                    return Integer.MAX_VALUE;
                }
            } else {
                break;
            }

        }

        return (int)value;

    }

    public static void main(String[] args) {

        MyAtoi obj = new MyAtoi();
        Long abc= new Long("11191657170");
        long test = abc;
        System.out.println(abc);
        System.out.println(obj.myAtoi("    +11191657170"));

    }

}
