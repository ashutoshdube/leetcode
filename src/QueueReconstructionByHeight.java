import javafx.util.Pair;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by Ashutosh on 12/30/16.
 */
public class QueueReconstructionByHeight {

    public class comparePairs implements Comparator<Pair<Integer, Integer>> {

        @Override
        public int compare(Pair<Integer, Integer> o1, Pair<Integer, Integer> o2) {

            return o1.getKey().compareTo(o2.getKey());

        }
    }

    public int[][] reconstructQueue(int[][] people) {

        List<Pair<Integer,Integer>> pairs = new ArrayList<>();

        for(int[] p : people) {
            pairs.add(new Pair<>(p[0], p[1]));
        }

        Collections.sort(pairs, new comparePairs());

        List<int[]> output = new ArrayList<>();
        for(int i = 0; i< pairs.size(); i++) {
            output.add(pairs.get(i).getValue(), new int[]{pairs.get(i).getKey(), pairs.get(i).getValue()});
        }

        int[][] returnOutput = new int[people.length][people[0].length];
        for(int i = 0; i < people.length; i++) {

            returnOutput[i][0] = output.get(i)[0];
            returnOutput[i][1] = output.get(i)[1];
        }

        return returnOutput;
    }

    public static void main(String[] args) {

    }

}
