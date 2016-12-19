/**
 * Created by Ashutosh on 12/19/16.
 */
public class RepeatedSubstringPattern {

    public boolean repeatedSubstringPatternOld(String str) {

        if(str == null || str.length() == 1) {
            return false;
        }

        int i = 0, j = 0, k = 1;
        boolean flag = true;
        int length = str.length();

        while(k < length) {

            while(i<=j && k < length && str.charAt(i) == str.charAt(k)) {

                i = (i + 1) % (j + 1);
                k++;

            }

            if(k == length && i == 0) {
                return true;
            }

            if(k == length && i != 0) {
                return false;
            }

            if(str.charAt(i) != str.charAt(k)) {
                i = 0;
                j++;
                k = j + 1;
                flag = false;
            }

        }

        return flag;
    }

    public boolean repeatedSubstringPattern(String str) {

        int length = str.length();
        int divisor = 1;
        int mult = -1;

        while(divisor != length) {

            if(length % divisor == 0) {
                mult = length / divisor;
                StringBuilder substr = new StringBuilder(str.substring(0, divisor));
                StringBuilder newStr = new StringBuilder();
                while (mult != 0) {
                    newStr.append(substr);
                    mult--;
                }

                if(newStr.toString().equals(str)) {
                    return true;
                }
            }

            divisor++;
        }

        return false;
    }

    public static void main (String [] args) {

        RepeatedSubstringPattern obj = new RepeatedSubstringPattern();
        System.out.println(obj.repeatedSubstringPattern("abacababacab"));


    }

}
