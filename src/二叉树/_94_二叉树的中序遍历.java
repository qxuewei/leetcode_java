package 二叉树;

import java.util.*;

/**
 * @author 邱学伟
 * @version V1.0
 * @Package 二叉树
 * @date 2020/9/22 下午4:35
 */
public class _94_二叉树的中序遍历 {
    /**
     * 给定一个二叉树，返回它的中序 遍历。
     *
     * 示例:
     * ```
     * 输入: [1,null,2,3]
     *    1
     *     \
     *      2
     *     /
     *    3
     * ```
     * 输出: [1,3,2]
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/binary-tree-inorder-traversal
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    // 递归
    public List<Integer> inorderTraversal1(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        inorder(root,list);
        return list;
    }
    public void inorder(TreeNode node, List<Integer> list) {
        if (node == null) return;
        inorder(node.left,list);
        list.add(node.val);
        inorder(node.right,list);
    }


    // 迭代
    public List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        Deque<TreeNode> stack = new LinkedList<TreeNode>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            TreeNode node = stack.pop();
            list.add(node.val);
            root = node.right;
        }
        return list;
    }

    // MJ
    public List<Integer> inorderTraversal3(TreeNode root) {
        LinkedList<Integer> list = new LinkedList<>();
        if (root == null) return list;
        TreeNode node = root;
        Stack<TreeNode> stack = new Stack<>();
        while (true) {
            if (node != null) {
                stack.push(node);
                node = node.left;
            } else if (stack.isEmpty()){
                return list;
            } else {
                node = stack.pop();
                list.add(node.val);
                node = node.right;
            }
        }
    }
}
