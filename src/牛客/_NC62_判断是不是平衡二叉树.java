package 牛客;

import 二叉树.TreeNode;

// https://www.nowcoder.com/practice/8b3b95850edb4115918ecebdf1b4d222?tpId=117&tqId=37757&rp=1&ru=/exam/oj&qru=/exam/oj&sourceUrl=%2Fexam%2Foj%3Fpage%3D1%26pageSize%3D50%26search%3D%26tab%3D%25E7%25AE%2597%25E6%25B3%2595%25E7%25AF%2587%26topicId%3D117&difficulty=undefined&judgeStatus=undefined&tags=&title=
public class _NC62_判断是不是平衡二叉树 {
    // 递归
    public boolean IsBalanced_Solution(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) {
            return true;
        }
        return Math.abs(length(root.left) - length(root.right)) <= 1
                && IsBalanced_Solution(root.left)
                && IsBalanced_Solution(root.right);
    }
    private int length(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(length(root.left), length(root.right)) + 1;
    }
}
