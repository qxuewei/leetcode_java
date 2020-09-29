package 二叉树;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author 邱学伟
 * @version V1.0
 * @Package 二叉树
 * @date 2020/9/29 下午4:20
 */
public class _662_二叉树最大宽度 {

    /**
     * 给定一个二叉树，编写一个函数来获取这个树的最大宽度。树的宽度是所有层中的最大宽度。这个二叉树与满二叉树（full binary tree）结构相同，但一些节点为空。
     *
     * 每一层的宽度被定义为两个端点（该层最左和最右的非空节点，两端点间的null节点也计入长度）之间的长度。
     *
     * 示例 1:
     *
     * 输入:
     * ```
     *            1
     *          /   \
     *         3     2
     *        / \     \
     *       5   3     9
     * ```
     * 输出: 4
     * 解释: 最大值出现在树的第 3 层，宽度为 4 (5,3,null,9)。
     * 示例 2:
     *
     * 输入:
     * ```
     *           1
     *          /
     *         3
     *        / \
     *       5   3
     * ```
     * 输出: 2
     * 解释: 最大值出现在树的第 3 层，宽度为 2 (5,3)。
     * 示例 3:
     *
     * 输入:
     * ```
     *           1
     *          / \
     *         3   2
     *        /
     *       5
     * ```
     * 输出: 2
     * 解释: 最大值出现在树的第 2 层，宽度为 2 (3,2)。
     * 示例 4:
     *
     * 输入:
     * ```
     *           1
     *          / \
     *         3   2
     *        /     \
     *       5       9
     *      /         \
     *     6           7
     * ```
     * 输出: 8
     * 解释: 最大值出现在树的第 4 层，宽度为 8 (6,null,null,null,null,null,null,7)。
     * 注意: 答案在32位有符号整数的表示范围内。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/maximum-width-of-binary-tree
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        Queue<AnnotatedNode> queue = new LinkedList<AnnotatedNode>();
        queue.offer(new AnnotatedNode(root,0,0));
        int widthOfBinaryTree = 0;
        int curDepth = 0, left = 0;
        while (!queue.isEmpty()) {
            AnnotatedNode annotatedNode = queue.poll();
            TreeNode node = annotatedNode.node;
            if (node != null) {
                queue.offer(new AnnotatedNode(node.left,annotatedNode.depth + 1,annotatedNode.pos * 2));
                queue.offer(new AnnotatedNode(node.right,annotatedNode.depth + 1,annotatedNode.pos * 2 + 1));
                if (curDepth != annotatedNode.depth) {
                    curDepth = annotatedNode.depth;
                    left = annotatedNode.pos;
                }
                widthOfBinaryTree = Math.max(widthOfBinaryTree, annotatedNode.pos - left + 1);
            }
        }
        return widthOfBinaryTree;
    }
}


