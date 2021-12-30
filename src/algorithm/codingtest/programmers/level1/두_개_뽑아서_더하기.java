package algorithm.codingtest.programmers.level1;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;

// https://programmers.co.kr/learn/courses/30/lessons/68644
public class 두_개_뽑아서_더하기 {

    public static int[] solution(int[] numbers) {
        HashSet<Integer> set = new HashSet<Integer>();

        for (int i = 0; i < numbers.length - 1; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                set.add(numbers[i] + numbers[j]);
            }

        }

        int[] answer = new int[set.size()];
        Iterator<Integer> it = set.iterator();

        int idx = 0;
        while(it.hasNext()) {
            answer[idx] = it.next();
            idx++;
        }

        Arrays.sort(answer);

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[]{2, 1, 3, 4, 1})));
        System.out.println(Arrays.toString(solution(new int[]{5, 0, 2, 7})));
    }
}
