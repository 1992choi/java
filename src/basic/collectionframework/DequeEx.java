package basic.collectionframework;

import java.util.*;

public class DequeEx {

    public static void main(String[] args) {
        /*
            Deque
            - Double Ended Queue의 약자로 양쪽 끝에서 요소를 추가하거나 제거할 수 있다.
            - 스택과 큐의 기능을 모두 포함하고 있다.

            - ArrayDeque가 LinkedList 보다 성능에서 유리하다.
              - ArrayList와 LinkedList의 차이와 유사하다.
              - 데이터 추가/삭제는 LinkedList가 이론상 유리할 수 있는데, 실제 성능은 ArrayList가 유리한 경우가 많다. (맨 앞에 추가하는 경우를 제외하고 거의 앞선다.)
              - 이유는 ArrayList의 경우 요소들이 메모리상에 연속적으로 위치하여 CPU 캐시 효율이 좋고 메모리 접근 속도가 빨라 LinkedList보다 빠를 수 있기 때문.
         */
        // Deque<String> deque = new LinkedList<>();
        Deque<String> deque = new ArrayDeque<>();

        /*
            기본 추가 / 삭제 메서드
         */
        deque.offerFirst("a");
        deque.offerFirst("b");
        System.out.println(deque); // [b, a]

        deque.offerLast("c");
        deque.offerLast("d");
        System.out.println(deque); // [b, a, c, d]

        deque.pollFirst();
        System.out.println(deque); // [a, c, d]

        deque.pollLast();
        System.out.println(deque); // [a, c]

        /*
            스택처럼 사용
         */
        Deque<String> stack = new ArrayDeque<>();
        stack.push("a");
        stack.push("b");
        System.out.println(stack); // [b, a]

        System.out.println(stack.peek()); // b

        stack.pop();
        System.out.println(stack); // [a]
    }

}
