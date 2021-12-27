package algorithm.codingtest.programmers.level1;

import java.util.Arrays;
import java.util.Collections;

// https://programmers.co.kr/learn/courses/30/lessons/12917
public class 문자열_내림차순으로_배치하기 {

    public static String solution(String s) {
        String[] arr = s.split("");
        Arrays.sort(arr, Collections.reverseOrder());
        return String.join("", arr);
    }

    public static void main(String[] args) {
        System.out.println(solution("Zbcdefg"));
    }
}
