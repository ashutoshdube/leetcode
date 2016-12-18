import java.util.Arrays;
import java.util.List;

/**
 * Created by Ashutosh on 12/17/16.
 */
public class ReverseVowels {

    public String reverseVowels(String s) {

        StringBuilder outputStr = new StringBuilder(s);
        int start = 0;
        int end = outputStr.length() - 1;
        List<Character> vowels = Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U');

        while(start < end) {

            while(start < end && !vowels.contains(outputStr.charAt(start))){
                //outputStr.setCharAt(start, s.charAt(start++));
                start++;
            }

            if (start == outputStr.length()) {
                return outputStr.toString();
            }

            while( end > start && !vowels.contains(outputStr.charAt(end))){
                //outputStr.setCharAt(end, outputStr.charAt(end--));
                end--;
            }

            if(end == start) {
                return outputStr.toString();
            }

            char tmp = outputStr.charAt(start);
            outputStr.setCharAt(start++,outputStr.charAt(end));
            outputStr.setCharAt(end--,tmp);
        }


        return outputStr.toString();
    }

    public static void main(String[] args) {

        ReverseVowels obj = new ReverseVowels();
        System.out.println(obj.reverseVowels("hello"));

    }

}
