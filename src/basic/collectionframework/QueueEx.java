package basic.collectionframework;

import java.util.LinkedList;
import java.util.Queue;

public class QueueEx {

    public static void main(String[] args) {
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
    }

}
