package 牛客;

import java.util.ArrayList;
import java.util.Arrays;

// https://www.nowcoder.com/practice/345e2ed5f81d4017bbb8cc6055b0b711?tpId=117&tags=&title=&difficulty=0&judgeStatus=0&rp=1&sourceUrl=%2Fexam%2Foj%3Fpage%3D1%26pageSize%3D50%26search%3D%26tab%3D%25E7%25AE%2597%25E6%25B3%2595%25E7%25AF%2587%26topicId%3D117
public class _NC54_三数之和 {
    public ArrayList<ArrayList<Integer>> threeSum(int[] nums) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if (nums.length < 3) {
            return res;
        }
        // 排序
        Arrays.sort(nums);
        int left = 0;
        int right = 0;
        int lastIndex = nums.length - 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                return res;
            }
            if (i > 0 && nums[i] == nums[i - 1]) {
                // 去掉重复的解
                continue;
            }
            int target = 0 - nums[i];
            left = i + 1;
            right = lastIndex;
            while (left < right) {
                int sum = nums[left] + nums[right];
                if (sum == target) {
                    ArrayList<Integer> sub = new ArrayList<>();
                    sub.add(nums[i]);
                    sub.add(nums[left]);
                    sub.add(nums[right]);
                    res.add(sub);
                    while (left < right && nums[left] == nums[left + 1]) {
                        left += 1;
                    }
                    while (left < right && nums[right - 1] == nums[right]) {
                        right -= 1;
                    }
                    left += 1;
                    right -= 1;
                } else if (sum < target) {
                    left += 1;
                } else if (sum > target) {
                    right -= 1;
                }
            }
        }
        return res;
    }
}
