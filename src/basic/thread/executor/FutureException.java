package basic.thread.executor;

import java.util.concurrent.*;

public class FutureException {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        /*
            Future의 예외
            - Future는 작업 중에 발생한 예외도 받을 수 있다.
            - 단, 예외 발생 시 ExecutionException이 발생한다.
              - Ex. call() 메서드에서 IllegalArgumentException이 발생하였지만, ExecutionException로 핸들링이 된다.
            - e.getCause()를 사용해서 실제 발생한 Exception을 받아올 수 있다.
         */

        ExecutorService es = Executors.newFixedThreadPool(2);
        try {
            Future<Integer> future = es.submit(new Task());
            future.get();
        } catch (IllegalArgumentException e) {
            System.out.println("IllegalArgumentException 발생");
        } catch (ExecutionException e) {
            System.out.println("ExecutionException 발생");

            Throwable cause = e.getCause();
            System.out.println("실제 발생한 Exception 은 " + cause); // 실제 발생한 Exception은 java.lang.IllegalArgumentException
        }
    }

    static class Task implements Callable<Integer> {
        @Override
        public Integer call() throws IllegalArgumentException {
            throw new IllegalArgumentException();
        }
    }

}
