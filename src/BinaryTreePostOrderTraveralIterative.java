import java.util.*;

/**
 * Created by Ashutosh on 12/18/16.
 */
//leetcode : 145

public class BinaryTreePostOrderTraveralIterative {

    public static class TreeNode {

        TreeNode left, right;
        int val;
        TreeNode (int val) {
            this.val = val;
        }

    }

    public List<Integer> postorderTraversal(TreeNode root) {

        List<Integer> output = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (stack.size() != 0) {

            TreeNode node = stack.pop();
            output.add(0, node.val);
            if(node.left != null) stack.push(node.left);
            if(node.right != null) stack.push(node.right);
        }

        System.out.println(Arrays.toString(output.toArray()));
        return output;
    }

    public static void main(String[] args) {

        TreeNode node = new TreeNode(2);
        node.right = new TreeNode(20);
        node.right.left = new TreeNode(46);
        BinaryTreePostOrderTraveralIterative obj = new BinaryTreePostOrderTraveralIterative();
        obj.postorderTraversal(node);

    }
}
