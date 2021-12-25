package algorithm.codingtest.programmers.level1;

// https://programmers.co.kr/learn/courses/30/lessons/12931
public class 자릿수_더하기 {

    public static int solution(int n) {
        int answer = 0;

        String paramStr = String.valueOf(n);
        for (int i = 0; i < paramStr.length(); i++) {
            answer += Character.getNumericValue(paramStr.charAt(i));
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(123));
        System.out.println(solution(987));
    }
}
