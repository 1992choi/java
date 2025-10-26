package javamistakes;

import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;

/*
    동시 업데이트 데이터 구조에 대한 비원자적 접근
    - 동시성 프로그램에서는 컬렉션의 메서드를 호출할 때, 호출과 호출 사이에 다른 스레드에 의해 컬렉션이 수정될 수 있다.
      Ex) map의 get 이후 값을 판단해 put 을 하는 로직에서, get()과 put() 사이에 다른 스레드가 끼어들어 의도와 다른 결과를 야기할 수 있다.

 */
public class Ex093_NonAtomicConcurrentUpdate {

    public static void main(String[] args) {
        // Case 1. 큐의 동시성
        //         이 코드는 사실상 큐를 두 번 검서한다. isEmpty() 메서드 안에서, remove() 메서드 안에서 이루어진다. 다시 말해 큐와의 상호작용이 원자적이지 못하다.
        //         isEmpty()에서는 큐에 값이 있지만, remove()가 실행되기 전에 다른 스레드에 의해서 제거되었다면 예외가 발생할 것이다.
        Queue<String> queue = new LinkedList<>();
        if (!queue.isEmpty()) {
            String element = queue.remove();
            // element 처리
        }

        // 아래와 같이 수정이 가능하다.
        // poll()은 값이 없어도 예외를 발생시키지 않고, null을 반환하기 때문에 더 안전한 코드이다.
        String element = queue.poll();
        if (element != null) {
            // element 처리
        }


        // Case 2. Map의 동시성
        //         동시성 맵에 쓰인 구형 'get and put' 방식도 에러를 유발하기 쉽다.
        Map<String, Integer> map = new ConcurrentHashMap<>();
        Integer value = map.get("key");
        if (value == null) {
            value = 1;
        } else {
            value++;
        }

        map.put("key", value);

        // 위 코드를 아래와 같이 원자적으로 수정할 수 있다.
        map.merge("key", 1, Integer::sum);
    }

}
