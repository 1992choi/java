package algorithm.codingtest.programmers.level2;

// https://programmers.co.kr/learn/courses/30/lessons/12949
public class 행렬의_곱셈 {

    public static int[][] solution(int[][] arr1, int[][] arr2) {
        int row = arr1.length;
        int col = arr2[0].length;

        int[][] answer = new int[row][col];

        if (arr1[0].length == arr2.length) {
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    int value = 0;
                    for (int k = 0; k < arr1[i].length; k++) {
                        value += arr1[i][k] * arr2[k][j];
                    }
                    answer[i][j] = value;
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        solution(new int[][]{{1, 4}, {3, 2}, {4, 1}}, new int[][]{{3, 3}, {3, 3}});
        solution(new int[][]{{2, 3, 2}, {4, 2, 4}, {3, 1, 4}}, new int[][]{{5, 4, 3}, {2, 4, 1}, {3, 1, 1}});
    }
}
