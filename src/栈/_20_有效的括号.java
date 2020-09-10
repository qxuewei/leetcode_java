package 栈;

/*
给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。

有效字符串需满足：
左括号必须用相同类型的右括号闭合。
左括号必须以正确的顺序闭合。
注意空字符串可被认为是有效字符串。

示例 1:
```
输入: "()"
输出: true
```
示例 2:
```
输入: "()[]{}"
输出: true
```
示例 3:
```
输入: "(]"
输出: false
```
示例 4:
```
输入: "([)]"
输出: false
```
示例 5:
```
输入: "{[]}"
输出: true
```
 */

import java.util.HashMap;
import java.util.Stack;

public class _20_有效的括号 {
	@SuppressWarnings("serial")
	private static final HashMap<Character,Character> map = new HashMap<Character,Character>(){{
		put('{','}'); put('[',']'); put('(',')'); put('?','?');
	}};
	public boolean isValid(String s) 
	{
		if (s == null) {
			return false;
		}
		if (s.length() % 2 != 0) {
			return false;
		}
		Stack<Character> stack = new Stack<Character>();
		stack.push('?');
		for (int i = 0; i < s.length(); i++) {
			char character = s.charAt(i);
			if (map.containsKey(character)) {
				stack.push(character);
			} else {
				char last = stack.pop();
				if (map.get(last) != character) {
					return false;
				}
			}
		}
		return stack.size() == 1;
	}
	
	public boolean isValid2(String s) 
	{
		char[] chars = new char[s.length()];
		int index = 0;
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c == '(' || c == '[' || c == '{') {
				chars[index++] = c;
			} else if (index == 0) {
				return false;
			} else if (c == ')' && chars[index - 1] == '(') {
				index -= 1;
			} else if (c == ']' && chars[index - 1] == '[') {
				index -= 1;
			} else if (c == '}' && chars[index - 1] == '{') {
				index -= 1;
			} else {
				return false;
			}
		}
		return index == 0;
	}
	

}
