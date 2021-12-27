package algorithm.codingtest.programmers.level1;

// https://programmers.co.kr/learn/courses/30/lessons/12916
public class 문자열_내_p와_y의_개수 {

    public static boolean solution(String s) {
        int pCnt = 0;
        int yCnt = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'P' || s.charAt(i) == 'p') {
                pCnt++;
            } else if (s.charAt(i) == 'Y' || s.charAt(i) == 'y') {
                yCnt++;
            }
        }

        return pCnt == yCnt;
    }

    public static void main(String[] args) {
        System.out.println(solution("pPoooyY"));
        System.out.println(solution("Pyy"));
    }
}
