package 牛客;

import 二叉树.TreeNode;

import java.util.*;

//https://www.nowcoder.com/practice/e0cc33a83afe4530bcec46eba3325116?tpId=117&rp=1&ru=%2Fexam%2Foj&qru=%2Fexam%2Foj&sourceUrl=%2Fexam%2Foj%3Fpage%3D1%26pageSize%3D50%26search%3D%26tab%3D%25E7%25AE%2597%25E6%25B3%2595%25E7%25AF%2587%26topicId%3D117&difficulty=&judgeStatus=&tags=&title=&gioEnter=menu
public class _NC102_在二叉树中找到两个节点的最近公共祖先 {
    // 非递归
    /*
    1. 使用 HashMap 保存每个节点的父节点
    2. 使用 Set 保存 o1 的所有父节点
    3. 从 o2 向上遍历找到最近公共父节点
     */
    public int lowestCommonAncestor (TreeNode root, int o1, int o2) {
        HashMap<Integer, Integer> parent = new HashMap<>();
        parent.put(root.val, Integer.MIN_VALUE);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!parent.containsKey(o1) || !parent.containsKey(o2)) {
            TreeNode cur = queue.poll();
            if (cur.left != null) {
                parent.put(cur.left.val, cur.val);
                queue.add(cur.left);
            }
            if (cur.right != null) {
                parent.put(cur.right.val, cur.val);
                queue.add(cur.right);
            }
        }
        Set<Integer> set = new HashSet<>();
        while (parent.containsKey(o1)) {
            set.add(o1);
            o1 = parent.get(o1);
        }
        while (!set.contains(o2)) {
            o2 = parent.get(o2);
        }
        return o2;
    }
}
