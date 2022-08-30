package algorithm.doit;

import java.util.*;
import java.util.stream.Collectors;

public class Doit008 {

    /*
        좋은 수 갯수 구하기
        : 주어진 배열 arr 중 2개의 수를 뽑아 더했을 때, 배열에 존재하는 값이면 그 수는 좋은 수라고 한다.
     */
    static int solution(int[] arr) {
        int answer = 0;
        List<Integer> list = Arrays.stream(arr)
                .boxed()
                .collect(Collectors.toList());

        for (int i = 0; i < arr.length - 1; i++) {
            breakPoint: for (int j = 1; j < arr.length; j++) {
                if (list.contains(arr[i] + arr[j])) {
                    answer++;
                    break breakPoint;
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println("Answer : " + solution(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10})); // Answer : 8
    }
}