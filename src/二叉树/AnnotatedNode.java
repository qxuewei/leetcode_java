package 二叉树;

/**
 * @author 邱学伟
 * @version V1.0
 * @Package 二叉树
 * @date 2020/9/29 下午5:58
 */
public class AnnotatedNode {
    TreeNode node;
    int depth, pos;
    AnnotatedNode(TreeNode n, int d, int p) {
        node = n;
        depth = d;
        pos = p;
    }
}
