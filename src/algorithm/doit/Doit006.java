package algorithm.doit;

public class Doit006 {

    /*
        자연수 n이 주어질 때,
        n을 나타내는 가짓수는?
        Ex)
        n=6 : 1+2+3, 6 => 2가지
        n=10 : 1+2+3+4+5, 10 => 2가지
        n=15 : 1+2+3+4+5, 4+5, 7+8, 15 => 4가지
     */
    static int solution(int n) {
        int answer = 0;

        for (int i = 1; i <= n; i++) {
            int sum = 0;
            for (int j = i; j <= n; j++) {
                sum += j;
                if (sum == n) {
                    answer++;
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println( "Answer : " + solution(6)); // Answer : 2
        System.out.println( "Answer : " + solution(10)); // Answer : 2
        System.out.println( "Answer : " + solution(15)); // Answer : 4
    }
}