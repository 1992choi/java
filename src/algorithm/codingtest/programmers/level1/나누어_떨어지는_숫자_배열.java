package algorithm.codingtest.programmers.level1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// https://programmers.co.kr/learn/courses/30/lessons/12910
public class 나누어_떨어지는_숫자_배열 {

    public static int[] solution(int[] arr, int divisor) {
        List<Integer> divList = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % divisor == 0) {
                divList.add(arr[i]);
            }
        }

        int[] answer = {};
        if (divList.size() != 0) {
            answer = new int[divList.size()];
            for (int i = 0; i < divList.size(); i++) {
                answer[i] = divList.get(i);
            }
            Arrays.sort(answer);
        } else {
            answer = new int[]{-1};
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[]{5, 9, 7, 10}, 5)));
        System.out.println(Arrays.toString(solution(new int[]{2, 36, 1, 3}, 1)));
        System.out.println(Arrays.toString(solution(new int[]{3, 2, 6}, 10)));
    }
}
