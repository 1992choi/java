package algorithm.codingtest.programmers.level1;

// https://programmers.co.kr/learn/courses/30/lessons/12934
public class 정수_제곱근_판별 {

    public static long solution(long n) {
        long answer = 0;
        double base = Math.sqrt(n);
        if (base % 1 > 0) {
            answer = -1;
        } else {
            answer = (long) Math.pow(base + 1, 2);
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(121));
        System.out.println(solution(3));
    }
}
