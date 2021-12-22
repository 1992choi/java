package algorithm.codingtest.programmers.level1;

// https://programmers.co.kr/learn/courses/30/lessons/12948
public class 핸드폰_번호_가리기 {

    public static String solution(String phone_number) {
        String answer = "";
        answer = phone_number.substring(0, phone_number.length() - 4).replaceAll("[0-9]", "*")
                + phone_number.substring(phone_number.length() - 4);

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution("01033334444"));
        System.out.println(solution("027778888"));
    }
}
