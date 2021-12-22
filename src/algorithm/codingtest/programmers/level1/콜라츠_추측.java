package algorithm.codingtest.programmers.level1;

import java.util.Arrays;

// https://programmers.co.kr/learn/courses/30/lessons/12943
public class 콜라츠_추측 {

    public static int solution(int num) {
        int answer = 0;

        while (true) {
            if (num == 1) {
                answer = 0;
                break;
            } else if (num % 2 == 0) {
                num /= 2;
            } else if (num % 2 == 1) {
                num = num * 3 + 1;
            }

            answer++;

            if (num == 1) {
                break;
            } else if (answer >= 500) {
                answer = -1;
                break;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(6));
        System.out.println(solution(16));
        System.out.println(solution(626331));
    }
}
