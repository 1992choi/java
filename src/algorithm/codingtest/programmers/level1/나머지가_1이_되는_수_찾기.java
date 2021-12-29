package algorithm.codingtest.programmers.level1;

// https://programmers.co.kr/learn/courses/30/lessons/87389
public class 나머지가_1이_되는_수_찾기 {

    public static int solution(int n) {
        int answer = 0;

        for (int i = 2; i < n; i++) {
            if (n % i == 1) {
                answer = i;
                break;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(10));
        System.out.println(solution(12));
    }
}
