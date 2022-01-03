package algorithm.codingtest.programmers.level2;

// https://programmers.co.kr/learn/courses/30/lessons/12951
public class JadenCase_문자열_만들기 {

    public static String solution(String s) {
        String answer = "";

        boolean isFirstChar = true;
        for (int i = 0; i < s.length(); i++) {
            char tmp = s.charAt(i);
            if (i != 0 && s.charAt(i - 1) == ' ') {
                isFirstChar = true;
            }
            if (isFirstChar) {
                answer += String.valueOf(tmp).toUpperCase();
            } else {
                answer += String.valueOf(tmp).toLowerCase();
            }

            isFirstChar = false;
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution("3people unFollowed me"));
        System.out.println(solution("for the last week"));
        System.out.println(solution("for  the last week"));
        System.out.println(solution("for   the   last   week"));
        System.out.println(solution("   for   the   last   week"));
        System.out.println(solution("   for   the   last   week "));
        System.out.println(solution("aaaaa aaa"));
    }
}
