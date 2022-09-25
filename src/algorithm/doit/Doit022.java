package algorithm.doit;

import java.util.Arrays;

public class Doit022 {

    /*
        수 정렬하기 3
          - N개의 수가 주어졌을 때, 오름차순으로 정렬 (단, 기수정렬 사용하기)
     */
    static int[] solution(int[] arr) {
        int maxSize = 5;
        int[] output = new int[arr.length];
        int jarisu = 1;
        int count = 0;
        while (count != maxSize) { // 최대 자릿수만큼 반복하기
            int[] bucket = new int[10];
            for (int i = 0; i < arr.length; i++) {
                bucket[(arr[i] / jarisu) % 10]++; // 일의 자리부터 시작
            }

            for (int i = 1; i < 10; i++) { // 합 배열을 이용해 index 계산
                bucket[i] += bucket[i - 1];
            }

            for (int i = arr.length - 1; i >= 0; i--) { // 현재 자릿수를 기준으로 정렬
                output[bucket[arr[i] / jarisu % 10] - 1] = arr[i];
                bucket[(arr[i] / jarisu) % 10]--;
            }

            for (int i = 0; i < arr.length; i++) { // 다음 자릿수를 이동하기 위해 현재 자릿수 기준 정렬 데이터 저장
                arr[i] = output[i];
            }

            jarisu *= 10;
            count++;
        }

        return output;
    }

    public static void main(String[] args) {
        System.out.println("Answer : " + Arrays.toString(
                solution(new int[]{215, 15, 344, 372, 294, 100, 8, 145, 24, 198, 831})
        )); // Answer : [8, 15, 24, 100, 145, 198, 215, 294, 344, 372, 831]
    }
}