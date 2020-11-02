package 二叉树;

import java.util.*;

/**
 * @author 邱学伟
 * @version V1.0
 * @Package 二叉树
 * @date 2020/9/22 下午6:04
 */
public class _145_二叉树的后序遍历 {
    /**
     * 给定一个二叉树，返回它的 后序 遍历。
     *
     * 示例:
     *
     * 输入: [1,null,2,3]
     *    1
     *     \
     *      2
     *     /
     *    3
     * 输出: [3,2,1]
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/binary-tree-postorder-traversal
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    // 递归
    public List<Integer> postorderTraversal1(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        postorder(root, list);
        return list;
    }
    public void postorder(TreeNode root, List<Integer> list) {
        if (root == null) return;
        postorder(root.left, list);
        postorder(root.right, list);
        list.add(root.val);
    }

    // 迭代
    public List<Integer> postorderTraversal2(TreeNode root) {
        LinkedList<Integer> output = new LinkedList<>();
        if (root == null) {
            return output;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            output.addFirst(node.val);
            if (node.left != null) {
                stack.add(node.left);
            }
            if (node.right != null) {
                stack.add(node.right);
            }
        }
        return output;
    }



























    public List<Integer> postorderTraversal3(TreeNode root) {
        LinkedList<Integer> list = new LinkedList<>();
        if (root == null) return list;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            list.addFirst(node.val);
            

        }
        return list;
    }






}
