package tree;

/**
 * 二叉树的中序遍历
 *
 * @author ：隋亮亮
 * @since ：2020/6/28 22:26
 */
public class InorderTraversal {
    public static void main(String[] args) {
        TreeNode treeNode = TreeNode.init();
//        List<Integer> list = inorderTraversal(treeNode);
        inorderTraversal(treeNode);

//        System.out.println(list);
    }

    /** 迭代实现 **/
   /* public static List<Integer> inorderTraversal(TreeNode node) {
        if(node == null) {
            return null;
        }

        List<Integer> ans = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        do {
            while(node != null) {
                stack.push(node);
                node = node.left;
            }

            if(!stack.isEmpty()) {
                TreeNode pop = stack.pop();
                ans.add(pop.val);

                node = pop.right;
            }
        } while(!stack.isEmpty() || node != null);

        return ans;
    }*/

    /** 递归实现 **/
    public static void inorderTraversal(TreeNode node) {
        if(node == null) {
            return;
        }

        inorderTraversal(node.left);
        System.out.println(node.val);
        inorderTraversal(node.right);
    }
}
