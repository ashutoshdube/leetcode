import java.util.HashMap;

/**
 * Created by Ashutosh on 12/29/16.
 */
public class IsomorphicStrings {


    public boolean isIsomorphic(String s, String t) {

        HashMap<Character, Character> map = new HashMap<>();
        char[] sc = s.toCharArray();
        char[] tc = t.toCharArray();

        for(int i = 0 ; i < s.length(); i++) {

            if((map.containsKey(sc[i]) && !map.get(sc[i]).equals(tc[i])) ||
                    (!map.containsKey(sc[i]) && map.values().contains(tc[i]))) {
                return false;
            }

            map.put(sc[i], tc[i]);
        }

        return true;


    }

    public static void main(String[] args) {

        IsomorphicStrings obj = new IsomorphicStrings();
        System.out.println(obj.isIsomorphic("ab","aa"));

    }
}
