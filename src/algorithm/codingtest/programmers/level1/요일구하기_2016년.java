package algorithm.codingtest.programmers.level1;

// https://programmers.co.kr/learn/courses/30/lessons/12901
public class 요일구하기_2016년 {

    public static String solution(int a, int b) {
        int[] day = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        String[] dayOfWeek = {"THU", "FRI", "SAT", "SUN", "MON", "TUE", "WED"};
        int sum = 0;
        for (int i = 0; i < a - 1; i++) {
            sum += day[i];
        }
        sum += b;

        String answer = "";
        answer = dayOfWeek[sum % 7];
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(5, 24));
    }
}
