/**
 * Created by Ashutosh on 12/29/16.
 */
public class IsSubsequence {

    public boolean isSubsequence(String s, String t) {

        int i,j;
        for(i = 0, j = 0; i < s.length() && j < t.length(); j++) {

            if(s.charAt(i) == t.charAt(j)) {
                i++;
            }
        }

        if(i < s.length()){
            return false;
        } else {
            return true;
        }
    }

    public static void main(String[] args) {

        IsSubsequence obj = new IsSubsequence();
        System.out.println(obj.isSubsequence("axc","akjbfesc"));

    }

}
