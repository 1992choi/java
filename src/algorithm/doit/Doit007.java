package algorithm.doit;

import java.util.ArrayList;
import java.util.List;

public class Doit007 {

    /*
        재료가 들어있는 배열 arr과 갑옷을 만들 수 있는 고유번호 n이 주어졌을 때,
        재료 2개를 합성(재료 2개를 뽑았을 때의 n이 되어야함)하여 만들 수 있는 갑옷의 갯수 구하기

        Ex) arr=2, 7, 4, 1, 5, 3
            n=9

            (2, 7), (4, 5) => 2가지
     */
    static int solution(int[] arr, int n) {
        List<String> list = new ArrayList<>();
        int answer = 0;

        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] == 0) {
                continue;
            }
            for (int j = 0; j < arr.length; j++) {
                if (arr[j] == 0) {
                    continue;
                }
                if (arr[i] + arr[j] == n) {
                    list.add(arr[i] + "+" + arr[j]);
                    answer++;
                    arr[i] = 0;
                    arr[j] = 0;
                }
            }
        }
        System.out.println(list); // [2+7, 4+5]

        return answer;
    }

    public static void main(String[] args) {
        System.out.println( "Answer : " + solution(new int[]{2, 7, 4, 1, 5, 3}, 9)); // Answer : 2
    }
}