package algorithm.codingtest.programmers.level1;

import java.util.Arrays;

// https://programmers.co.kr/learn/courses/30/lessons/12933
public class 정수_내림차순으로_배치하기 {

    public static long solution(long n) {
        char[] ch = String.valueOf(n).toCharArray();
        Arrays.sort(ch);

        return Long.parseLong(new StringBuffer(String.valueOf(ch)).reverse().toString());
    }

    public static void main(String[] args) {
        System.out.println(solution(118372));
    }
}
