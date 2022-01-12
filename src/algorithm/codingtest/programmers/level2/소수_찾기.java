package algorithm.codingtest.programmers.level2;

import java.util.HashSet;
import java.util.Iterator;

// https://programmers.co.kr/learn/courses/30/lessons/42839
public class 소수_찾기 {

    static HashSet<Integer> numbersSet = new HashSet<>();

    public static boolean isPrime(int num) {
        // 1. 0과 1은 제외
        if (num == 0 || num == 1) {
            return false;
        }

        // 2. 에라토스테네스의 체의 limit 숫자를 계산
        int lim = (int) Math.sqrt(num);

        // 3. 에라토스테네스의 체에 따라 lim까지 배수 여부를 확인
        for (int i = 2; i <= lim; i++) {
            if (num % i == 0) {
                return false;
            }
        }

        return true;
    }

    public static void recursive(String comb, String others) {
        // 1. 현재 조합을 set에 추가
        if (!comb.equals("")) numbersSet.add(Integer.valueOf(comb));

        // 2. 남은 숫자 중 한 개를 더해 새로운 조합 생성
        for (int i = 0; i < others.length(); i++) {
            recursive(comb + others.charAt(i), others.substring(0, i) + others.substring(i + 1));
        }
    }

    public static int solution(String numbers) {
        // 1. 조합 생성
        recursive("", numbers);

        // 2. 소수 체크
        int count = 0;
        Iterator<Integer> it = numbersSet.iterator();
        while (it.hasNext()) {
            int number = it.next();
            if (isPrime(number)) {
                count++;
            }
        }

        // 3. 소수의 개수를 반환
        return count;
    }


    public static void main(String[] args) {
        System.out.println(solution("17"));
        System.out.println(solution("011"));
    }
}
