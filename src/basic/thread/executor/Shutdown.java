package basic.thread.executor;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Shutdown {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        /*
            ExecutorService의 종료 관련 메서드
            - shutdown()
              - 새로운 작업을 받지 않고, 이미 제출된 작업을 모두 완료한 후에 종료한다.
              - 논 블로킹 메서드(이 메서드를 호출한 스레드는 대기하지 않고 즉시 다음 코드를 호출한다.)
            - shutdownNow()
              - 실행 중인 작업을 중단하고, 대기 중인 작업을 반환하며 즉시 종료한다.
              - 실행 중인 작업을 중단하기 위해 인터럽트를 발생시킨다.
              - 논 블로킹 메서드
            - isShutdown()
              - 서비스가 종료되었는지 확인한다.
            - isTerminated()
              - shutdown(), shutdownNow() 호출 후, 모든 작업이 완료되었는지 확인한다.
            - awaitTermination(long timeout, TimeUnit unit)
              - 서비스 종료시 모든 작업이 완료될 때까지 대기한다. 이때 지정된 시간까지만 대기한다.
              - 블로킹 메서드
            - close()
              - 자바 19부터 지원하는 서비스 종료 메서드이다.
              - 이 메서드는 shutdown()과 같다고 생각하면 된다.
         */

        ExecutorService es = Executors.newFixedThreadPool(1);
        // es.shutdown();
        // es.shutdownNow();
        // es.isShutdown();
        // es.isTerminated();
        // es.awaitTermination(5, TimeUnit.SECONDS);
        // es.close();
    }
    
}
