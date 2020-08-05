package test.tree;

import tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author ：隋亮亮
 * @since ：2020/8/5 23:39
 */
public class LevelTraversalTestII {
    public static void main(String[] args) {
        TreeNode root = TreeNode.init();

        List<Integer> res = levelTraversal(root);

        System.out.println(res);
    }

    private static List<Integer> levelTraversal(TreeNode root) {
        if(root == null) {
            return null;
        }

        LinkedList<TreeNode> treeNodes = new LinkedList<>();
        List<Integer>  list = new ArrayList<>();
        treeNodes.add(root);

        while(!treeNodes.isEmpty()) {
            TreeNode remove = treeNodes.remove(0);

            list.add(remove.val);

            if(remove.left != null) {
                treeNodes.add(remove.left);
            }
            if(remove.right != null) {
                treeNodes.add(remove.right);
            }
        }

        return list;
    }
}
