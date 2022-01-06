package algorithm.codingtest.programmers.level2;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

// https://programmers.co.kr/learn/courses/30/lessons/42626
public class 더_맵게 {

    public static int solution(int[] scoville, int K) {
        List<Integer> list = Arrays.stream(scoville).boxed().collect(Collectors.toList());
        int answer = 0;

        while (true) {
            Collections.sort(list);

            if (list.get(0) < K && list.size() == 1) {
                answer = -1;
                break;
            } else if (list.get(0) < K) {
                int sum = list.get(0) + list.get(1) * 2;
                list.remove(0); // 덧셈으로 사용된 첫 번째 항목 제거
                list.remove(0); // 덧셈으로 사용된 두 번째 항목 제거(첫 번째 항목이 제거되어 index가 0으로 변경됨)
                list.add(0, sum);
            } else {
                break;
            }

            answer++;
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[]{1, 2, 3, 9, 10, 12}, 7));
    }
}
