package 二叉树;

import java.util.LinkedList;

/**
 * @author 邱学伟
 * @version V1.0
 * @Package 二叉树
 * @date 2020/9/28 下午4:48
 */
public class _104_二叉树的最大深度 {

    public int maxDepth20221228(TreeNode root) {
        int res = 0;
        if (root == null) {
            return res;
        } else if (root.left == null && root.right == null) {
            return 1;
        }
        int maxLeft = maxDepth20221228(root.left);
        int maxRight = maxDepth20221228(root.right);
        return Math.max(maxLeft, maxRight) + 1;
    }

    public int maxDepth20221228_2(TreeNode root) {
        int res = 0;
        if (root == null) {
            return res;
        }
        LinkedList<TreeNode> list = new LinkedList<TreeNode>();
        list.push(root);
        while (!list.isEmpty()) {
            int size = list.size();
            res += 1;
            for (int i = 0; i < size; i++) {
                TreeNode node = list.poll();
                if (node.left != null) {
                    list.push(node.left);
                }
                if (node.right != null) {
                    list.push(node.right);
                }
            }
        }
        return res;
    }


    /**
     * 给定一个二叉树，找出其最大深度。
     *
     * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
     *
     * 说明: 叶子节点是指没有子节点的节点。
     *
     * 示例：
     * 给定二叉树 [3,9,20,null,null,15,7]，
     * ```
     *     3
     *    / \
     *   9  20
     *     /  \
     *    15   7
     * ```
     * 返回它的最大深度 3 。
     *
     *
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/maximum-depth-of-binary-tree
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    // 递归
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        int leftHight = maxDepth(root.left);
        int rightHight = maxDepth(root.right);
        return Math.max(leftHight,rightHight) + 1;
    }
    
    // 循环
//    public int maxDepth(TreeNode root) {
//        if (root == null) return 0;
//        int depth = 0;
//        Queue<TreeNode> queue = new LinkedList<TreeNode>();
//        queue.add(root);
//        while (!queue.isEmpty()) {
//            int size = queue.size();
//            for (int i = 0; i < size; i++) {
//                TreeNode node = queue.poll();
//                if (node.left != null) {
//                    queue.add(node.left);
//                }
//                if (node.right != null) {
//                    queue.add(node.right);
//                }
//            }
//            depth += 1;
//        }
//        return depth;
//    }

}
