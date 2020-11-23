package 剑指Offer;

import 二叉树.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class _37_序列化二叉树 {
    /**
     * 请实现两个函数，分别用来序列化和反序列化二叉树。
     *
     * 示例: 
     *
     * 你可以将以下二叉树：
     *
     *     1
     *    / \
     *   2   3
     *      / \
     *     4   5
     *
     * 序列化为 "[1,2,3,null,null,4,5]"
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/xu-lie-hua-er-cha-shu-lcof
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) return "[]";
        StringBuilder builder = new StringBuilder("[");
        Queue<TreeNode> queue = new LinkedList<>(){
            {add(root);}
        };
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node != null) {
                builder.append(node.val + ",");
                queue.add(node.left);
                queue.add(node.right);
            } else {
                builder.append("null,");
            }
        }
        builder.deleteCharAt(builder.length()-1);
        builder.append("]");
        return builder.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.equals("[]"))
            return null;
        String[] vals = data.substring(1, data.length() - 1).split(",");
        TreeNode root = new TreeNode(Integer.parseInt(vals[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int i = 1;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (!vals[i].equals("null")) {
                node.left = new TreeNode(Integer.parseInt(vals[i]));
                queue.add(node.left);
            }
            i++;
            if (!vals[i].equals("null")) {
                node.right = new TreeNode(Integer.parseInt(vals[i]));
                queue.add(node.right);
            }
            i++;
        }
        return root;
    }
}
