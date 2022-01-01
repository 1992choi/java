package algorithm.codingtest.programmers.level1;

import java.util.ArrayList;
import java.util.List;

// https://programmers.co.kr/learn/courses/30/lessons/1845
public class 폰켓몬 {

    public static int solution(int[] nums) {
        List<Integer> selectList = new ArrayList<>();
        int answer = 0;

        for (int i = 0; i < nums.length; i++) {
            if (!selectList.contains(nums[i])) {
                selectList.add(nums[i]);
                answer++;
            }

            if (answer >= nums.length / 2) {
                break;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[]{3, 1, 2, 3}));
        System.out.println(solution(new int[]{3, 3, 3, 2, 2, 4}));
        System.out.println(solution(new int[]{3, 3, 3, 2, 2, 2}));
    }
}
