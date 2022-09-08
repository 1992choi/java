package algorithm.doit;

import java.util.Arrays;

public class Doit015 {

    /*
        수 정렬하기
          - N개의 수가 주어졌을 때, 오름차순으로 정렬 (단, 버블정렬 사용하기)
     */
    static String solution(int[] num) {
        for (int i = 0; i < num.length; i++) {
            for (int j = num.length - 1; j > i; j--) {
                if (num[j - 1] > num[j]) {
                    int tmp = num[j];
                    num[j] = num[j - 1];
                    num[j - 1] = tmp;
                }
            }
        }

        return Arrays.toString(num);
    }

    public static void main(String[] args) {
        System.out.println("Answer : " + solution(new int[]{5, 2, 3, 4, 1})); // Answer : [1, 2, 3, 4, 5]
        System.out.println("Answer : " + solution(new int[]{1, 2, 7, 3, 9, 5, 6, 4, 8})); // Answer : [1, 2, 3, 4, 5, 6, 7, 8, 9]
    }
}