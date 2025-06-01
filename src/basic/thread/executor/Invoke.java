package basic.thread.executor;

import java.util.List;
import java.util.concurrent.*;

public class Invoke {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        /*
            invokeAll()과 invokeAny()
            - ExecutorService는 여러 작업을 한 번에 편리하게 처리하는 invokeAll()과 invokeAny() 기능을 제공한다.
              - invokeAll()
                - 모든 'Callable' 작업을 제출하고, 모든 작업이 완료될 때까지 기다린다.
              - invokeAny()
                - 하나의 'Callable' 작업이 완료될 때까지 기다리고, 가장 먼저 완료된 작업의 결과를 반환한다.
                - 완료되지 않은 나머지 작업은 취소한다. 
         */
        ExecutorService es = Executors.newFixedThreadPool(10);

        // invokeAll() - task1 /  task2 / task3이 모두 완료된 후 결과 반환
        long start = System.currentTimeMillis();
        CallableTask task1 = new CallableTask("task1", 1000);
        CallableTask task2 = new CallableTask("task2", 2000);
        CallableTask task3 = new CallableTask("task3", 3000);
        List<CallableTask> tasks = List.of(task1, task2, task3);
        List<Future<Integer>> futures = es.invokeAll(tasks);
        for (Future<Integer> future : futures) {
            Integer value = future.get();
            System.out.println("value = " + value);
        }
        System.out.println("invokeAll() = " + (System.currentTimeMillis() - start)); // invokeAll() = 3022

        // invokeAny() - task1 /  task2 / task3 중 가장 빨리 완료된 결과 반환
        start = System.currentTimeMillis();
        CallableTask task4 = new CallableTask("task4", 1000);
        CallableTask task5 = new CallableTask("task5", 2000);
        CallableTask task6 = new CallableTask("task6", 3000);
        tasks = List.of(task4, task5, task6);
        Integer value = es.invokeAny(tasks);
        System.out.println("value = " + value);
        System.out.println("invokeAny() = " + (System.currentTimeMillis() - start)); // invokeAny() = 1008
    }

    static public class CallableTask implements Callable<Integer> {
        private String name;
        private int sleepMs;

        public CallableTask(String name, int sleepMs) {
            this.name = name;
            this.sleepMs = sleepMs;
        }

        @Override
        public Integer call() throws Exception {
            Thread.sleep(sleepMs);
            return sleepMs;
        }
    }

}
