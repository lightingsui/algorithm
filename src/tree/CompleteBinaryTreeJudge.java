package tree;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 完全二叉树的判定
 *
 * @author ：隋亮亮
 * @since ：2020/7/8 22:26
 */
public class CompleteBinaryTreeJudge {
    public static void main(String[] args) {
        TreeNode root = TreeNode.init();
        boolean res = completeBinaryTreeJudge(root);

        System.out.println(res);
    }

    /**
     * 涉及到二叉树的层次遍历
     *
     * @param root 二叉树的根节点
     * @return {@code false} 非完全二叉树
     *         {@code true} 完全二叉树
     */
    public static boolean completeBinaryTreeJudge(TreeNode root) {
        // null 为一棵完全二叉树
        if (root == null) {
            return true;
        }

        Deque<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                TreeNode treeNode = queue.removeFirst();

                // 关键步骤：左子树为空，右子树不为 null，一棵非完全二叉树
                if (treeNode.left == null && treeNode.right != null) {
                    return false;
                }

                if(treeNode.left != null) {
                    queue.add(treeNode.left);
                }

                if(treeNode.right != null) {
                    queue.add(treeNode.right);
                }
            }
        }

        return true;
    }
}
