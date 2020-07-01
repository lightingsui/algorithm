package tree;

/**
 * 二叉树的前序遍历
 *
 * @author ：隋亮亮
 * @since ：2020/6/28 22:13
 */
public class PreorderTraversal {
    public static void main(String[] args) {
        TreeNode treeNode = TreeNode.init();

//        List<Integer> ans = preorderTraversal(treeNode);

        preorderTraversal(treeNode);

//        System.out.println(ans);
    }

    /** 迭代实现 **/
    /*private static List<Integer> preorderTraversal(TreeNode treeNode) {
        if(treeNode == null) {
            return null;
        }

        List<Integer> ans = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        stack.push(treeNode);

        while(!stack.isEmpty()) {
            TreeNode tmp = stack.pop();

            ans.add(tmp.val);

            if(tmp.right != null) {
                stack.push(tmp.right);
            }

            if(tmp.left != null) {
                stack.push(tmp.left);
            }
        }

        return ans;
    }*/

    /** 递归实现 **/
    private static void preorderTraversal(TreeNode treeNode) {
        if(treeNode == null) {
            return;
        }

        System.out.println(treeNode.val);
        preorderTraversal(treeNode.left);
        preorderTraversal(treeNode.right);
    }
}
