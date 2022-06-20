package basic.collectionframework;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class QueueEx {

    public static void main(String[] args) {
        // FIFO(First In First Out) : 먼저 저장한 것을 제일 먼저 꺼낸다.
        Queue<String> queue = new LinkedList<>();
        // 데이터 추가 : add(), offer()
        queue.add("가");
        queue.add("나");
        queue.offer("다");
        queue.offer("라");
        queue.offer("마");
        System.out.println(queue); // [가, 나, 다, 라, 마]

        // 데이터 확인 : element(), peek()
        System.out.println(queue.element()); // 가 (만약 데이터가 없다면 java.util.NoSuchElementException 발생)
        System.out.println(queue); // [가, 나, 다, 라, 마]
        System.out.println(queue.peek()); // 가 (만약 데이터가 없다면 null 반환)
        System.out.println(queue); // [가, 나, 다, 라, 마]

        // 데이터 추출 : remove(), poll()
        System.out.println(queue.remove()); // 가 (만약 데이터가 없다면 java.util.NoSuchElementException 발생)
        System.out.println(queue); // [나, 다, 라, 마]
        System.out.println(queue.poll()); // 나 (만약 데이터가 없다면 null 반환)
        System.out.println(queue); // [다, 라, 마]

        /*
            우선순위 큐는 데이터가 추가된 순서에 상관없이 정렬된 순서로 꺼낸다.
         */
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        priorityQueue.add(3);
        priorityQueue.add(2);
        priorityQueue.add(1);
        System.out.println(priorityQueue.poll()); // 1
        System.out.println(priorityQueue.poll()); // 2
    }

}
