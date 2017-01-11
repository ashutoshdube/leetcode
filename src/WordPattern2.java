import java.util.HashMap;

/**
 * Created by Ashutosh on 1/10/17.
 */

/* Given a pattern and a string str, find if str follows the same pattern.

Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty substring in str.

Examples:
pattern = "abab", str = "redblueredblue" should return true.
pattern = "aaaa", str = "asdasdasdasd" should return true.
pattern = "aabb", str = "xyzabcxzyabc" should return false.*/

//leetcode : 291

public class WordPattern2 {

    HashMap<Character, String> map = new HashMap<>();

    public boolean wordPatternMatch(String pattern, String str) {

        return isMatch(pattern, 0, str, 0);


    }

    public boolean isMatch(String pattern, int p, String str, int s) {

        if(p == pattern.length() && s == str.length()) {
            return true;
        }

        if(p == pattern.length() || s == str.length()) {
            return false;
        }

        if(map.containsKey(pattern.charAt(p))) {

            if(str.startsWith(map.get(pattern.charAt(p)), s)) {
                return isMatch(pattern, p + 1, str, s + map.get(pattern.charAt(p)).length());
            }

            return false;
        }

        for(int k = s; k < str.length(); k++ ) {

            map.put(pattern.charAt(p), str.substring(s, k+1));

            if(isMatch(pattern, p+1, str, k+1)) {
                return true;
            }

            map.remove(pattern.charAt(p));

        }

        return false;
    }

    public static void main(String[] args) {

        WordPattern2 obj = new WordPattern2();
        System.out.println(obj.wordPatternMatch("abcdefg", "ghijkl"));

    }
}
