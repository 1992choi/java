package algorithm.codingtest.programmers.level1;

// https://programmers.co.kr/learn/courses/30/lessons/12930
public class 이상한_문자_만들기 {

    public static String solution(String s) {
        String answer = "";
        boolean isUpperCase = true;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == ' ') {
                isUpperCase = true;
                answer += String.valueOf(ch);
            } else {
                if (isUpperCase) {
                    answer += String.valueOf(ch).toUpperCase();
                    isUpperCase = false;
                } else {
                    answer += String.valueOf(ch).toLowerCase();
                    isUpperCase = true;
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution("try hello world"));
    }
}
