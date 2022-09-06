package algorithm.doit;

import java.util.LinkedList;
import java.util.Queue;

public class Doit013 {

    /*
        카드게임
        : 1~N까지 N개의 카드가 주어질 때,
          아래의 과정을 반복하여 마지막 남는 카드숫자 구하기

          1) 1번 카드가 가장 위, N번 카드가 가장 아래에 놓인 상태로 시작한다.
          2) 가장 위에 있는 카드를 버린다.
          3) 가장 위에 있는 카드를 가장 아래로 옮긴다.
          4) 1장이 남을 때까지 2)과 3)을 반복한다.

          Ex) N개의 수 : 1, 2, 3, 4
              1) 카드를 순서대로 놓는다.  : 1
                                      2
                                      3
                                      4

              2) 가장 위의 카드인 1을 버린다. : 2
                                         3
                                         4

              3) 가장 위에 있는 카드인 2를 가장 아래로 놓는다. : 3
                                                      4
                                                      2
              2) 가장 위의 카드인 3을 버린다. : 4
                                         2
              3) 가장 위에 있는 카드인 4를 가장 아래로 놓는다. : 2
                                                      4
              2) 가장 위의 카드인 2를 버린다.

              ===> 따라서 마지막 남는 카드는 4
     */
    static String solution(int card) {
        Queue<Integer> queue = new LinkedList<>();
        int actionType = 1; // 1=가장 위의 카드 버리기, 2=가장 위의 카드 아래로 옮기기
        for (int i = 1; i <= card; i++) {
            queue.add(i);
        }

        do {
            if (actionType == 1) {
                queue.poll();
                actionType = 2;
            } else {
                queue.add(queue.poll());
                actionType = 1;
            }
        } while (queue.size() != 1);

        return String.valueOf(queue.poll());
    }

    public static void main(String[] args) {
        System.out.println("Answer : " + solution(4)); // 4
        System.out.println("Answer : " + solution(6)); // 4
    }
}