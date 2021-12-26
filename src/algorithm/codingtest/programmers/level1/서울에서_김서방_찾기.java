package algorithm.codingtest.programmers.level1;

// https://programmers.co.kr/learn/courses/30/lessons/12919
public class 서울에서_김서방_찾기 {

    public static String solution(String[] seoul) {
        String answer = "";

        for (int i = 0; i < seoul.length; i++) {
            if ("Kim".equals(seoul[i])) {
                answer += "김서방은 " + i + "에 있다";
                break;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(new String[]{"Jane", "Kim"}));
    }
}
