package test.tree;

import tree.TreeNode;

/**
 * @author ：隋亮亮
 * @since ：2020/8/5 23:51
 */
public class FullBinaryTreeJudgeTest {
    public static void main(String[] args) {
        TreeNode root = TreeNode.init();

        boolean res = fullBinaryTreeJudge(root);
        System.out.println(res);
    }

    private static boolean fullBinaryTreeJudge(TreeNode root) {
        if(root == null) {
            return true;
        }

        if((root.left != null && root.right == null) || (root.left == null && root.right != null)) {
            return false;
        }

        return fullBinaryTreeJudge(root.left) && fullBinaryTreeJudge(root.right);
    }
}
