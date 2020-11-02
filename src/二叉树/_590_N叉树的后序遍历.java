package 二叉树;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author 邱学伟
 * @version V1.0
 * @Package 二叉树
 * @date 2020/10/29 下午6:11
 */
public class _590_N叉树的后序遍历 {
    /**
     * 给定一个 N 叉树，返回其节点值的后序遍历。
     *
     * 例如，给定一个 3叉树 :
     *
     * ![](http://blog.image.jkxuewei.com/mweb/2020.10.29.16039662321985.16039661467750.jpg)
     *
     * 返回其后序遍历: [5,6,3,2,4,1].
     *
     * https://leetcode-cn.com/problems/n-ary-tree-postorder-traversal/
     */

    // 递归
    public List<Integer> postorder(Node root) {
        List<Integer> list = new ArrayList();
        postorder(root,list);
        return list;
    }
    public void postorder(Node root, List<Integer> list) {
        if (root == null) return;
        for (int i = 0; i < root.children.size(); i++) {
            Node node = root.children.get(i);
            postorder(node,list);
        }
        list.add(root.val);
    }

    // 迭代
    public List<Integer> postorder2(Node root) {
        List<Integer> list = new ArrayList();
        if (root == null) return list;
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node node = stack.peek();
            for (int i = node.children.size() - 1; i >= 0 ; i--) {
                stack.push(node.children.get(i));
            }
            
        }
        return list;
    }
}
