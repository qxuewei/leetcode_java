package 二叉树;

import java.util.List;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class _589_N叉树的前序遍历 {
    /**
     * 给定一个 N 叉树，返回其节点值的前序遍历。
     *
     * 例如，给定一个 3叉树 :
     *  ![-w310](http://blog.image.jkxuewei.com/mweb/2020.09.30.16014605393050.16014605235603.jpg)
     *
     * 返回其前序遍历: [1,3,5,6,2,4]。
     */

    // 递归
    public List<Integer> preorder(Node root) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        preorder(root,list);
        return list;
    }
    public void preorder(Node root, ArrayList<Integer> list) {
        if (root == null) return;
        list.add(root.val);
        for (int i = 0; i < root.children.size(); i++) {
            Node child = root.children.get(i);
            preorder(child,list);
        }
    }


    // 迭代
    public List<Integer> preorder2(Node root) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        if (root == null) return list;
        Stack<Node> stack = new Stack();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node node = stack.pop();
            list.add(node.val);
            for (int i = node.children.size() - 1; i >= 0 ; i--) {
                Node child = node.children.get(i);
                stack.push(child);
            }
        }
        return list;
    }

}
