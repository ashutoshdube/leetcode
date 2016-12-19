import java.util.LinkedList;
import java.util.List;

/**
 * Created by Ashutosh on 12/18/16.
 */
public class GrayCode {

    public List<Integer> grayCode(int n) {

        List<Integer> values = new LinkedList<>();
        int max = (int)Math.pow(2, n);

        for(int i = 1; i < max; i++) {
            values.add(i);
        }

        for(int j = 0; values.size() != 1; ) {

            System.out.println(values.get(j));
            int tmp = values.get(0);
            values.remove(values.remove(values.get(j)));
            j = (j + 1) % values.size();
            while(true) {
                int val = tmp ^ values.get(j);
                if(val != 0 && val % 2 == 0) {
                    break;
                }
                j = (j + 1) % values.size();
            }
        }

        return null;
    }

    public static void main(String[] args) {

        GrayCode obj = new GrayCode();
        obj.grayCode(3);

    }
}
