package algorithm.doit;

import java.util.Arrays;

public class Doit020 {

    /*
        수 정렬하기 2
            - N개의 수가 주어졌을 때, 이를 오름차순 정렬하는 프로그램을 작성하시오
     */
    static int[] solution(int[] arr) {
        Arrays.sort(arr);
        return arr;
    }

    public static void main(String[] args) {
        System.out.println("Answer : " + Arrays.toString(solution(new int[]{5, 4, 3, 2, 1}))); // Answer : [1, 2, 3, 4, 5]
    }
}