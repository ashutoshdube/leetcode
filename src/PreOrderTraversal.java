import java.util.*;

/**
 * Created by Ashutosh on 12/21/16.
 */
public class PreOrderTraversal {

    public static class TreeNode {

        TreeNode left, right;
        int val;
        TreeNode (int val) {
            this.val = val;
        }

    }

    public List<Integer> preorderTraversal(TreeNode root) {

        if(root == null) {
            return new ArrayList<>();
        }

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        List<Integer> output = new ArrayList<>();

        while(!stack.isEmpty()) {

            TreeNode node = stack.pop();
            output.add(node.val);

            if(node.right != null)
                stack.push(node.right);
            if(node.left != null)
                stack.push(node.left);

        }

        System.out.println(Arrays.toString(output.toArray()));
        return output;

    }

    public static void main(String[] args) {

        PreOrderTraversal obj = new PreOrderTraversal();
        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(4);
        node.right = new TreeNode(3);
        node.left.left = new TreeNode(2);
        obj.preorderTraversal(node);

    }

}
