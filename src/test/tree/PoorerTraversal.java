package test.tree;

import tree.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author ：隋亮亮
 * @since ：2020/7/1 22:50
 */
public class PoorerTraversal {
    public static void main(String[] args) {
        TreeNode treeNode = TreeNode.init();
        List<Integer> list = postorderTraversal(treeNode);
//        postorderTraversal(treeNode);
        System.out.println(list);
    }

    private static List<Integer> postorderTraversal(TreeNode treeNode) {
        if(treeNode == null) {
            return null;
        }

        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        stack.push(treeNode);

        while(!stack.isEmpty()) {
            TreeNode pop = stack.pop();

            if(pop.left != null) {
                stack.push(pop.left);
            }

            if(pop.right != null) {
                stack.push(pop.right);
            }

            res.add(0, pop.val);
        }

        return res;
    }
}
