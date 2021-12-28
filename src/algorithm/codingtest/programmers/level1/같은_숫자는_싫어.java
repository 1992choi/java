package algorithm.codingtest.programmers.level1;

import java.util.ArrayList;
import java.util.Arrays;

// https://programmers.co.kr/learn/courses/30/lessons/12906
public class 같은_숫자는_싫어 {

    public static int[] solution(int[] arr) {
        int prevNum = -1;
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            if (prevNum != arr[i]) {
                list.add(arr[i]);
            }
            prevNum = arr[i];
        }

        int[] answer = new int[list.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[]{1, 1, 3, 3, 0, 1, 1})));
        System.out.println(Arrays.toString(solution(new int[]{4, 4, 4, 3, 3})));
    }
}
