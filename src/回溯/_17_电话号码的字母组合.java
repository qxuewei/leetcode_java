package 回溯;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

// https://leetcode.cn/problems/letter-combinations-of-a-phone-number/?favorite=2cktkvj
public class _17_电话号码的字母组合 {
    public List<String> letterCombinations(String digits) {
        ArrayList<String> res = new ArrayList<>();
        if (digits.length() == 0) {
            return res;
        }
        HashMap<Character, String> map = new HashMap<>() {{
            put('2', "abc");
            put('3', "def");
            put('4', "ghi");
            put('5', "jkl");
            put('6', "mno");
            put('7', "pqrs");
            put('8', "tuv");
            put('9', "wxyz");
        }};

        _letterCombinations(digits, res, map, 0, new StringBuffer());
        return res;
    }

    private void _letterCombinations(String digits,
                                     ArrayList<String> res,
                                     HashMap<Character, String> map,
                                     int index,
                                     StringBuffer buffer) {
        if (buffer.length() == digits.length()) {
            res.add(buffer.toString());
            return;
        }
        Character chr = digits.charAt(index);
        String curString = map.get(chr);
        int length = curString.length();
        for (int i = 0; i < length; i++) {
            buffer.append(curString.charAt(i));
            _letterCombinations(digits, res, map, index + 1, buffer);
            buffer.deleteCharAt(index);
        }
    }
}
