package test.tree;

import tree.TreeNode;

import java.util.Stack;

/**
 * @author ：隋亮亮
 * @since ：2020/8/5 23:28
 */
public class InorderTraversalTestII {
    public static void main(String[] args) {
        TreeNode treeNode = TreeNode.init();
        inorderTraversal(treeNode);
    }

    private static void inorderTraversal(TreeNode root) {
        if(root == null) {
            return;
        }

        Stack<TreeNode> stack = new Stack<>();

        do {
            while(root != null) {
                stack.push(root);
                root = root.left;
            }

            if(!stack.isEmpty()) {
                TreeNode pop = stack.pop();

                System.out.println(pop.val);

                root = pop.right;
            }
        } while(!stack.isEmpty() || root != null);
    }
}
