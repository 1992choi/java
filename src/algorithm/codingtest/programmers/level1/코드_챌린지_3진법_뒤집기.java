package algorithm.codingtest.programmers.level1;

// https://programmers.co.kr/learn/courses/30/lessons/68935
public class 코드_챌린지_3진법_뒤집기 {

    public static int solution(int n) {
        int answer = 0;
        StringBuffer sb = new StringBuffer();

        // 3진법 변환
        while (n != 0) {
            sb.append(n % 3);
            n = n / 3;
        }

        // 역순으로 뒤집은 후 10진법으로 변환
        int multiples = 1;
        for (int i = sb.length() - 1; i >= 0; i--) {
            answer += Character.getNumericValue(sb.charAt(i)) * multiples;
            multiples *= 3;
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(45));
    }
}
