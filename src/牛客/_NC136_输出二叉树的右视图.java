package 牛客;

import 二叉树.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;

// https://www.nowcoder.com/practice/c9480213597e45f4807880c763ddd5f0?tpId=117&tqId=37848&rp=1&ru=/exam/oj&qru=/exam/oj&sourceUrl=%2Fexam%2Foj%3Fpage%3D1%26pageSize%3D50%26search%3D%26tab%3D%25E7%25AE%2597%25E6%25B3%2595%25E7%25AF%2587%26topicId%3D117&difficulty=undefined&judgeStatus=undefined&tags=&title=
public class _NC136_输出二叉树的右视图 {
    public int[] solve (int[] xianxu, int[] zhongxu) {
        if (xianxu.length == 0) {
            return new int[0];
        }
        TreeNode tree = pReCreat(xianxu, 0, xianxu.length - 1, zhongxu, 0, zhongxu.length - 1);
        return printRightItem(tree);
    }

    // xianxu：根左右  zhongzu：左中右
    // 前序：[1,2,4,5,3]   中序：[4,2,5,1,3]
    private TreeNode pReCreat(int[] xianxu, int l1, int r1, int[] zhongxu, int l2, int r2) {
        if (l1 > r1 || l2 > r2) {
            return null;
        }
        TreeNode node = new TreeNode(xianxu[l1]);
        int rootIndexInZhongxu = 0;
        for (int i = l2; i <= r2 ; i++) {
            if (xianxu[l1] == zhongxu[i]) {
                rootIndexInZhongxu = i;
                break;
            }
        }
        int leftLength = rootIndexInZhongxu - l2;
        int rightLenth = r2 - rootIndexInZhongxu;
        node.left = pReCreat(xianxu, l1 + 1, l1 + leftLength, zhongxu, l2, l2 + leftLength - 1);
        node.right = pReCreat(xianxu, r1 - rightLenth + 1, r1, zhongxu, rootIndexInZhongxu + 1, r2);
        return node;
    }

    private int[] printRightItem(TreeNode node) {
        if (node == null) {
            return new int[0];
        }
        ArrayList<Integer> arrayList = new ArrayList<>();

        LinkedList<TreeNode> queue = new LinkedList();
        queue.add(node);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                if (i == size - 1) {
                    arrayList.add(cur.val);
                }
                if (cur.left != null) {
                    queue.add(cur.left);
                }
                if (cur.right != null) {
                    queue.add(cur.right);
                }
            }
        }
        int[] res = new int[arrayList.size()];
        for (int i = 0; i < arrayList.size(); i++) {
            res[i] = arrayList.get(i);
        }
        return res;
    }

}
