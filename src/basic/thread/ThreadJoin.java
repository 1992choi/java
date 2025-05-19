package basic.thread;

public class ThreadJoin {

    public static void main(String[] args) throws InterruptedException {
        /*
            누적합 프로그램
            - 1 ~ 100까지의 합을 구한다.
            - 단, 2개의 스레드에서 각각 1~50 / 51~100의 합을 구한다.
         */
        SumTask task1 = new SumTask(1, 50);
        SumTask task2 = new SumTask(51, 100);
        Thread thread1 = new Thread(task1);
        Thread thread2 = new Thread(task2);

        thread1.start();
        thread2.start();

        System.out.println(task1.result + task2.result); // 0

        /*
            결과가 0인 이유
            - thread1과 thread2의 연산이 끝나기 전에 task1.result + task2.result가 실행되어 기대값과 다르게 0을 출력한다.

            해결방법 1.
            - 각각의 스레드보다 main 스레드의 종료가 늦게 main 스레드에도 sleep을 걸어준다.
            - 위 방법의 단점은 Task의 수행시간을 명확하게 알지 못할 경우, 낭비되는 시간이 생기거나 의도치않은 결과값을 얻게된다.

            해결방법 2.
            - while문을 통해 스레드가 종료되었는지 계속 확인
              - Ex. thread1.getState() == Thread.State.TERMINATED
            - 위 방법의 단점은 연산이 지속적으로 수행되야한다. (지속적으로 CPU 연산 필요)

            해결방법 3.
            - join 사용
            - 단, join을 사용할 경우 무기한 기다리는 상태가 될 수 있으므로, join(ms)를 사용하여 특정 시간 만큼만 대기할 수 있게 옵션을 줄 수도 있다.
         */

        thread1.join();
        thread2.join();

        System.out.println(task1.result + task2.result); // 5050
    }

    static class SumTask implements Runnable {
        int startValue;
        int endValue;
        int result = 0;

        public SumTask(int startValue, int endValue) {
            this.startValue = startValue;
            this.endValue = endValue;
        }

        @Override
        public void run() {
            try {
                Thread.sleep(1000);
                int sum = 0;
                for (int i = startValue; i <= endValue; i++) {
                    sum += i;
                }
                result = sum;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
