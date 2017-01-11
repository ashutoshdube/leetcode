/**
 * Created by Ashutosh on 1/5/17.
 */

//leetcode : 3

public class LongestSubstringWithoutRepeatingCharacters {

    public int lengthOfLongestSubstring(String s) {

        if(s == null || s.length() == 0) {
            return 0;
        }

        int[] counts = new int[256];
        int start = 0;
        int end = 0;
        int maxLength = 0;
        int length;

        while (end < s.length()) {

            char ch = s.charAt(end);
            if (counts[ch - '\0'] > 0) {
                length = end - start;
                maxLength = length > maxLength ? length : maxLength;

                while (s.charAt(start) != ch) {
                    counts[s.charAt(start++)]--;
                }

                //counts[ch - '\0']--;
                start++;

            } else {
                counts[ch - '\0'] += 1;
            }
            end++;
        }

        length = end - start;
        maxLength = length > maxLength ? length : maxLength;

        return maxLength;
    }

    public static void main(String[] args) {

        LongestSubstringWithoutRepeatingCharacters obj = new LongestSubstringWithoutRepeatingCharacters();
        System.out.println(obj.lengthOfLongestSubstring("abcabcbb"));
    }

}
