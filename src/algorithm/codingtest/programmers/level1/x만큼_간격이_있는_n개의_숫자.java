package algorithm.codingtest.programmers.level1;

import java.util.Arrays;

// https://programmers.co.kr/learn/courses/30/lessons/12954
public class x만큼_간격이_있는_n개의_숫자 {

    public static long[] solution(int x, int n) {
        long[] answer = new long[n];
        long prevVal = x;

        for (int i = 0; i < n; i++) {
            answer[i] = prevVal;
            prevVal += x;
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(2, 5)));
        System.out.println(Arrays.toString(solution(4, 3)));
        System.out.println(Arrays.toString(solution(-4, 2)));
    }
}
