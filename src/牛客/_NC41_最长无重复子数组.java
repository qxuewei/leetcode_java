package 牛客;

/*
给定一个长度为n的数组arr，返回arr的最长无重复元素子数组的长度，无重复指的是所有数字都不相同。
子数组是连续的，比如[1,3,5,7,9]的子数组有[1,3]，[3,5,7]等等，但是[1,3,7]不是子数组

数据范围：0\le arr.length \le 10^50≤arr.length≤10
5
 ，0 < arr[i] \le 10^50<arr[i]≤10
5

示例1
输入：
[2,3,4,5]
复制
返回值：
4
复制
说明：
[2,3,4,5]是最长子数组
示例2
输入：
[2,2,3,4,3]
复制
返回值：
3
复制
说明：
[2,3,4]是最长子数组
示例3
输入：
[9]
复制
返回值：
1
复制
示例4
输入：
[1,2,3,1,2,3,2,2]
复制
返回值：
3
复制
说明：
最长子数组为[1,2,3]
示例5
输入：
[2,2,3,4,8,99,3]
复制
返回值：
5
复制
说明：
最长子数组为[2,3,4,8,99]

https://www.nowcoder.com/practice/b56799ebfd684fb394bd315e89324fb4?tpId=117&rp=1&ru=%2Fexam%2Foj&qru=%2Fexam%2Foj&sourceUrl=%2Fexam%2Foj%3Fpage%3D1%26pageSize%3D50%26search%3D%26tab%3D%25E7%25AE%2597%25E6%25B3%2595%25E7%25AF%2587%26topicId%3D117&difficulty=&judgeStatus=&tags=&title=&gioEnter=menu
 */

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class _NC41_最长无重复子数组 {
    /**
     * [3,3,2,1,3,3,3,1]
     * 步骤1：滑动窗口， 用一个 Array 存储 窗口内的值
     * 步骤2：右节点前进,遇到有重复的（记录当前数组长度），收缩左节点直到再次无重复，
     * 继续重复步骤2
     * @param arr int整型一维数组 the array
     * @return int整型
     */
    public int maxLength (int[] arr) {
        // write code here
        if (arr.length == 0) {
            return 0;
        }
        int maxLenth = 0;
        int left = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int right = 0; right < arr.length; right++) {
            if (map.containsKey(arr[right])) {
                left = Math.max(left, map.get(arr[right]) + 1);
            }
            map.put(arr[right], right);
            maxLenth = Math.max(maxLenth, right - left + 1);
        }
        return maxLenth;
    }

    public int maxLengthQueue (int[] arr) {
        // write code here
        if (arr.length == 0) {
            return 0;
        }
        int maxLenth = 0;
        int right = 0;
        Queue<Integer> queue = new LinkedList<>();
        for (int c : arr) {
            while (queue.contains(c)) {
                queue.poll();
            }
            queue.add(c);
            maxLenth = Math.max(maxLenth, queue.size());
        }
        return maxLenth;
    }
}
