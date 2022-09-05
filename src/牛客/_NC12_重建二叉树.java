package 牛客;

import 二叉树.TreeNode;

import java.util.Arrays;

//https://www.nowcoder.com/practice/8a19cbe657394eeaac2f6ea9b0f6fcf6?tpId=117&tqId=37775&rp=1&ru=/exam/oj&qru=/exam/oj&sourceUrl=%2Fexam%2Foj%3Fpage%3D1%26pageSize%3D50%26search%3D%26tab%3D%25E7%25AE%2597%25E6%25B3%2595%25E7%25AF%2587%26topicId%3D117&difficulty=undefined&judgeStatus=undefined&tags=&title=

public class _NC12_重建二叉树 {
    // pre: [1,2,4,7,3,5,6,8]
    // vin: [4,7,2,1,5,3,8,6]
    public TreeNode reConstructBinaryTree(int[] pre, int[] vin) {
        int n = pre.length;
        int m = vin.length;
        if (n == 0 || m == 0) {
            return null;
        }
        TreeNode root = new TreeNode(pre[0]);
        for (int i = 0; i < m; i++) {
            if (root.val == vin[i]) {
                int[] preLeft = Arrays.copyOfRange(pre, 1, i + 1);
                int[] preRight = Arrays.copyOfRange(pre, i + 1, n);
                int[] vinLeft = Arrays.copyOfRange(vin, 0, i);
                int[] vinRight = Arrays.copyOfRange(vin, i + 1, m);
                root.left = reConstructBinaryTree(preLeft, vinLeft);
                root.right = reConstructBinaryTree(preRight, vinRight);
                break;
            }
        }
        return root;
    }
}
