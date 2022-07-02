package algorithm.codingtest.etc;

import java.util.*;


class Town {
    int monster;
    int people;

    public Town(int monster, int people) {
        this.monster = monster;
        this.people = people;
    }

    @Override
    public String toString() {
        return monster + " : " + people;
    }
}

public class Test0001 {

    public static void main(String[] args) {
        /*
           param1 = "마을 수", "체력"
           param2 = 몬스터 공격력
           param3 = 포박당한 마을 사람 수
         */

        // 예제1. 답 20
//        String param1 = "5 5";
//        String param2 = "5 3 1 2 4";
//        String param3 = "10 10 10 10 10";

        // 예제2. 답 50
//        String param1 = "5 100";
//        String param2 = "1 1 1 1 1";
//        String param3 = "10 10 10 10 10";

        // 예제3. 답 0
        String param1 = "5 1";
        String param2 = "2 2 2 2 2";
        String param3 = "2 2 2 2 2";

        int hp = Integer.parseInt(param1.split(" ")[1]); // 유저 HP
        int answer = 0; // 문제 답 (=구할 수 있는 마을 사람)
        String[] monster = param2.split(" "); // 몬스터 공격력
        String[] person = param3.split(" "); // 포박당한 마을 사람 수

        // 마을에 몬스터와 포박당한 사람 셋팅
        List<Town> list = new ArrayList<>();
        for (int i = 0; i < monster.length; i++) {
            Town town = new Town(Integer.parseInt(monster[i]), Integer.parseInt(person[i]));
            list.add(town);
        }

        // 공격력이 약한 몬스터 순으로 정렬
        Collections.sort(list, new Comparator<Town>() {
            @Override
            public int compare(Town o1, Town o2) {
                return o1.monster - o2.monster;
            }
        });

        // 마을 돌아다니면서 싸우기
        int sum = 0; // 누적 데미지 (n번째 마을에서 싸울 경우, 이전 몬스터들의 공격력 만큼 중복으로 깍임)
        for (Town town : list) {
            sum += town.monster;
            hp = hp - sum;
            if (hp > 0) { // 싸워서 이기면 사람들을 살릴 수 있다.
                answer += town.people;
            }
        }

        System.out.println(answer);
    }

}
