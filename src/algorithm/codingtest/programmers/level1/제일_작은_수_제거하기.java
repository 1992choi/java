package algorithm.codingtest.programmers.level1;

import java.util.Arrays;

// https://programmers.co.kr/learn/courses/30/lessons/12935
public class 제일_작은_수_제거하기 {

    public static int[] solution(int[] arr) {
        int[] answer = {};

        if (arr.length <= 1) {
            answer = new int[]{-1};
        } else {
            answer = new int[arr.length - 1];

            // 작은 수 찾기
            int min = 99999999;
            for (int i = 0; i < arr.length; i++) {
                if (min > arr[i]) {
                    min = arr[i];
                }
            }

            // 작은 수 제외하고 추출
            int answerIdx = 0;
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] != min) {
                    answer[answerIdx++] = arr[i];
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[]{4, 3, 2, 1})));
        System.out.println(Arrays.toString(solution(new int[]{10})));
    }
}
