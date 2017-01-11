/**
 * Created by Ashutosh on 1/4/17.
 */
public class ValidateBinarySearchTree {

    public class TreeNode {
             int val;
             TreeNode left;
             TreeNode right;
             TreeNode(int x) { val = x; }
    }

    public boolean isValidBST(TreeNode root) {

        return checkValidity(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean checkValidity(TreeNode root, long minVal, long maxVal) {

        if(root == null) {
            return true;
        }

        if (root.val >= maxVal || root.val <= minVal) return false;
        return checkValidity(root.left, minVal, root.val) && checkValidity(root.right, root.val, maxVal);

    }

    public static void main(String[] args) {

    }

}
