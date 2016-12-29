import java.util.Arrays;

/**
 * Created by Ashutosh on 12/23/16.
 */
public class ValidAnagram {

    public boolean isAnagram(String s, String t) {

        char[] sc = s.toCharArray();
        char[] tc = t.toCharArray();

        Arrays.sort(sc);
        Arrays.sort(tc);

        if(Arrays.equals(sc, tc)) {
            return true;
        } else {
            return false;
        }

    }

    public static void main(String[] args) {

        ValidAnagram obj = new ValidAnagram();
        obj.isAnagram("", "");
    }


}
