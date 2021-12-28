package algorithm.codingtest.programmers.level1;

// https://programmers.co.kr/learn/courses/30/lessons/12903
public class 가운데_글자_가져오기 {

    public static String solution(String s) {
        int idx = s.length() / 2;
        if (s.length() % 2 == 0) {
            return String.valueOf(s.charAt(idx - 1)) + s.charAt(idx);
        } else {
            return String.valueOf(s.charAt(idx));
        }
    }

    public static void main(String[] args) {
        System.out.println(solution("abcde"));
        System.out.println(solution("qwer"));
    }
}
