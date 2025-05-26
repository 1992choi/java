package basic.thread;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class CollectionFramework {

    public static void main(String[] args) {
        /*
            동시성 컬렉션의 필요성
            - java.util 패키지에 소속되어 있는 컬렉션 프레임워크는 스레드 세이프(Thread Safe)하지 않다.
            - 컬렉션 프레임워크가 제공하는 대부분의 연산은 원자적인 연산이 아니다.
         */

        /*
            해결방법 1.
            - synchronized, Lock 등을 통해 안전한 임계 영역을 적절히 만들면 문제를 해결할 수 있다.
            - 하지만, 모든 컬렉션 프레임워크 코드를 모두 복사하여 동기화용으로 새로 구현하는 방법은 좋은 방법이 아니다.
            - 자바에서는 프록시 기반의 synchronized를 지원한다.
            - 단점
              - 동기화 오버헤드가 발생
                - 비록 'synchronized' 키워드가 멀티스레드 환경에서 안전한 접근을 보장하지만, 각 메서드 호출 시마다 동기화 비용이 추가된다. 이로 인해 성능 저하가 발생할 수 있다.
              - 전체 컬렉션에 대해 동기화가 이루어지기 때문에, 잠금 범위가 넓어질 수 있다.
                - 이는 잠금 경합(lock contention)을 증가시키고, 병렬 처리의 효율성을 저하시키는 요인이 된다.
                - 모든 메서드에 대해 동기화를 적용하다 보면, 특정 스레드가 컬렉션을 사용하고 있을 때 다른 스레드들이 대기해야 하는 상황이 빈번해질 수 있다.
             - 정교한 동기화가 불가능하다.
               - 'synchronized' 프록시를 사용하면 컬렉션 전체에 대한 동기화가 이루어지지만, 특정 부분이나 메서드에 대해 선택적으로 동기화를 적용하는 것은 어렵다. 이는 과도한 동기화로 이어질 수 있다
         */
        List<String> list = Collections.synchronizedList(new ArrayList<>());
        list.add("a");
        list.add("b");

        /*
            해결방법 2.
            - 'java.util.concurrent' 패키지에는 고성능 멀티스레드 환경을 지원하는 다양한 동시성 컬렉션 클래스 사용한다.
            - 예를 들어, 'ConcurrentHashMap', 'CopyOnWriteArrayList', 'BlockingQueue' 등이 있다.
            - 이 컬렉션들은 더 정교한 잠금 메커니즘을 사용하여 동시 접근을 효율적으로 처리하며, 필요한 경우 일부 메서드에 대해서만 동기화를 적용하는 등 유연한 동기화 전략을 제공한다.
            - 종류
              - List
                - CopyOnWriteArrayList : ArrayList 의 대안
              - Set
                - CopyOnWriteArraySet : HashSet 의 대안
                - ConcurrentSkipListSet : TreeSet 의 대안 (정렬된 순서 유지, Comparator 사용 가능)
              - Map
                - ConcurrentHashMap : HashMap 의 대안
                - ConcurrentSkipListMap : TreeMap 의 대안 (정렬된 순서 유지, Comparator 사용 가능)
              - Queue
                - ConcurrentLinkedQueue : 동시성 큐, 비 차단(non-blocking) 큐이다.
              - Deque
                - ConcurrentLinkedDeque : 동시성 데크, 비 차단(non-blocking) 큐이다.
         */
        List<String> concurrentList = new CopyOnWriteArrayList<>();
        concurrentList.add("a");
        concurrentList.add("b");
    }

}
