package 牛客;

import 二叉树.TreeNode;

// https://www.nowcoder.com/practice/8a19cbe657394eeaac2f6ea9b0f6fcf6?tpId=295&tqId=23282
public class _BM40_重建二叉树 {
    public TreeNode reCreat(int[] pre, int[] vin) {
        return pReCreat(pre, 0, pre.length - 1, vin, 0, vin.length - 1);
    }

    // 前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，
    public TreeNode pReCreat(int[] xianxu, int l1, int r1, int[] zhongxu, int l2, int r2) {
        if (l1 > r1 || l2 > r2) {
            return null;
        }
        TreeNode node = new TreeNode(xianxu[l1]);

        int rootIndex = 0;
        for (int i = l2; i <= r2; i++) {
            if (xianxu[l1] == zhongxu[i]) {
                rootIndex = i;
                break;
            }
        }
        // rootIndex = 3  r2 = 7
        int leftLength = rootIndex - l2;//3
        int rightLenth = r2 - rootIndex;//4

        node.left = pReCreat(xianxu, l1 + 1, l1 + leftLength, zhongxu, l2, l2 + leftLength - 1);
        node.right = pReCreat(xianxu, r1 - rightLenth + 1, r1, zhongxu, rootIndex + 1, r2);
        return node;
    }
}
