package basic.thread.executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ExecutorBasic {

    public static void main(String[] args) {
        /*
            스레드를 직접 사용할 때의 문제점
            - 스레드 생성 시간으로 인한 성능 문제
              - 스레드 생성은 '메모리 할당', '운영체제 자원 사용', '운영체제 스케줄러 설정' 등의 이유로 아주 무거운 작업이다.
            - 스레드 관리 문제
              - 서버의 CPU, 메모리 자원은 한정되어 있기 때문에, 스레드는 무한하게 만들 수 없다.
              - 애플리케이션을 종료할 때, 스레드가 실행 중인 남은 작업은 모두 수행한 다음에 프로그램을 종료해야한다.
            - Runnable 인터페이스의 불편함
              - 반환 값이 없다.
              - 체크 예외(checked exception)를 던질 수 없다.

            이런 문제를 한방에 해결해주는 것이 바로 자바가 제공하는 Executor 프레임워크다.

            Executor 프레임워크의 주요 구성 요소
            - Executor 인터페이스
              - 가장 단순한 작업 실행 인터페이스로, execute(Runnable command) 메서드 하나를 가지고 있다.
            - ExecutorService 인터페이스
              - Executor 인터페이스를 확장해서 작업 제출과 제어 기능을 추가로 제공한다.
              - Executor 프레임워크를 사용할 때는 대부분 이 인터페이스를 사용한다.
            - ThreadPoolExecutor
              - ExecutorService의 가장 대표적인 구현체이다.

            ThreadPoolExecutor 생성자
            - corePoolSize : 스레드 풀에서 관리되는 기본 스레드의 수
            - maximumPoolSize : 스레드 풀에서 관리되는 최대 스레드 수
            - keepAliveTime, TimeUnit unit : 기본 스레드 수를 초과해서 만들어진 스레드가 생존할 수 있는 대기 시간이다. 이 시간 동안 처리할 작업이 없다면 초과 스레드는 제거된다.
            - BlockingQueue workQueue : 작업을 보관할 블로킹 큐
         */

        // 간단한 사용 방법
        ExecutorService es = new ThreadPoolExecutor(2,2,0, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<>());
        es.execute(() -> System.out.println(Thread.currentThread().getName()));
    }

}
