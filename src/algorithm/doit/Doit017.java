package algorithm.doit;

import java.util.Arrays;

public class Doit017 {

    /*
        내림차순으로 자릿수 정렬하기
            - 배열 arr이 주어졌을 때, 내림차순으로 정렬하기
              단, 선택정렬 사용
     */
    static int[] solution(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int maxIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] > arr[maxIndex]) {
                    maxIndex = j;
                }
            }

            int tmp = arr[i];
            arr[i] = arr[maxIndex];
            arr[maxIndex] = tmp;
        }

        return arr;
    }

    public static void main(String[] args) {
        System.out.println("Answer : " + Arrays.toString(solution(new int[]{2, 1, 4, 3}))); // Answer : [1, 2, 3, 4]
        System.out.println("Answer : " + Arrays.toString(solution(new int[]{7, 8, 2, 5, 1, 6, 4, 3, 9}))); // Answer : [1, 2, 3, 4]
    }
}