package 二叉树;

/**
 * @author 邱学伟
 * @version V1.0
 * @Package 二叉树
 * @date 2020/9/19 下午4:25
 */
public class _450_删除二叉搜索树中的节点 {
    /**
     * 给定一个二叉搜索树的根节点 root 和一个值 key，删除二叉搜索树中的 key 对应的节点，并保证二叉搜索树的性质不变。返回二叉搜索树（有可能被更新）的根节点的引用。
     *
     * 一般来说，删除节点可分为两个步骤：
     *
     * 首先找到需要删除的节点；
     * 如果找到了，删除它。
     * 说明： 要求算法时间复杂度为 O(h)，h 为树的高度。
     *
     * 示例:
     * ```
     * root = [5,3,6,2,4,null,7]
     * key = 3
     *
     *     5
     *    / \
     *   3   6
     *  / \   \
     * 2   4   7
     * ```
     * 给定需要删除的节点值是 3，所以我们首先找到 3 这个节点，然后删除它。
     *
     * 一个正确的答案是 [5,4,6,2,null,null,7], 如下图所示。
     * ```
     *     5
     *    / \
     *   4   6
     *  /     \
     * 2       7
     * ```
     * 另一个正确答案是 [5,2,6,null,4,null,7]。
     * ```
     *     5
     *    / \
     *   2   6
     *    \   \
     *     4   7
     * ```
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/delete-node-in-a-bst
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    // 前序节点的值(左子树最大值)
    public int predecessor(TreeNode root) {
        root = root.left;
        while (root.right != null) {
            root = root.right;
        }
        return root.val;
    }

    // 后继节点的值（右子树最小值）
    public int successor(TreeNode root) {
        root = root.right;
        while (root.left != null) {
            root = root.left;
        }
        return root.val;
    }

    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return root;

        // 找到要删除的节点
        if (key < root.val) {
            root.left = deleteNode(root.left,key);
        } else if (key > root.val) {
            root.right = deleteNode(root.right,key);
        } else {
            // root 为当前要删除的节点
            if (root.left == null && root.right == null) {
                root = null;
            } else if (root.right != null) {
                root.val = successor(root);
                root.right = deleteNode(root.right,root.val);
            } else {
                root.val = predecessor(root);
                root.left = deleteNode(root.left,root.val);
            }
        }
        return root;
    }

}
