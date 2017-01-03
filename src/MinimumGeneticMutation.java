import com.sun.tools.javac.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ashutosh on 12/31/16.
 */
public class MinimumGeneticMutation {

    public int minMutation(String start, String end, String[] bank) {

        String mutated = start;
        List<String> mutations = new ArrayList<>();
        List<String> checked = new ArrayList<>();

        while (!mutated.equals(end)) {
            int count = 0;
            for(String bankStr : bank) {
                if(bankStr.length() == start.length()) {
                    int i;
                    for(i = 0; i < start.length(); i++) {
                        if(count > 1) {
                            break;
                        }

                        if(mutated.charAt(i) != bankStr.charAt(i) && bankStr.charAt(i) == end.charAt(i)) {
                            count++;
                        }
                    }

                    if(i == start.length()) {
                        mutations.add(bankStr);
                        mutated = bankStr;
                    }
                }
            }
        }

    return -1;
    }


    public static void main(String[] args) {

    }
}
