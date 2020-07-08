package tree;

/**
 * 满二叉树的判定
 *
 * @author ：隋亮亮
 * @since ：2020/7/8 22:50
 */
public class FullBinaryTreeJudge {
    public static void main(String[] args) {
        TreeNode root = TreeNode.init();

        boolean res = fullBinaryTreeJudge(root);
        System.out.println(res);
    }

    public static boolean fullBinaryTreeJudge(TreeNode root) {
        if(root == null) {
            return true;
        }

        if((root.left == null && root.right != null) || (root.left != null && root.right == null)) {
            return false;
        }

        return fullBinaryTreeJudge(root.left) && fullBinaryTreeJudge(root.right);
    }
}
