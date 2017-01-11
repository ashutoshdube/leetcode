import java.util.*;

/**
 * Created by Ashutosh on 12/27/16.
 */
//leetcode : 199

public class BinaryTreeRightSideView {

    public static class TreeNode {
             int val;
             TreeNode left;
             TreeNode right;
             TreeNode(int x) { val = x; }
    }

    public List<Integer> rightSideView(TreeNode root) {

        List<List<Integer>> levels = new ArrayList<>();
        Queue<TreeNode> values = new ArrayDeque<>();
        values.add(root);
        int count = 1;
        int nextCount = 0;
        List<Integer> valueLevel = new ArrayList<>();

        while (values.size() != 0) {

            if(count == 0) {
                count = nextCount;
                nextCount = 0;
                levels.add(valueLevel);
                valueLevel = new ArrayList<>();
            }

            TreeNode node = values.poll();
            if(node != null) {
                valueLevel.add(node.val);
                if(node.left != null) {
                    values.add(node.left);
                    nextCount++;
                }

                if(node.right != null) {
                    values.add(node.right);
                    nextCount++;
                }
            }
            count--;
        }

        levels.add(valueLevel);

        List<Integer> output = new ArrayList<>();
        for (List<Integer> list : levels) {
            if(list.size() != 0)
                output.add(list.get(list.size() - 1));
        }

        System.out.println(Arrays.toString(output.toArray()));

        return output;
    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.right = new TreeNode(5);
        root.right = new TreeNode(3);
        root.right.right = new TreeNode(4);

        BinaryTreeRightSideView obj = new BinaryTreeRightSideView();
        obj.rightSideView(root);

    }

}
