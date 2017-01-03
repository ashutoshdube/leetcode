import java.util.Arrays;
import java.util.HashMap;

/**
 * Created by Ashutosh on 1/2/17.
 */
public class MinimumWindowSubstring {

    public String minWindow(String s, String t) {

        HashMap<Character, Integer> required = new HashMap<>();
        for(int i = 0; i < t.length(); i++) {
            required.put(t.charAt(i), required.getOrDefault(t.charAt(i), 0) + 1);
        }

        int min = Integer.MAX_VALUE;
        String minWindow = null;

        int start = 0;
        int end = 0;
        int total = 0;
        HashMap<Character, Integer> checked = new HashMap<>();

        while (end < s.length()){

            char ch = s.charAt(end);
            if(required.get(ch) != null) {
                checked.put(ch, checked.getOrDefault(ch, 0) + 1);
                if(checked.get(ch) <= required.get(ch)) {
                    total += 1;
                }
            }

            if(total == t.length()) {
                char startCh = s.charAt(start);

                while (required.get(startCh) == null || checked.get(startCh) > required.get(startCh)) {
                    if(required.get(startCh) != null && checked.get(startCh) > required.get(startCh)) {
                        checked.put(startCh, checked.get(startCh) - 1);
                    }
                    start++;
                    startCh = s.charAt(start);
                }

                int length = end - start + 1;
                String sub = s.substring(start, end + 1);

                if(length < min) {
                    min = length;
                    minWindow = sub;
                }
            }

            end++;
        }



        return minWindow != null ? minWindow : "";
    }

    public static void main(String[] args) {

        MinimumWindowSubstring obj = new MinimumWindowSubstring();
        System.out.println(obj.minWindow("ADOBECODEBANC","ABC"));

    }
}
