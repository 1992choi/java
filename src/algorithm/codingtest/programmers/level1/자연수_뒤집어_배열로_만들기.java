package algorithm.codingtest.programmers.level1;

import java.util.Arrays;

// https://programmers.co.kr/learn/courses/30/lessons/12932
public class 자연수_뒤집어_배열로_만들기 {

    public static int[] solution(long n) {
        char[] ch = new StringBuffer(String.valueOf(n)).reverse().toString().toCharArray();
        int[] answer  = new int[ch.length];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = ch[i] - 48;
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(12345)));
    }
}
