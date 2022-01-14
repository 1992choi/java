package algorithm.codingtest.programmers.level2;

import java.util.HashMap;
import java.util.Map;

// https://programmers.co.kr/learn/courses/30/lessons/42578
public class 위장 {

    public static int solution(String[][] clothes) {
        int answer = 1;
        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < clothes.length; i++) {
            map.put(clothes[i][1], map.getOrDefault(clothes[i][1], 0) + 1);
        }

        for (String key : map.keySet()) {
            answer *= (map.get(key) + 1);
        }

        return answer - 1;
    }

    public static void main(String[] args) {
        System.out.println(solution(new String[][]{{"yellowhat", "headgear"},
                {"bluesunglasses", "eyewear"},
                {"green_turban", "headgear"}}));

        System.out.println(solution(new String[][]{{"crowmask", "face"},
                {"bluesunglasses", "face"},
                {"smoky_makeup", "face"}}));
    }
}
