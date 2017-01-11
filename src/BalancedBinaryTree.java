/**
 * Created by Ashutosh on 1/10/17.
 */
public class BalancedBinaryTree {

    public class TreeNode {
             int val;
             TreeNode left;
             TreeNode right;
             TreeNode(int x) { val = x; }
    }

    public boolean isBalanced(TreeNode root) {

        return check(root) == Integer.MIN_VALUE ? false : true;

    }

    public int check(TreeNode root) {

        if(root == null) {
            return 0;
        }

        int leftLength = check(root.left);
        int rightLength = check(root.right);

        if(leftLength == Integer.MIN_VALUE || rightLength == Integer.MIN_VALUE || Math.abs(leftLength - rightLength) > 1) {
            return Integer.MIN_VALUE;
        }

        return 1 + Math.max(leftLength, rightLength);

    }

    public static void main(String[] args) {

    }
}
