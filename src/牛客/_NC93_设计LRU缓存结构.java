package 牛客;
/*
描述
设计LRU(最近最少使用)缓存结构，该结构在构造时确定大小，假设大小为 capacity ，操作次数是 n ，并有如下功能:
1. Solution(int capacity) 以正整数作为容量 capacity 初始化 LRU 缓存
2. get(key)：如果关键字 key 存在于缓存中，则返回key对应的value值，否则返回 -1 。
3. set(key, value)：将记录(key, value)插入该结构，如果关键字 key 已经存在，则变更其数据值 value，如果不存在，则向缓存中插入该组 key-value ，如果key-value的数量超过capacity，弹出最久未使用的key-value

提示:
1.某个key的set或get操作一旦发生，则认为这个key的记录成了最常使用的，然后都会刷新缓存。
2.当缓存的大小超过capacity时，移除最不经常使用的记录。
3.返回的value都以字符串形式表达，如果是set，则会输出"null"来表示(不需要用户返回，系统会自动输出)，方便观察
4.函数set和get必须以O(1)的方式运行
5.为了方便区分缓存里key与value，下面说明的缓存里key用""号包裹
数据范围:
1\leq capacity<=10^51≤capacity<=10
5

0\leq key,val \leq 2\times 10^9 \0≤key,val≤2×10
9

1\leq n\leq 10^51≤n≤10
5

 */

import java.util.HashMap;
import java.util.Map;

public class _NC93_设计LRU缓存结构 {

    class LRUNode {
        int key;
        int val;
        LRUNode pre;
        LRUNode next;

        LRUNode(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    int size = 0;
    int capacity = 0;
    Map<Integer, LRUNode> map;
    LRUNode head = null;
    LRUNode tail = null;

    public _NC93_设计LRU缓存结构(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        makeRecently(key);
        return map.get(key).val;
    }

    public void set(int key, int value) {
        if (map.containsKey(key)) {
            map.get(key).val = value;
            makeRecently(key);
            return;
        }

        // 如果超限
        if (size == capacity) {
            // 移除最后节点
            map.remove(tail.key);
            tail = tail.pre;
            tail.next = null;
            size -= 1;
        }

        LRUNode node = new LRUNode(key, value);
        if (head == null) {
            head = node;
            tail = head;
        } else {
            node.next = head;
            head.pre = node;
            head = node;
        }
        map.put(key, head);
        size += 1;
    }

    private void makeRecently(int key) {
        LRUNode cur = map.get(key);
        if (cur == head) {
            return;
        }
        // 删除以前节点
        if (cur == tail) {
            tail = tail.pre;
            tail.next = null;
        } else {
            cur.pre.next = cur.next;
            cur.next.pre = cur.pre;
        }

        // 移到最前
        cur.pre = null;
        cur.next = head;
        head.pre = cur;
        head = cur;
    }
}
