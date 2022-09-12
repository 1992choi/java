package algorithm.doit;

import java.util.Arrays;

public class Doit019 {

    /*
        K번째 수 구하기
            - 수 N개(A1, A2, A3 ...)가 주어졌을 때,
              오름차순으로 정렬 후 앞에서부터 K번째 수 구하기
     */
    static int solution(int[] arr, int k) {
        Arrays.sort(arr);
        return arr[k - 1];
    }

    public static void main(String[] args) {
        System.out.println("Answer : " + solution(new int[]{4, 1, 2, 3, 5}, 2)); // Answer : 2
    }
}