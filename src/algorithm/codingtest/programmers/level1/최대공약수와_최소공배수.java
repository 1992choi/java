package algorithm.codingtest.programmers.level1;

import java.util.Arrays;

// https://programmers.co.kr/learn/courses/30/lessons/12940
public class 최대공약수와_최소공배수 {

    public static int[] solution(int n, int m) {
        int[] answer = new int[2];

        int max = Math.max(n, m);
        int min = Math.min(n, m);

        // 최대공약수
        for (int i = 1; i <= min; i++) {
            if (n % i == 0 && m % i == 0) {
                answer[0] = i;
            }
        }

        // 최소공배수
        for (int i = 1; i <= n * m; i++) {
            if (i % n == 0 && i % m == 0) {
                answer[1] = i;
                break;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(3, 12)));
        System.out.println(Arrays.toString(solution(2, 5)));
    }
}
