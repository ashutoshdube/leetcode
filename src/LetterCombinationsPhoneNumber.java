import java.util.*;

/**
 * Created by Ashutosh on 12/19/16.
 */
public class LetterCombinationsPhoneNumber {

    public List<String> letterCombinations(String digits) {


        if(digits.length() == 0) {
            return new ArrayList<>();
        }

        Queue<String> output = new LinkedList<>();
        String[] values = {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

        output.offer("");

        for(int i = 0; i < digits.length(); i++) {

            int length = output.size();
            while(length != 0) {

                int digit = Character.getNumericValue(digits.charAt(i));
                for (char letter : values[digit].toCharArray()) {

                    output.offer(output.peek() + letter);

                }
                output.remove();
                length--;
            }
        }

        return new ArrayList<>(output);
    }

    public static void main(String[] args) {

        LetterCombinationsPhoneNumber obj = new LetterCombinationsPhoneNumber();
        System.out.println(Arrays.toString(obj.letterCombinations("4567334").toArray()));

    }
}
