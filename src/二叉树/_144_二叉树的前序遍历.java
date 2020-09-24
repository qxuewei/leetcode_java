package 二叉树;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author 邱学伟
 * @version V1.0
 * @Package 二叉树
 * @date 2020/9/12 下午4:15
 */
public class _144_二叉树的前序遍历 {
    /**
     * 给定一个二叉树，返回它的 前序 遍历。
     *
     *  示例:
     *
     * 输入: [1,null,2,3]
     *    1
     *     \
     *      2
     *     /
     *    3
     *
     * 输出: [1,2,3]
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/binary-tree-preorder-traversal
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

//    private List<Integer> list = new ArrayList<Integer>();
//
//    // 递归
//    public List<Integer> preorderTraversal(TreeNode root) {
//        preorderTraversalMethod(root);
//        return list;
//    }
//    public void preorderTraversalMethod(TreeNode root) {
//        if (root == null) return;
//        list.add(root.val);
//        preorderTraversalMethod(root.left);
//        preorderTraversalMethod(root.right);
//    }

    // 迭代
    public List<Integer> preorderTraversal(TreeNode root) {
        LinkedList<Integer> output = new LinkedList<Integer>();
        if (root == null) {
            return output;
        }
        LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
        stack.add(root);
        while (!stack.isEmpty()) {
            TreeNode last = stack.pollLast();
            output.add(last.val);
            if (last.right != null) {
                stack.add(last.right);
            }
            if (last.left != null) {
                stack.add(last.left);
            }
        }
        return output;
    }
}
