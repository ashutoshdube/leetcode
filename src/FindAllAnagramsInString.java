import java.util.*;

/**
 * Created by Ashutosh on 12/30/16.
 */


public class FindAllAnagramsInString {

    public List<Integer> findAnagrams(String s, String p) {

        char[] pChar = p.toCharArray();
        Arrays.sort(pChar);
        HashSet<Character> set = new HashSet<>();
        List<Integer> indices = new ArrayList<>();

        for(char ch : pChar) {
            set.add(ch);
        }

        for(int i = 0 ; i < s.length() - p.length(); i++) {

            if(set.contains(s.charAt(i))) {
                char[] tmp = s.substring(i, i + p.length()).toCharArray();
                Arrays.sort(tmp);
                if(Arrays.equals(pChar, tmp)) {
                    indices.add(i);
                }
            }
        }

        return indices;
    }

    public static void main(String[] args) {

        FindAllAnagramsInString obj = new FindAllAnagramsInString();
        System.out.println(obj.findAnagrams("cbaebabacd", "abc"));

    }
}
