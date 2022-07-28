package 牛客;

import java.util.ArrayList;

//https://www.nowcoder.com/practice/7edf70f2d29c4b599693dc3aaeea1d31?tpId=117&rp=1&ru=%2Fexam%2Foj&qru=%2Fexam%2Foj&sourceUrl=%2Fexam%2Foj%3Fpage%3D1%26pageSize%3D50%26search%3D%26tab%3D%25E7%25AE%2597%25E6%25B3%2595%25E7%25AF%2587%26topicId%3D117&difficulty=&judgeStatus=&tags=&title=&gioEnter=menu
public class _NC38_螺旋矩阵 {

    /*
    123
    456
    789
     */
    public ArrayList<Integer> print(int[][] matrix) {
        ArrayList<Integer> res = new ArrayList<>();
        if (matrix.length == 0) {
            return res;
        }
        int top = 0;
        int bottom = matrix.length - 1;
        int left = 0;
        int right = matrix[0].length - 1;
        while (top < (matrix.length + 1) / 2 && left < (matrix[0].length + 1) / 2) {
            // 左 -> 右
            for (int i = left; i <= right; i++) {
                res.add(matrix[top][i]);
            }
            // 上 -> 下
            for (int i = top + 1; i <= bottom; i++) {
                res.add(matrix[i][right]);
            }
            // 右 -> 左
            for (int i = right - 1; top != bottom && i >= left; i--) {
                res.add(matrix[bottom][i]);
            }
            // 下 -> 上
            for (int i = bottom - 1; left != right && i >= top + 1; i--) {
                res.add(matrix[i][left]);
            }
            top += 1;
            left += 1;
            bottom -= 1;
            right -= 1;
        }
        return res;
    }
}
