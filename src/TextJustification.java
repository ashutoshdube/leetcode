import com.sun.deploy.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ashutosh on 1/2/17.
 */
public class TextJustification {

    public List<String> fullJustify(String[] words, int maxWidth) {

        int start = 0;
        int end = 0;
        List<String> output = new ArrayList<>();
        StringBuilder temp = new StringBuilder();

        while (end < words.length) {

            int width = 0;
            int numWords = 0;
            while (end < words.length && width <= maxWidth) {

                width = width + words[end].length() + (numWords == 0 ? 0 : 1);
                if(width >= maxWidth) {
                    break;
                }
                end++;
                numWords++;
            }

            if(width > maxWidth) {

                width = width - words[end].length() - numWords;
                end--;
                numWords--;
                int evenSpaces = (maxWidth - width) / numWords;
                int oddSpaces = (maxWidth - width) % numWords;

                StringBuilder evenSpacesStr = new StringBuilder();
                for(int j = 1; j <= evenSpaces; j++) {
                    evenSpacesStr.append(new StringBuilder(" "));
                }

                for(int i = start; i <= end; i++) {

                    if( i != start) {
                        temp.append(evenSpacesStr);
                        if(oddSpaces != 0) {
                            temp.append(" ");
                            oddSpaces--;
                        }
                    }

                    temp.append(words[i]);

                }

                output.add(temp.toString());
                temp = new StringBuilder();
                end++;
                start = end;
            } else {

                for(int i = start; i < end; i++) {

                    if( i != start) {
                        temp.append(" ");
                    }

                    temp.append(words[i]);

                }

                output.add(temp.toString());
                break;
            }


        }

        return output;

    }

    public static void main(String[] args) {

        TextJustification obj = new TextJustification();
        String[] test = new String[]{"This", "is", "an", "example", "of", "text", "justification."};
        System.out.println(obj.fullJustify(test, 16));

    }
}
