package 牛客;

import java.util.LinkedList;

// https://www.nowcoder.com/practice/4c776177d2c04c2494f2555c9fcc1e49?tpId=117&tqId=37793&rp=1&ru=/exam/oj&qru=/exam/oj&sourceUrl=%2Fexam%2Foj%3Fpage%3D1%26pageSize%3D50%26search%3D%26tab%3D%25E7%25AE%2597%25E6%25B3%2595%25E7%25AF%2587%26topicId%3D117&difficulty=undefined&judgeStatus=undefined&tags=&title=
public class _NC90_包含min函数的栈 {

    private LinkedList<Integer> list = new LinkedList<Integer>();
    private int min = 0;
    public void push(int node) {
        if (list.isEmpty() || min > node) {
            min = node;
        }
        list.push(node);
    }

    public void pop() {
        if (list.isEmpty()) {
            return;
        }
        Integer top = list.pop();
        if (min == top) {
            if (list.isEmpty()) {
                return;
            }
            // 出栈的是最小元素，找出剩余元素的最小元素
            min = list.get(0);
            int size = list.size();
            for (int i = 1; i < size; i++) {
                if (min > list.get(i)) {
                    min = list.get(i);
                }
            }
        }

    }

    public int top() {
        return list.peek();
    }

    public int min() {
        return min;
    }
}
