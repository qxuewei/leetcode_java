package 牛客;

/*
https://www.nowcoder.com/practice/91b69814117f4e8097390d107d2efbe0?tpId=117&rp=1&ru=%2Fexam%2Foj&qru=%2Fexam%2Foj&sourceUrl=%2Fexam%2Foj%3Fpage%3D1%26pageSize%3D50%26search%3D%26tab%3D%25E7%25AE%2597%25E6%25B3%2595%25E7%25AF%2587%26topicId%3D117&difficulty=&judgeStatus=&tags=&title=&gioEnter=menu
 */

import 二叉树.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class _NC14_按之字形顺序打印二叉树 {
    public ArrayList<ArrayList<Integer>> printTree(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if (pRoot == null) {
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(pRoot);
        boolean tag = true;
        while (!queue.isEmpty()) {
            ArrayList<Integer> sub = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                sub.add(node.val);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            if (!tag) {
                this.reverse(sub);
            }
            res.add(sub);
            tag = !tag;
        }
        return res;
    }
    private void reverse(ArrayList<Integer> array) {
        int left = 0;
        int right = array.size() - 1;
        int tmp;
        while (left < right) {
            tmp = array.get(right);
            array.set(right, array.get(left));
            array.set(left, tmp);
            left += 1;
            right -= 1;
        }
    }
}
