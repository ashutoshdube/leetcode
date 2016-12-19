import java.util.*;

/**
 * Created by Ashutosh on 12/18/16.
 */
public class ZigzagTraversal {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        if(root == null) {
            return new ArrayList<>();
        }


        int direction = 1;
        int length = 1;
        List<List<Integer>> output = new LinkedList<>();
        Queue<TreeNode> nodes = new ArrayDeque<>();
        nodes.offer(root);


        while(nodes.size() != 0) {

            List<Integer> levelList = new LinkedList<>();

            for(int i = 0 ; i < length; i++) {
                TreeNode node = nodes.poll();
                if(direction == 1)
                    levelList.add(node.val);
                else
                    levelList.add(0, node.val);


                if(node.left != null)
                    nodes.offer(node.left);
                if(node.right != null)
                    nodes.offer(node.right);
            }

            output.add(levelList);
            length = nodes.size();
            direction *= -1;
        }

        for(List<Integer> valueList : output) {
            System.out.println(Arrays.toString(valueList.toArray()));

        }
        return null;

    }

    public static void main(String[] args) {

        TreeNode node = null;
        /*TreeNode node = new TreeNode(2);
        node.left = new TreeNode(9);
        node.right = new TreeNode(20);
        node.left.left = new TreeNode(34);
        node.left.right = new TreeNode(56);
        node.right.left = new TreeNode(46);
        node.right.right = new TreeNode(61);*/
        ZigzagTraversal obj = new ZigzagTraversal();
        System.out.println(obj.zigzagLevelOrder(node));


    }
}
