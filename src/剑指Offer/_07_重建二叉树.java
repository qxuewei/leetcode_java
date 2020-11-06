package 剑指Offer;

import 二叉树.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 邱学伟
 * @version V1.0
 * @Package 剑指Offer
 * @date 2020/11/6 下午12:13
 */
public class _07_重建二叉树 {
    /**
     * 输入某二叉树的前序遍历和中序遍历的结果，请重建该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
     *
     *  
     *
     * 例如，给出
     *
     * 前序遍历 preorder = [3,9,20,15,7]
     * 中序遍历 inorder = [9,3,15,20,7]
     * 返回如下的二叉树：
     *
     *     3
     *    / \
     *   9  20
     *     /  \
     *    15   7
     *  
     *
     * 限制：
     *
     * 0 <= 节点个数 <= 5000
     *
     *
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/zhong-jian-er-cha-shu-lcof
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    List<Integer> pre = new ArrayList<>();
    List<Integer> in = new ArrayList<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i : preorder) {
            pre.add(i);
        }
        for (int i : inorder) {
            in.add(i);
        }
        return build(pre,in);
    }

    public TreeNode build(List<Integer> pre, List<Integer> in) {
        if (in.size() == 0) {
            return null;
        }
        Integer rootV = pre.remove(0);
        TreeNode node = new TreeNode(rootV);
        int mid = in.indexOf(rootV);
        node.left = build(pre,in.subList(0,mid));
        node.right = build(pre,in.subList(mid+1,in.size()));
        return node;
    }
}
