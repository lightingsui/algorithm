package test.tree;

import tree.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author ：隋亮亮
 * @since ：2020/7/1 22:45
 */
public class InorderTraversal {
    public static void main(String[] args) {
        TreeNode treeNode = TreeNode.init();
        List<Integer> list = inorderTraversal(treeNode);
//        inorderTraversal(treeNode);

        System.out.println(list);
    }

    private static List<Integer> inorderTraversal(TreeNode treeNode) {
        if(treeNode == null) {
            return null;
        }

        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        do {
            while(treeNode != null) {
                stack.push(treeNode);
                treeNode = treeNode.left;
            }

            if(!stack.isEmpty()) {
                TreeNode pop = stack.pop();
                res.add(pop.val);

                if(pop.right != null) {
                    stack.push(pop.right);
                }
            }

        } while(!stack.isEmpty());

        return res;
    }
}
