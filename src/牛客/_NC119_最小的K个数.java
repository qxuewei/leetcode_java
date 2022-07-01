package 牛客;

import java.util.ArrayList;
import java.util.Random;

/*
描述
给定一个长度为 n 的可能有重复值的数组，找出其中不去重的最小的 k 个数。例如数组元素是4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4(任意顺序皆可)。
数据范围：0\le k,n \le 100000≤k,n≤10000，数组中每个数的大小0 \le val \le 10000≤val≤1000
要求：空间复杂度 O(n)O(n) ，时间复杂度 O(nlogn)O(nlogn)

示例1
输入：
[4,5,1,6,2,7,3,8],4
复制
返回值：
[1,2,3,4]
复制
说明：
返回最小的4个数即可，返回[1,3,2,4]也可以
示例2
输入：
[1],0
复制
返回值：
[]
复制
示例3
输入：
[0,1,2,1,2],3
复制
返回值：
[0,1,1]

https://www.nowcoder.com/practice/6a296eb82cf844ca8539b57c23e6e9bf?tpId=117&rp=1&ru=%2Fexam%2Foj&qru=%2Fexam%2Foj&sourceUrl=%2Fexam%2Foj%3Ftab%3D%25E7%25AE%2597%25E6%25B3%2595%25E7%25AF%2587%26topicId%3D117&difficulty=&judgeStatus=&tags=&title=&gioEnter=menu
 */
public class _NC119_最小的K个数 {
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        quick(input, 0, input.length - 1);
        ArrayList<Integer> res = new ArrayList<Integer>(k);
        for (int i = 0; i < k; i++) {
            res.add(input[i]);
        }
        return res;
    }

    private void quick(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }
        int poivt = getPoivt(nums, left, right);
        quick(nums, left, poivt - 1);
        quick(nums, poivt + 1, right);
    }

    private int getPoivt(int[] nums, int left, int right) {
        int i = left;
        int randomIndex = new Random().nextInt(right - left + 1) + left;
        swap(nums, randomIndex, right);
        for (int j = left; j < right; j++) {
            if (nums[j] < nums[right]) {
                if (i != j) {
                    swap(nums, i, j);
                }
                i += 1;
            }
        }
        swap(nums, i, right);
        return i;
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    // [4,5,1,6,2,7,2,8]
    public static void main(String[] args) {
        int [] input = new int[8];
        input[0] = 4;
        input[1] = 5;
        input[2] = 1;
        input[3] = 6;
        input[4] = 2;
        input[5] = 7;
        input[6] = 2;
        input[7] = 8;

        new _NC119_最小的K个数().quick(input, 0, input.length - 1);

        for (int i = 0; i < input.length; i++) {
            System.out.println(input[i]);
        }

    }
}
