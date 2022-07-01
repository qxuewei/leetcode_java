package 牛客;

import 二叉树.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

public class _NC45_实现二叉树先序中序和后序遍历 {
    /**
     *
     * @param root TreeNode类 the root of binary tree
     * @return int整型二维数组
     */
    public int[][] threeOrders (TreeNode root) {
        // write code here
        int[][] res = new int[3][];
        res[0] = preThreeOrders2(root);
        res[1] = middleThreeOrders2(root);
        res[2] = thenThreeOrders2(root);
        return res;
    }

    public int[] toInt(ArrayList<Integer> list) {
        return list.stream().mapToInt(Integer::intValue).toArray();
    }

    // 迭代 ->
    // 前序
    public int[] preThreeOrders2 (TreeNode root) {
        if (root == null) {
            return new int[0];
        }
        ArrayList<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.add(root);
        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            list.add(cur.val);
            if (cur.right != null) {
                stack.add(cur.right);
            }
            if (cur.left != null) {
                stack.add(cur.left);
            }
        }
        return toInt(list);
    }

    // 中序
    public int[] middleThreeOrders2 (TreeNode root) {
        if (root == null) {
            return new int[0];
        }
        ArrayList<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode cur = root;
        while (!stack.isEmpty() || cur != null) {
            // 左节点全入栈
            if (cur != null) {
                stack.add(cur);
                cur = cur.left;
            } else {
                cur = stack.pop();
                list.add(cur.val);
                cur = cur.right;
            }
        }
        return toInt(list);
    }

    // 后序
    public int[] thenThreeOrders2 (TreeNode root) {
        if (root == null) {
            return new int[0];
        }
        ArrayList<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop();
//            list.add(0, cur.val);
            list.add(cur.val);
            if (cur.left != null) {
                stack.add(cur.left);
            }
            if (cur.right != null) {
                stack.add(cur.right);
            }
        }
        Collections.reverse(list);
        return toInt(list);
    }

    // 递归 ->
    // 前序
    public int[] preThreeOrders (TreeNode root) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        _preThreeOrders(root, list);
        return this.toInt(list);
    }
    public void _preThreeOrders (TreeNode root, ArrayList<Integer> arrayList) {
        if (root == null) {
            return;
        }
        arrayList.add(root.val);
        _preThreeOrders(root.left, arrayList);
        _preThreeOrders(root.right, arrayList);
    }

    // 中序
    public int[] middleThreeOrders (TreeNode root) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        _middleThreeOrders(root, list);
        return this.toInt(list);
    }
    public void _middleThreeOrders (TreeNode root, ArrayList<Integer> arrayList) {
        if (root == null) {
            return;
        }
        _middleThreeOrders(root.left, arrayList);
        arrayList.add(root.val);
        _middleThreeOrders(root.right, arrayList);
    }

    // 后序
    public int[] thenThreeOrders (TreeNode root) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        _thenThreeOrders(root, list);
        return this.toInt(list);
    }
    public void _thenThreeOrders (TreeNode root, ArrayList<Integer> arrayList) {
        if (root == null) {
            return;
        }
        _thenThreeOrders(root.left, arrayList);
        _thenThreeOrders(root.right, arrayList);
        arrayList.add(root.val);
    }
}
