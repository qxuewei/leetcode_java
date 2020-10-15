package 二叉树;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author 邱学伟
 * @version V1.0
 * @Package 二叉树
 * @date 2020/10/14 下午6:10
 */
public class _101_对称二叉树 {
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
