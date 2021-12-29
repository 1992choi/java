package algorithm.codingtest.programmers.level1;

// https://programmers.co.kr/learn/courses/30/lessons/17681
public class 부족한_금액_계산하기 {

    public static long solution(int price, int money, int count) {
        long expectPrice = 0;

        for (int i = 1; i <= count; i++) {
            expectPrice += price * i;
        }

        return Math.max(expectPrice - money, 0);
    }

    public static void main(String[] args) {
        System.out.println(solution(3,20, 4));
    }
}
