package algorithm.codingtest.programmers.level1;

// https://programmers.co.kr/learn/courses/30/lessons/12947
public class 하샤드_수 {

    public static boolean solution(int x) {
        int sum = 0;
        String xStr = String.valueOf(x);
        for (int i = 0; i < xStr.length(); i++) {
            sum += Character.getNumericValue(xStr.charAt(i));
        }

        return x % sum == 0 ? true : false;
    }

    public static void main(String[] args) {
        System.out.println(solution(10));
        System.out.println(solution(12));
        System.out.println(solution(11));
        System.out.println(solution(13));
    }
}
