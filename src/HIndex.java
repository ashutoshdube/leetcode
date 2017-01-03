import com.sun.tools.javac.util.ArrayUtils;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by Ashutosh on 12/29/16.
 */
public class HIndex {

    public int hIndex(int[] citations) {

        if(citations == null || citations.length == 0) {
            return 0;
        }

        int[] indices = new int[citations.length];
        Arrays.sort(citations);
        for(int i = citations.length - 1; i >= 0 ; i--) {

            if(citations[i] >= ((citations.length - 1) - i) + 1) {
                indices[i] = ((citations.length - 1) - i) + 1;
            } else {
                indices[i] = Integer.MIN_VALUE;
            }

        }

        System.out.println(Arrays.toString(citations));
        System.out.println(Arrays.toString(indices));
        Arrays.sort(indices);
        return indices[indices.length - 1] == Integer.MIN_VALUE ? 0 : indices[indices.length - 1];
    }

    public static void main(String[] args) {

        HIndex obj =  new HIndex();
        System.out.println(obj.hIndex(new int[]{4, 0, 6, 1, 5}));

    }

}
