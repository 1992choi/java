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


        * 구간합을 미리 구하지 않을 경우, 매번 주어진 구간(range)에 대하여 더하는 작업을 반복해야하므로 비효율적이다.
          따라서 구간합을 미리 구하고 이를 사용하게 될 경우, 시간 복잡도를 줄일 수 있다.
     */
    static long[] solution(int[] arr, int[][] range) {
        long[] answer = new long[range.length];

        // 구간 합 구하기
        long[] sumArr = new long[arr.length + 1];
        for (int i = 1; i <= arr.length; i++) {
            sumArr[i] = sumArr[i - 1] + arr[i - 1];
        }
        System.out.println(Arrays.toString(sumArr)); // [0, 5, 9, 12, 14, 15]

        // 주어진 range에 대응하는 값 구하기
        for (int i = 0; i < range.length; i++) {
            answer[i] = sumArr[range[i][1]] - sumArr[range[i][0] - 1];
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