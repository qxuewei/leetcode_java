package 牛客;
// https://www.nowcoder.com/practice/31c1aed01b394f0b8b7734de0324e00f?tpId=117&tqId=37802&rp=1&ru=/exam/oj&qru=/exam/oj&sourceUrl=%2Fexam%2Foj%3Fpage%3D1%26pageSize%3D50%26search%3D%26tab%3D%25E7%25AE%2597%25E6%25B3%2595%25E7%25AF%2587%26topicId%3D117&difficulty=undefined&judgeStatus=undefined&tags=&title=
public class _NC128_接雨水问题 {
    public long maxWater(int[] arr) {
        if (arr.length == 0) {
            return 0;
        }
        int left = 0;
        int right = arr.length - 1;
        int maxL = 0;
        int maxR = 0;
        int res = 0;
        while (left < right) {
            maxL = Math.max(maxL, arr[left]);
            maxR = Math.max(maxR, arr[right]);
            if (maxR > maxL) {
                res += maxL - arr[left++];
            } else {
                res += maxR - arr[right--];
            }
        }
        return res;
    }
}
