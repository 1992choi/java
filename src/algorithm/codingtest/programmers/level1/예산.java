package algorithm.codingtest.programmers.level1;

import java.util.Arrays;

// https://programmers.co.kr/learn/courses/30/lessons/12982
public class 예산 {

    public static int solution(int[] d, int budget) {
        int answer = 0;

        // 오름차순으로 정렬
        Arrays.sort(d);

        // 합계 계산
        int sum = 0;
        for (int i = 0; i < d.length; i++) {
            sum += d[i];

            if (sum <= budget) {
                answer++;
            } else {
                break;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[]{1, 3, 2, 5, 4}, 9));
        System.out.println(solution(new int[]{2, 2, 3, 3}, 10));
    }
}
