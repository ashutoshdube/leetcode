import java.util.*;

/**
 * Created by Ashutosh on 12/31/16.
 */
public class BinaryTreeUpsideDown {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public void printUpsideDown(TreeNode root) {

        Stack<List<Integer>> stack = new Stack<>();
        Queue<TreeNode> track = new ArrayDeque<>();
        track.offer(root);
        int count = 1;
        int newCount = 0;
        List<Integer> valueArray = new ArrayList<>();

        while (track.size() != 0) {

            if(count == 0) {
                count = newCount;
                newCount = 0;
                stack.push(valueArray);
                valueArray = new ArrayList<>();
            }

            TreeNode node = track.poll();
            valueArray.add(node.val);
            count--;

            if(node.left != null) {
                track.offer(node.left);
                newCount++;
            }

            if(node.right != null) {
                track.offer(node.right);
                newCount++;
            }
        }

        stack.push(valueArray);

        while (!stack.isEmpty()) {
            System.out.println(Arrays.toString(stack.pop().toArray()));
        }

    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        //root.right.left = new TreeNode(6);
        //root.right.right = new TreeNode(7);

        BinaryTreeUpsideDown obj = new BinaryTreeUpsideDown();
        obj.printUpsideDown(root);
    }

}
