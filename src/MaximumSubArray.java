/**
 * Created by Ashutosh on 1/2/17.
 */
public class MaximumSubArray {

    public int maxSubArray(int[] A) {

        int ans=A[0],i,j,sum=0;
        for(i=0;i<A.length;i++){
            sum+=A[i];
            ans=Math.max(sum,ans);
            sum=Math.max(sum,0);
        }
        return ans;
    }

    public static void main(String[] args) {

    }
}
