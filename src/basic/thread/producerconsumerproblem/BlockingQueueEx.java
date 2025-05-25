package basic.thread.producerconsumerproblem;

public class BlockingQueueEx {

    /*
        - BlockingQueue
          - 자바는 생산자 & 소비자 문제, 또는 한정된 버퍼라고 불리는 문제를 해결하기 위해 java.util.concurrent.BlockingQueue 라는 인터페이스와 구현체들을 제공한다.

        - 제공하는 기능
          - add(e)
            - 지정된 요소를 큐에 추가하며, 큐가 가득 차면 IllegalStateException 예외를 던진다.
          - remove()
            - 큐에서 요소를 제거하며 반환한다.
            - 큐가 비어 있으면 NoSuchElementException 예외를 던진다.
          - element()
            - 큐의 머리 요소를 반환하지만, 요소를 큐에서 제거하지 않는다.
            - 큐가 비어 있으면 NoSuchElementException 예외를 던진다.
          - offer(e)
            - 지정된 요소를 큐에 추가하려고 시도하며, 큐가 가득 차면 false 를 반환한다.
          - poll()
            - 큐에서 요소를 제거하고 반환한다. 큐가 비어 있으면 null 을 반환한다.
          - peek()
            - 큐의 머리 요소를 반환하지만, 요소를 큐에서 제거하지 않는다.
            - 큐가 비어 있으면 null 을 반환한다.
          - put(e)
            - 지정된 요소를 큐에 추가할 때까지 대기한다.
            - 큐가 가득 차면 공간이 생길 때까지 대기한다.
          - take()
            - 큐에서 요소를 제거하고 반환한다.
            - 큐가 비어 있으면 요소가 준비될 때까지 대기한다.
          - offer(e, time, unit)
            - 지정된 요소를 큐에 추가하려고 시도하며, 지정된 시간 동안 큐가 비워지기를 기다리다가 시간이 초과되면 false 를 반환한다.
          - poll(time, unit)
            - 큐에서 요소를 제거하고 반환한다.
            - 큐에 요소가 없다면 지정된 시간 동안 요소가 준비되기를 기다리다가 시간이 초과되면 null 을 반환한다.
     */

}
