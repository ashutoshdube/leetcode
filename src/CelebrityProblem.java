import java.util.Stack;

/**
 * Created by Ashutosh on 1/4/17.
 */

/** Question : In a party of N people, only one person is known to everyone.
    Such a person may be present in the party, if yes, (s)he doesn’t know anyone in the party.
    We can only ask questions like “does A know B? “. Find the stranger (celebrity) in minimum number of questions.
**/
//leetcode : 277

public class CelebrityProblem {

    public boolean haveAquaintance(int a, int b) {
        return true;
    }

    public int getCelebrity(int[] nums) {

        if(nums == null || nums.length < 2) {
            return -1;
        }

        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i < nums.length; i++) {
            stack.push(i);
        }

        while (stack.size() > 1) {

            int p1 = stack.pop();
            int p2 = stack.pop();

            if(!haveAquaintance(p1, p2) && haveAquaintance(p2, p1)) {
                stack.push(p1);
            } else if (!haveAquaintance(p2, p1) && haveAquaintance(p1, p2)) {
                stack.push(p2);
            }

        }

        if(stack.size() == 0) {
            return -1;
        }

        for(int j = 0; j < nums.length; j++) {
            if(haveAquaintance(stack.peek(), nums[j]) || !haveAquaintance(nums[j], stack.peek())) {
                return -1;
            }
        }

        return stack.pop();
    }

}
