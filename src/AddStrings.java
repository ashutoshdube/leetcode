/**
 * Created by Ashutosh on 12/16/16.
 */
public class AddStrings {


    public String addStrings(String num1, String num2) {

        int len1 = num1.length();
        int len2 = num2.length();
        int carry = 0;
        StringBuilder finalString = new StringBuilder();
        int i = 0, j= 0, sum = 0, digit = 0;

        for(i = len1 - 1, j = len2 - 1; i >= 0 && j >= 0; i--, j--) {

            sum = num1.charAt(i) - 48 + num2.charAt(j) - 48 + carry;
            digit = sum % 10;
            carry = sum / 10;
            finalString.insert(0, digit);
        }

        while (i >= 0) {
            sum = num1.charAt(i) - 48 + carry;
            digit = sum % 10;
            carry = sum / 10;
            finalString.insert(0, digit);
            i--;
        }

        while (j >= 0) {
            sum = num2.charAt(j) - 48 + carry;
            digit = sum % 10;
            carry = sum / 10;
            finalString.insert(0, digit);
            j--;
        }

        if (carry > 0) {
            finalString.insert(0, carry);
        }

        return finalString.toString();

    }

    public static void main(String[] args) {


        AddStrings obj = new AddStrings();
        String returnStr = obj.addStrings("9","99");
        System.out.println(returnStr);


    }

}
