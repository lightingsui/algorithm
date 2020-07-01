package test.tree;

import tree.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author ：隋亮亮
 * @since ：2020/7/1 22:35
 */
public class PreorderTraversal {
    public static void main(String[] args) {
        TreeNode treeNode = TreeNode.init();

        List<Integer> ans = preorderTraversal(treeNode);

//        preorderTraversal(treeNode);

        System.out.println(ans);
    }

    private static List<Integer> preorderTraversal(TreeNode treeNode) {
        if(treeNode == null) {
            return null;
        }
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        stack.push(treeNode);

        while(!stack.isEmpty()) {
            TreeNode pop = stack.pop();
            res.add(pop.val);

            if(pop.right != null) {
                stack.push(pop.right);
            }

            if(pop.left != null) {
                stack.push(pop.left);
            }
        }

        return res;
    }
}
