package algorithm.codingtest.programmers.level1;

// https://programmers.co.kr/learn/courses/30/lessons/77884
public class 약수의_개수와_덧셈 {

    public static int solution(int left, int right) {
        int answer = 0;

        for (int i = left; i <= right; i++) {
            int cnt = 0;
            for (int j = 1; j <= i; j++) {
                if (i % j == 0) {
                    cnt++;
                }
            }

            answer += cnt % 2 == 0 ? i : -i;
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(13, 17));
        System.out.println(solution(24, 27));
    }
}
