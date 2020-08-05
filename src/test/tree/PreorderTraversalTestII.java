package test.tree;

import tree.TreeNode;

import java.util.Stack;

/**
 * @author ：隋亮亮
 * @since ：2020/8/5 23:19
 */
public class PreorderTraversalTestII {
    public static void main(String[] args) {
        TreeNode treeNode = TreeNode.init();

        preorderTraversal(treeNode);
    }

    private static void preorderTraversal(TreeNode treeNode) {
        if(treeNode == null) {
            return;
        }

        Stack<TreeNode> stack = new Stack<>();

        stack.push(treeNode);

        while (!stack.isEmpty()) {
            TreeNode pop = stack.pop();

            System.out.println(pop.val);

            if(pop.right != null) {
                stack.push(pop.right);
            }

            if(pop.left != null) {
                stack.push(pop.left);
            }
        }
    }
}
