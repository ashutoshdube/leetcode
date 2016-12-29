import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Ashutosh on 12/23/16.
 */
public class PathSum2 {

    List<List<Integer>> lists = new ArrayList<>();

    public static class TreeNode {
              int val;
              TreeNode left;
              TreeNode right;
              TreeNode(int x) { val = x; }
    }

    public List<List<Integer>> pathSum(TreeNode root, int sum) {

        if(root == null) {
            return lists;
        }

        getLists(root, new ArrayList<>(), sum);

        for(List<Integer> list : lists) {
            System.out.println(Arrays.toString(list.toArray()));
        }
        return lists;
    }

    public void getLists(TreeNode node, List<Integer> list, int sum) {

        if(node == null && sum != 0) {
            return;
        }

        list.add(node.val);
        sum -= node.val;

        if(sum == 0 && node.left == null && node.right == null) {
            lists.add(list);
            return;
        }

        List<Integer> list1 = new ArrayList<>(list);
        List<Integer> list2 = new ArrayList<>(list);


        if(node.left != null)
            getLists(node.left, list1, sum);

        if(node.right != null)
            getLists(node.right, list2, sum);
    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(11);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);
        root.right.right.left = new TreeNode(5);
        root.right.right.right = new TreeNode(1);

        PathSum2 obj = new PathSum2();
        obj.pathSum(root, 22);

    }

}
