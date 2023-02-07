package 数组;

// https://leetcode.cn/problems/single-number/?favorite=2cktkvj
public class _136_只出现一次的数字 {
    public int singleNumber(int[] nums) {
        int single = 0;
        // 异或： 任何数跟0异或结果是自身、任何数跟自身异或结果是0
        for (int num : nums) {
            single ^= num;
        }
        return single;
    }
}
