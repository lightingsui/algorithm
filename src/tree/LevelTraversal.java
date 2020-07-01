package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 二叉树的层次遍历
 *
 * @author ：隋亮亮
 * @since ：2020/7/1 22:54
 */
public class LevelTraversal {
    public static void main(String[] args) {
        TreeNode root = TreeNode.init();

        List<Integer> res = levelTraversal(root);

        System.out.println(res);
    }

    private static List<Integer> levelTraversal(TreeNode root) {
        if(root == null) {
            return null;
        }

        LinkedList<TreeNode> queue = new LinkedList<>();
        List<Integer> res = new ArrayList<>();

        queue.add(root);

        while(!queue.isEmpty()) {
            TreeNode node = queue.removeFirst();

            res.add(node.val);

            if(node.left != null) {
                queue.add(node.left);
            }

            if(node.right != null) {
                queue.add(node.right);
            }
        }

        return res;
    }
}
