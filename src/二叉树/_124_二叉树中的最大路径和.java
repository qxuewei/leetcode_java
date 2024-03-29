package 二叉树;
/*
路径 被定义为一条从树中任意节点出发，沿父节点-子节点连接，达到任意节点的序列。同一个节点在一条路径序列中 至多出现一次 。该路径 至少包含一个 节点，且不一定经过根节点。

路径和 是路径中各节点值的总和。

给你一个二叉树的根节点 root ，返回其 最大路径和 。

 

示例 1：


输入：root = [1,2,3]
输出：6
解释：最优路径是 2 -> 1 -> 3 ，路径和为 2 + 1 + 3 = 6
示例 2：


输入：root = [-10,9,20,null,null,15,7]
输出：42
解释：最优路径是 15 -> 20 -> 7 ，路径和为 15 + 20 + 7 = 42

来源：力扣（LeetCode）
链接：https://leetcode.cn/problems/binary-tree-maximum-path-sum
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class _124_二叉树中的最大路径和 {
    // 递归
    int maxValue = Integer.MIN_VALUE;
    public int maxSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        _maxSum(root);
        return maxValue;
    }
    public int _maxSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftMax = Math.max(0, _maxSum(root.left));
        int rightMax = Math.max(0, _maxSum(root.right));
        // 当前节点最大路径
        int curMax = root.val + leftMax + rightMax;
        maxValue = Math.max(maxValue, curMax);
        // 返回该节点最大贡献值
        return root.val + Math.max(leftMax, rightMax);
    }
}
