package 牛客;

/*
描述
给定一个长度为 n 的数组，请你编写一个函数，返回该数组按升序排序后的结果。

数据范围： 0 \le n \le 1\times10^30≤n≤1×10
3
 ，数组中每个元素都满足 0 \le val \le 10^90≤val≤10
9

要求：时间复杂度 O(n^2)O(n
2
 )，空间复杂度 O(n)O(n)
进阶：时间复杂度 O(nlogn)O(nlogn)，空间复杂度 O(n)O(n)

注：本题数据范围允许绝大部分排序算法，请尝试多种排序算法的实现。
示例1
输入：
[5,2,3,1,4]
复制
返回值：
[1,2,3,4,5]
复制
示例2
输入：
[5,1,6,2,5]
复制
返回值：
[1,2,5,5,6]
 */

import java.util.Random;

public class _NC140_排序 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * 将给定数组排序
     * @param arr int整型一维数组 待排序的数组
     * @return int整型一维数组
     */
    public int[] MySort (int[] arr) {
//        return chooseSort(arr);
        quickSort(arr, 0, arr.length - 1);
        return arr;
    }

    // 快排
    public void quickSort (int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }
        int pivot = pivotIndex(arr, left, right);
        quickSort(arr, left, pivot - 1);
        quickSort(arr, pivot + 1, right);
    }
    // 随机
    // [4, 1, 2, 3]
    // [4, 1, 3, 2]
    // [4, 1, 3, 2]
    // [1, 2, 3, 4]

    private int pivotIndex(int[] arr, int left, int right) {
        int i = left;
        int randomIndex = new Random().nextInt(right - left + 1) + left;
        swap(arr, randomIndex, right);
        for (int j = left; j < right; j++) {
            if (arr[j] < arr[right]) {
                // 找到第一个比目标值小的坐标
                if (i != j) {
                    swap(arr, i, j);
                }
                // 有一个则 i 加 1
                i += 1;
            }
        }
        swap(arr, i, right);
        return i;
    }

    private void swap(int[] arr, int left, int right) {
        int tmp = arr[left];
        arr[left] = arr[right];
        arr[right] = tmp;
    }

    // 选择
    public int[] chooseSort (int[] arr) {
        for (int i = arr.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[i]) {
                    int tmp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = tmp;
                }
            }
        }
        return arr;
    }

    private void swapArr(int[] arr, int index1, int index2) {
        int tmp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = tmp;
    }
    // [5,2,3,1,4]
    // 插入 - 把后者插入前面排序好的合适位置
    private int[] insert(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i]) {
                    swapArr(arr, j, i);
                }
            }
        }
        return arr;
    }

    // 冒泡 - 两两比较，大的右移
    private int[] bublle(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    swapArr(arr, j, j + 1);
                }
            }
        }
        return arr;
    }

    // 选择 - 排序好的放左边，没排序的把最小的跟第一个交换

    private int[] choose(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            swapArr(arr, i, minIndex);
        }
        return arr;
    }

}
