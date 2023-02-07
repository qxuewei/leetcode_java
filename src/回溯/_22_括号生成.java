package 回溯;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.cn/problems/generate-parentheses/?favorite=2cktkvj
public class _22_括号生成 {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        _generateParenthesis(res, new StringBuffer(), 0, 0, n);
        return res;
    }
    // 回溯
    private void _generateParenthesis(List<String> res, StringBuffer buffer, int left, int right, int n) {
        if (buffer.length() == n + n) {
            res.add(buffer.toString());
            return;
        }
        if (left < n) {
            buffer.append("(");
            _generateParenthesis(res, buffer, left + 1, right, n);
            buffer.deleteCharAt(buffer.length() - 1);
        }
        if (right < left) {
            buffer.append(")");
            _generateParenthesis(res, buffer, left, right + 1, n);
            buffer.deleteCharAt(buffer.length() - 1);
        }
    }
}
