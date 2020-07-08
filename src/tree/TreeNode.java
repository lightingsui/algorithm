package tree;

/**
 * 二叉树的节点
 *
 * @author ：隋亮亮
 * @since ：2020/6/28 22:13
 */
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }

    /**
     *          1
     *      2       3
     *  4      5  6    7
     *
     *
     * @return
     */
    public static TreeNode init() {
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);
        treeNode.right = new TreeNode(3);
        treeNode.right.right = new TreeNode(7);
        treeNode.right.left = new TreeNode(6);


        treeNode.left.left = new TreeNode(4);
        treeNode.left.right = new TreeNode(5);

        return treeNode;
    }
}
