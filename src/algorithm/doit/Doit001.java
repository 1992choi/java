package algorithm.doit;

/*
    문자열이 주어질 때, 각 자리의 합 구하기
    count = 숫자 갯수
    str = 숫자로 구성된 문자열
 */
public class Doit001 {

    static int solution(int count, String str) {
        int answer = 0;
        for (int i = 0; i < count; i++) {
            // answer += Integer.parseInt(String.valueOf(str.charAt(i)));
            answer += str.charAt(i) - '0'; // 문자열을 숫자형으로 변경하기 위하여 '0'을 뺀다. 또는 아스키코드 값을 계산한 형태인 'str.charAt(i) - 48' 으로 작성
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