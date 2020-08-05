package test.tree;

import tree.TreeNode;

import java.util.LinkedList;

/**
 * @author ：隋亮亮
 * @since ：2020/8/5 23:47
 */
public class CompleteBinaryTreeJudgeTest {
    public static void main(String[] args) {
        TreeNode root = TreeNode.init();
        boolean res = completeBinaryTreeJudge(root);

        System.out.println(res);
    }

    private static boolean completeBinaryTreeJudge(TreeNode root) {
        if(root == null) {
            return true;
        }

        LinkedList<TreeNode> treeNodes = new LinkedList<>();

        treeNodes.add(root);

        while(!treeNodes.isEmpty()) {
            TreeNode treeNode = treeNodes.removeFirst();

            if(treeNode.left == null && treeNode.right != null) {
                return false;
            }

            if(treeNode.left != null) {
                treeNodes.add(treeNode.left);
            }

            if(treeNode.right != null) {
                treeNodes.add(treeNode.right);
            }
        }

        return true;
    }
}
