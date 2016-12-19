/**
 * Created by Ashutosh on 12/18/16.
 */
public class MaxPalindromeSubString {

    int startIndex = 0 , length = 0;

    public String longestPalindrome(String s) {

        if(s.length() < 2) {
            return s;
        }

        for(int i = 0; i < s.length() - 1; i++) {

            stretchSequence(s, i, i);
            stretchSequence(s, i, i + 1);

        }

        return s.substring(startIndex, startIndex + length);
    }

    private void stretchSequence(String s, int i, int j) {

        for(;i >= 0 && j< s.length() && s.charAt(i) == s.charAt(j); i--, j++ );

        int currLength = (j - 1) - (i  + 1) + 1;
        if(currLength > length) {
            length = currLength;
            startIndex = i + 1;
        }

    }

    public static void main(String[] args){

        MaxPalindromeSubString obj = new MaxPalindromeSubString();
        System.out.println(obj.longestPalindrome("cbbd"));

    }
}
