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

        i = 0;
        int length = characters.length;
        while(i < length - 1) {
            if(characters[i] == ' ' && characters[i +1] == ' ') {
                int k = i;
                while ( characters[k + 1] == ' ') {
                    k++;
                }

                while( k < length ) {
                    characters[i++] = characters[k++];
                }

                length = length - (k - i);

            } else {
                i++;
            }
        }

        for(int l = length ; l < characters.length; l++ ) {
            characters[l] = '\0';
        }


        int k = 0;
        i = 0;
        while (true) {
            while (k < length && characters[k] != ' ') {
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

            if (k == length) {
                break;
            }

            i = j = k;
            while (k + 1 < length && characters[k + 1] == ' ') {
                k++;
            }

            while (j != k && k < length - 1) {
                characters[j++] = characters[k++];
            }

            length -= k - j;

            i++;
            j = k = i;

        }

        return String.valueOf(characters);
    }

    public static void main(String[] args) {

        ReverseString obj = new ReverseString();
        System.out.println(String.valueOf(obj.reverseWords("  abc   hyt  ")));

    }
}
