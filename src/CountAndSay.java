/**
 * Created by Ashutosh on 12/18/16.
 */
//leetcode : 38

public class CountAndSay {
    public String countAndSay(int n) {

        if(n <= 0) {
            return null;
        }

        return generateSequence(n-1, new StringBuilder("1"));

    }

    public String generateSequence(int n, StringBuilder sequence) {

        if(n == 0){
            return sequence.toString();
        }

        int prev = -1;
        int count = 0;
        StringBuilder returnString = new StringBuilder();

        for (int i = sequence.length() - 1; i >= 0; i--) {

            if(prev == -1) {
                prev = Character.getNumericValue(sequence.charAt(i));
                count += 1;
                continue;
            }

            if(Character.getNumericValue(sequence.charAt(i)) == prev) {
                count ++;
            } else {
                returnString.insert(0, prev);
                returnString.insert(0, count);
                prev = Character.getNumericValue(sequence.charAt(i));
                count = 1;
            }

        }

        returnString.insert(0, prev);
        returnString.insert(0, count);

        return generateSequence(n-1, returnString).toString();

    }

    public static void main(String[] args) {

        CountAndSay obj = new CountAndSay();
        System.out.println(obj.countAndSay(5));

    }
}
