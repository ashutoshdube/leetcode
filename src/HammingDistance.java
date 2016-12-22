import java.util.HashMap;

/**
 * Created by Ashutosh on 12/21/16.
 */
public class HammingDistance {

    public int hammingDistance(int x, int y) {

        int bits = x^y;
        int count = 0;

        for(int i = 0; i < 32; i++){

            int num = (bits >> i) & 1;
            if(num == 1){
                count++;
            }

        }

        return count;
    }

    public static void main(String[] args) {

        HammingDistance obj = new HammingDistance();
        System.out.println(obj.hammingDistance(1, 4));

    }

}
