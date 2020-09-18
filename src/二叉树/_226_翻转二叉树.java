package 二叉树;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author 邱学伟
 * @version V1.0
 * @Package 二叉树
 * @date 2020/9/18 下午12:12
 */
public class _226_翻转二叉树 {
    /**
     * 翻转一棵二叉树。
     *
     * 示例：
     *
     * 输入：
     * ```
     *      4
     *    /   \
     *   2     7
     *  / \   / \
     * 1   3 6   9
     * ```
     * 输出：
     * ```
     *      4
     *    /   \
     *   7     2
     *  / \   / \
     * 9   6 3   1
     * ```
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/invert-binary-tree
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    /// 前序遍历
//    public TreeNode invertTree(TreeNode root) {
//        if (root == null) return root;
//
//        TreeNode temp = root.left;
//        root.left = root.right;
//        root.right = temp;
//
//        invertTree(root.left);
//        invertTree(root.right);
//
//        return root;
//    }


    /// 中序遍历
//    public TreeNode invertTree(TreeNode root) {
//        if (root == null) return root;
//
//        invertTree(root.left);
//
//        TreeNode temp = root.left;
//        root.left = root.right;
//        root.right = temp;
//
//        invertTree(root.left);
//
//        return root;
//    }

    /// 后序遍历
//    public TreeNode invertTree(TreeNode root) {
//        if (root == null) return root;
//
//        invertTree(root.left);
//        invertTree(root.right);
//
//        TreeNode temp = root.left;
//        root.left = root.right;
//        root.right = temp;
//
//        return root;
//    }

    /// 层序遍历
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return root;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }

            TreeNode temp = node.left;
            node.left = node.right;
            node.right = temp;
        }

        return root;
    }
}
