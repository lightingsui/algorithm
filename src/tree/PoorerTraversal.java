package tree;

/**
 * 二叉树的后续遍历
 *
 * @author ：隋亮亮
 * @since ：2020/6/28 22:53
 */
public class PoorerTraversal {
    public static void main(String[] args) {
        TreeNode treeNode = TreeNode.init();
//        List<Integer> list = postorderTraversal(treeNode);
            postorderTraversal(treeNode);
//        System.out.println(list);

    }

    /** 迭代遍历 **/
    /*public static List<Integer> postorderTraversal(TreeNode node) {
        if(node == null) {
            return null;
        }

        List<Integer> ans = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        stack.push(node);

        while(!stack.isEmpty()) {
            TreeNode pop = stack.pop();

            if(pop.left != null) {
                stack.push(pop.left);
            }

            if(pop.right != null) {
                stack.push(pop.right);
            }

            ans.add(0, pop.val);
        }

        return ans;
    }*/

    public static void postorderTraversal(TreeNode node) {
        if(node == null) {
            return;
        }

        postorderTraversal(node.left);
        postorderTraversal(node.right);
        System.out.println(node.val);
    }
}
