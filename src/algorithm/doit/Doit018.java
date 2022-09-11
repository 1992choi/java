package algorithm.doit;

import java.util.Arrays;

public class Doit018 {

    /*
        ATM 인출 시간 계산하기
            - ATM에 p1~pN까지 N명이 줄을 서 있을 때,
              각 각의 사람이 돈을 뽑는데 걸리는 시간은 아래와 같이 표현한다.
              P1=3
              P2=1
              P3=4
              P4=3
              P5=2

              이 때 P1, P2, P3, P4, P5로 줄을 선다면
              1번이 인출하는데 걸리는 시간은 3분
              2번이 인출하는데 걸리는 시간은 4분 (1번이 뽑는 시간=3 + 자기 자신=1)
              3번이 인출하는데 걸리는 시간은 8분
              4번이 인출하는데 걸리는 시간은 11분
              5번이 인출하는데 걸리는 시간은 13분
              즉 모든 사람이 돈을 뽑는데 기다린 시간의 합은 3 + 4 + 8 + 11 + 13 = 39분이다.

              만약 P2, P5, P1, P4, P3으로 줄을 선다면
              각 각 1 + 3 + 6 + 9 + 13으로 32분이다.

              위의 상황을 고려할 때 가장 짧은 시간 구하기
     */
    static int solution(int[] arr) {
        int answer = 0;

        Arrays.sort(arr);

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j <= i; j++) {
                answer += arr[j];
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println("Answer : " + solution(new int[]{3, 1, 4, 3, 2})); // Answer : 32
    }
}