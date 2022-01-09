package algorithm.codingtest.programmers.level2;

import java.util.Arrays;

// https://programmers.co.kr/learn/courses/30/lessons/70129
public class 이진_변환_반복하기 {

    public static int[] solution(String s) {
        int round = 0;
        int removeCnt = 0;

        while (!"1".equals(s)) {
            // 반복 횟수 증가
            round++;

            // 0제거
            int beforeLength = s.length();
            s = s.replaceAll("0", "");
            int afterLength = s.length();
            removeCnt += beforeLength - afterLength;

            // 이진 변환
            s = Integer.toBinaryString(afterLength);
        }

        return new int[]{round, removeCnt};
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution("110010101001")));
        System.out.println(Arrays.toString(solution("01110")));
        System.out.println(Arrays.toString(solution("1111111")));
    }
}
