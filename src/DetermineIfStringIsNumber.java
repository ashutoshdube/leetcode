/**
 * Created by Ashutosh on 1/1/17.
 */
public class DetermineIfStringIsNumber {

    public boolean checkIfStringIsNumber(String input) {

        int sign = 0, decimal = 0, numCount = 0;

        for(int i = 0; i < input.length(); i++) {

            if(input.charAt(i) == '-') {
                if(i != 0 )
                    return false;
            }

            else if(input.charAt(i) == '.') {
                if((i == 0 || i == input.length() - 1) || numCount == 0) {
                    return false;
                }
            }

            else if(input.charAt(i) < '0' || input.charAt(i) > '9') {
                return false;
            }

            else {
                numCount++;
            }

        }

        if(numCount < 1) {
            return false;
        }

        return true;
    }

    public static void main(String[] args) {

        DetermineIfStringIsNumber obj = new DetermineIfStringIsNumber();
        System.out.println(obj.checkIfStringIsNumber("-12.2121"));

    }
}
