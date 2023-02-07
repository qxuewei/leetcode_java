package 二叉树;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author 邱学伟
 * @version V1.0
 * @Package 二叉树
 * @date 2020/10/14 下午6:10
 * https://leetcode.cn/problems/symmetric-tree/description/
 */
public class _101_对称二叉树 {

    // 迭代 - 队列
    public boolean isSymmetric20230111(TreeNode root) {
        if (root == null) {
            return true;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root.left);
        queue.add(root.right);
        while (!queue.isEmpty()) {
            TreeNode first = queue.poll();
            TreeNode second = queue.poll();
            if (first == null && second == null) {
                continue;
            } else if (first == null || second == null || first.val != second.val) {
                return false;
            }
            queue.add(first.left);
            queue.add(second.right);
            queue.add(first.right);
            queue.add(second.left);
        }
        return true;
    }

    // 递归
    public boolean isSymmetric(TreeNode root) {
        return _isSymmetric(root.left, root.right);
    }

    public boolean _isSymmetric(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        } else if (left == null && right != null || left != null && right == null) {
            return false;
        } else if (left.val != right.val) {
            return false;
        }
        return _isSymmetric(left.right, right.left) && _isSymmetric(left.left, right.right);
    }


    /**
     * 给定一个二叉树，检查它是否是镜像对称的。
     *
     * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
     * ```
     *     1
     *    / \
     *   2   2
     *  / \ / \
     * 3  4 4  3
     * ```
     *
     * 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
     * ```
     *     1
     *    / \
     *   2   2
     *    \   \
     *    3    3
     * ```
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/symmetric-tree
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    // 递归
//    public boolean isSymmetric(TreeNode root) {
//        if (root)
//    }

    // 迭代
//    public boolean isSymmetric(TreeNode root) {
//        Queue<TreeNode> queue = new LinkedList<>();
//        queue.add(root);
//        if (!queue.isEmpty()) {
//            TreeNode node = queue.poll();
//
//        }
//    }
}
