package algorithm.codingtest.programmers.level1;

import java.util.ArrayList;
import java.util.List;

// https://programmers.co.kr/learn/courses/30/lessons/12921
public class 소수_찾기 {

    public static int solution(int n) {
        int answer = 0;

        for (int i = 1; i <= n; i++) {
            int cnt = 0;
            for (int j = 2; j <= i; j++) {
                if (i % j == 0) {
                    cnt++;
                }
            }

            if (cnt == 1) {
                answer++;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(10));
        System.out.println(solution(4));
    }
}
