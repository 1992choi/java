package algorithm.doit;

import java.util.*;

public class Doit014 {

    /*
        절대값 힙 구현하기
          1) 정수를 담은 배열 nums가 주어진다.
          2) 정수가 0이 아닐 경우, 절댓값 힙에 담는다.
          2) 정수가 0인 경우 절대값 힙에서 절댓값이 가장 작은 수를 출력 후 그 값을 제거한다. (* 힙이 비어있는 경우 0 출력)
             만약 절대값이 가장 작은 값이 여러 개일 경우, 가장 작은 수를 제거한다.
     */
    static String solution(int[] nums) {
        String answer = "";
        List<Integer> heap = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                if (heap.size() == 0) {
                    answer += "0 ";
                } else {
                    int minValue = heap.stream().mapToInt(x -> Math.abs(x)).min().getAsInt();
                    if (heap.contains(minValue * -1)) {
                        answer += "-" + minValue + " ";
                        heap.remove(new Integer(minValue * -1));
                    } else {
                        answer += minValue + " ";
                        heap.remove(new Integer(minValue));
                    }
                }
            } else {
                heap.add(nums[i]);
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println("Answer : " + solution(new int[]{1, -1, 0, 0, 0, 1, 1, -1, -1, 2, -2, 0, 0, 0, 0, 0, 0, 0}));
        // Answer : -1 1 0 -1 -1 1 1 -2 2 0
    }
}