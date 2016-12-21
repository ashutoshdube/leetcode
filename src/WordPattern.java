import java.util.HashMap;
import java.util.HashSet;

/**
 * Created by Ashutosh on 12/20/16.
 */
public class WordPattern {

    public boolean wordPattern(String pattern, String str) {

        HashMap<Character, String> map = new HashMap<>();
        HashSet<String> before = new HashSet<>();

        String[] words = str.split(" ");
        if(pattern.length() != words.length) {
            return false;
        }

        for(int i = 0; i < words.length; i++) {

            if(map.get(pattern.charAt(i)) == null) {
                if(before.contains(words[i])) {
                    return false;
                } else {
                    map.put(pattern.charAt(i), words[i]);
                    before.add(words[i]);
                }
            }

            if(!map.get(pattern.charAt(i)).equals(words[i])) {
                return false;
            }

        }

        return true;
    }

    public static void main(String[] args) {

        WordPattern obj = new WordPattern();
        System.out.println(obj.wordPattern("abba", "dog dog cat bat"));

    }

}
