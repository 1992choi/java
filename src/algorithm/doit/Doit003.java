package algorithm.doit;

import java.util.Arrays;

public class Doit003 {

    /*
        arr : 구간 합을 구할 대상 배열
        range : 영역
                Ex) range = {
                                {1, 3},
                                {2, 4},
                                {5, 5}
                            }
                            ->  배열 중 1 ~ 3의 합,
                                배열 중 2 ~ 4의 합,
                                배열 중 5 ~ 5의 합
     */
    static long[] solution(int[] arr, int[][] range) {
        long[] answer = new long[range.length];

        // 구간 합 구하기
        long[] sumArr = new long[arr.length];
        long sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            sumArr[i] = sum;
        }
        System.out.println(Arrays.toString(sumArr)); // [5, 9, 12, 14, 15]

        // 주어진 range에 대응하는 값 구하기
        for (int i = 0; i < range.length; i++) {
            answer[i] = sumArr[range[i][1] - 1] - sumArr[range[i][0] - 1] + arr[range[i][0] - 1];
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println( "Answer : " +
                Arrays.toString(
                        solution(new int[]{5, 4, 3, 2, 1}, new int[][]{{1, 3}, {2, 4}, {5, 5}})
                )
        ); // Answer : [12, 9, 1]
    }
}