package basic.thread.executor;

import java.util.concurrent.*;

public class ThreadPool {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        /*
            Executor 프레임워크 > 풀을 이용한 스레드 관리
            - ExecutorService의 기본 구현체인 ThreadPoolExecutor의 생성자는 다음 속성을 사용한다.
              - corePoolSize : 스레드 풀에서 관리되는 기본 스레드의 수
              - maximumPoolSize : 스레드 풀에서 관리되는 최대 스레드 수
              - keepAliveTime / TimeUnit : 기본 스레드 수를 초과해서 만들어진 초과 스레드가 생존할 수 있는 대기 시간
              - BlockingQueue : 작업을 보관할 블로킹 큐

            - 아래와 같이 ExecutorService가 생성되었다면, 다음과 같이 동작한다.
              - task1 실행 : 풀에 스레드가 없으므로 1개 생성.
              - task2 실행 : 풀에 스레드가 없으므로 1개 생성. 1개가 있지만, task1이 사용 중이므로 생성한 것이고 총 2개가 된 것이다.
              - task3 실행 : 스레드가 2개 생성되었지만 모두 사용 중이다. maximum size가 4이므로 스레드를 추가 생성할 것이라고 생각할 수도 있겠지만, 스레드를 생성하지 않고 대기 큐로 들어간다.
              - task4 실행 : 마찬가지로 대기 큐로 들어간다.
              - task5 실행 : 대기큐가 꽉 찼으므로 스레드를 생성하고 실행한다. 여기서 특이한 점은 먼저 요청 온 task3과 4를 실행하는 것이 아니라 5가 실행된다. task3을 대기 큐에서 빼고 task5를 대기 큐로 넣는 작업 효율이 좋지 않기 때문
              - task6 실행 : task5와 동일
              - task7 실행 : 대기큐에도 꽉 찼으며, maximum size에 스레드 수가 도달했기 때문에 새로 스레드를 만들지 못하므로 RejectedExecutionException 발생.

              - 3초 후(큐에 남아있던 작업까지 모두 완료된 시점) : core size를 초과한 스레드가 바로 사라지지 않는다. (때문에 pool=4로 표시된다.)
              - 3초 후(keepAliveTime로 설정한 시간이 흐른 시점) : core size를 초과한 스레드가 사라진단. (때문에 pool=2로 표시된다.)
              - shutdown : pool에 스레드가 모두 제거된다.
         */

        BlockingQueue<Runnable> workQueue = new ArrayBlockingQueue<>(2);
        ExecutorService es = new ThreadPoolExecutor(2, 4, 3000, TimeUnit.MILLISECONDS, workQueue);

        es.execute(new RunnableTask());
        printState(es, "task1"); // [pool=1, active=1, queuedTasks=0, completedTasks=0]

        es.execute(new RunnableTask());
        printState(es, "task2"); // [pool=2, active=2, queuedTasks=0, completedTasks=0]

        es.execute(new RunnableTask());
        printState(es, "task3"); // [pool=2, active=2, queuedTasks=1, completedTasks=0]

        es.execute(new RunnableTask());
        printState(es, "task4"); // [pool=2, active=2, queuedTasks=2, completedTasks=0]

        es.execute(new RunnableTask());
        printState(es, "task5"); // [pool=3, active=3, queuedTasks=2, completedTasks=0]

        es.execute(new RunnableTask());
        printState(es, "task6"); // [pool=4, active=4, queuedTasks=2, completedTasks=0]

        try {
            es.execute(new RunnableTask());
        } catch (RejectedExecutionException e) {
            System.out.println("task7 실행 거절 예외 발생");
        }

        Thread.sleep(3000);
        System.out.println("== 작업 수행 완료 ==");
        printState(es); // [pool=4, active=0, queuedTasks=0, completedTasks=6]

        Thread.sleep(3000);
        System.out.println("== maximumPoolSize 대기 시간 초과 ==");
        printState(es); // [pool=2, active=0, queuedTasks=0, completedTasks=6]

        es.shutdown();

        Thread.sleep(1000);
        System.out.println("== shutdown 완료 ==");
        printState(es); // [pool=0, active=0, queuedTasks=0, completedTasks=6]
    }

    public static void printState(ExecutorService executorService) {
        printState(executorService, "Main");
    }

    public static void printState(ExecutorService executorService, String taskName) {
        if (executorService instanceof ThreadPoolExecutor poolExecutor) {
            int pool = poolExecutor.getPoolSize();
            int active = poolExecutor.getActiveCount();
            int queued = poolExecutor.getQueue().size();
            long completedTask = poolExecutor.getCompletedTaskCount();
            System.out.println(taskName + " -> [pool=" + pool + ", active=" + active + ", queuedTasks=" + queued + ", completedTasks=" + completedTask + "]");
        }
    }

    static class RunnableTask implements Runnable {
        @Override
        public void run() {
            try {
                Thread.sleep(1000); // 작업 시간 시뮬레이션
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

}
