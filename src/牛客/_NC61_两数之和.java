package 牛客;

import java.util.HashMap;

/*
描述
给出一个整型数组 numbers 和一个目标值 target，请在数组中找出两个加起来等于目标值的数的下标，返回的下标按升序排列。
（注：返回的数组下标从1开始算起，保证target一定可以由数组里面2个数字相加得到）

数据范围：2\leq len(numbers) \leq 10^52≤len(numbers)≤10
5
 ，-10 \leq numbers_i \leq 10^9−10≤numbers
i
​
 ≤10
9
 ，0 \leq target \leq 10^90≤target≤10
9

要求：空间复杂度 O(n)O(n)，时间复杂度 O(nlogn)O(nlogn)
示例1
输入：
[3,2,4],6
复制
返回值：
[2,3]
复制
说明：
因为 2+4=6 ，而 2的下标为2 ， 4的下标为3 ，又因为 下标2 < 下标3 ，所以返回[2,3]
示例2
输入：
[20,70,110,150],90
复制
返回值：
[1,2]
复制
说明：
20+70=90

https://www.nowcoder.com/practice/20ef0972485e41019e39543e8e895b7f?tpId=117&tags=&title=&difficulty=0&judgeStatus=0&rp=1&sourceUrl=%2Fexam%2Foj%3Fpage%3D1%26pageSize%3D50%26search%3D%26tab%3D%25E7%25AE%2597%25E6%25B3%2595%25E7%25AF%2587%26topicId%3D117
 */
public class _NC61_两数之和 {
    /**
     *
     * @param numbers int整型一维数组
     * @param target int整型
     * @return int整型一维数组
     */
    public int[] twoSum (int[] numbers, int target) {
        int[] res = new int[2];
        if (numbers.length < 2) {
            return res;
        }
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < numbers.length; i++) {
            int targetKey = target - numbers[i];
            if (map.containsKey(targetKey)) {
                Integer preIndex = map.get(targetKey);
                res[0] = preIndex + 1;
                res[1] = i + 1;
                break;
            } else {
                map.put(numbers[i], i);
            }
        }
        return res;
    }
}
