package test.tree;

import tree.TreeNode;

import java.util.LinkedList;
import java.util.Stack;

/**
 * @author ：隋亮亮
 * @since ：2020/8/5 23:32
 */
public class PoorerTraversalTestII {
    public static void main(String[] args) {
        TreeNode treeNode = TreeNode.init();
        LinkedList<Integer> integers = postorderTraversal(treeNode);

        integers.forEach(System.out::println);
    }

    private static LinkedList<Integer> postorderTraversal(TreeNode root) {
        if(root == null) {
            return null;
        }

        Stack<TreeNode> stack = new Stack<>();
        LinkedList<Integer> treeNodes = new LinkedList<>();

        stack.push(root);

        while(!stack.isEmpty()) {
            TreeNode pop = stack.pop();

            if(pop.left != null) {
                stack.push(pop.left);
            }
            if(pop.right != null) {
                stack.push(pop.right);
            }

            treeNodes.add(0, pop.val);
        }

        return treeNodes;
    }
}
