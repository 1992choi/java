package algorithm.codingtest.programmers.level2;

import java.util.Arrays;

// https://programmers.co.kr/learn/courses/30/lessons/12945
public class 피보나치_수 {

    public static int solution(int n) {
        long[] arr = new long[n + 1];
        arr[0] = 0;
        arr[1] = 1;

        for (int i = 2; i <= n; i++) {
            arr[i] = arr[i - 2] % 1234567 + arr[i - 1] % 1234567;
        }

        int answer = (int) (arr[n] % 1234567);
        return answer;

        /*
            - 반복문에서 '% 1234567' 연산을 사용한 이유.

            자료형의 크기에 제한이 있는 언어를 쓸 경우,
            (A + B) % C ≡ ( ( A % C ) + ( B % C) ) % C라는 성질을 이용해서
            매번 계산 결과에 1234567으로 나눈 나머지를 대신 넣는 것으로 int 범위 내에 항상 값이 존재함을 보장할 수 있다.
         */
    }

    public static void main(String[] args) {
        System.out.println(solution(3));
        System.out.println(solution(5));
    }
}
