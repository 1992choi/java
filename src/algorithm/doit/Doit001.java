package algorithm.doit;

public class Doit001 {

    static int solution(int count, String str) {
        int answer = 0;
        for (int i = 0; i < count; i++) {
            // answer += Integer.parseInt(String.valueOf(str.charAt(i)));
            answer += str.charAt(i) - '0';
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(1, "1")); // 1
        System.out.println(solution(5, "54321")); // 15
        System.out.println(solution(25, "7000000000000000000000000")); // 7
        System.out.println(solution(11, "10987654321")); // 46
    }
}