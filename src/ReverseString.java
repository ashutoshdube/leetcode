import java.util.Arrays;

/**
 * Created by Ashutosh on 12/16/16.
 */
public class ReverseString {

    public String reverseWords(String s) {

        int i = 0;

        s = s.trim();
        char[] characters = s.toCharArray();

        int j = characters.length - 1;


        while(i < j) {
            char tmp = characters[i];
            characters[i] = characters[j];
            characters[j] = tmp;
            i++;
            j--;
        }


        characters = new String(characters).replaceAll(" +"," ").toCharArray();

        int k = 0;
        i = 0;
        while (true) {
            while (k < characters.length && characters[k] != ' ') {
                k++;
            }

            j = k - 1;

            while (i < j) {
                char tmp = characters[i];
                characters[i] = characters[j];
                characters[j] = tmp;
                i++;
                j--;
            }

            if (k == characters.length) {
                break;
            }

            k++;
            i = k;

        }

        return new String(characters);
    }

    public static void main(String[] args) {

        ReverseString obj = new ReverseString();
        System.out.println(String.valueOf(obj.reverseWords("  abc   h yt  ")));

    }
}
