package algorithm.codingtest.programmers.level2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// https://programmers.co.kr/learn/courses/30/lessons/42586
public class 기능개발 {

    public static int[] solution(int[] progresses, int[] speeds) {
        int[] successDay = new int[progresses.length]; // 작업이 완료되는 일수
        int successCnt = 0; // 완료된 작업의 갯수
        int day = 1;

        // 각 각의 작업이 완료되기까지 걸리는 시간 구하기
        while (successCnt != progresses.length) {
            successCnt = 0;
            for (int i = 0; i < progresses.length; i++) {
                progresses[i] += speeds[i];
                if (progresses[i] >= 100) {
                    successCnt++;
                    if (successDay[i] == 0) {
                        successDay[i] = day;
                    }
                }
            }
            day++;
        }

        // 배포하기
        List<Integer> list = new ArrayList<>();
        int prevVal = successDay[0];
        int cnt = 0;
        for (int i = 1; i < successDay.length; i++) {
            cnt++;
            if (prevVal < successDay[i]) { // 배포
                list.add(cnt);
                prevVal = successDay[i];
                cnt = 0;
            }
        }
        list.add(cnt + 1); // 나머지 작업 배포

        return list.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[]{93, 30, 55}, new int[]{1, 30, 5})));
        System.out.println(Arrays.toString(solution(new int[]{95, 90, 99, 99, 80, 99}, new int[]{1, 1, 1, 1, 1, 1})));
    }
}
