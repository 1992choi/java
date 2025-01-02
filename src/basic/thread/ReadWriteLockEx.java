package basic.thread;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/*
    ReadWriteLock
    - ReadWriteLock 은 읽기 작업과 쓰기 작업을 위해 연관된 두 개의 락(읽기 락, 쓰기 락)을 유지하는 인터페이스이다
    - 일반적으로 락은 데이터를 조작하는 하나의 스레드의 임계영역을 보호하는 장치이며 데이터를 읽는 작업만 실행되는 영역은 여러 스레드가 동시에 접근해도 동시성 문제가 발생하지 않는다
    - 읽기 작업이 많고 쓰기 작업이 적은 영역을 효율적으로 처리하기 위해 다수의 읽기와 하나의 쓰기를 읽기락과 쓰기락으로 구분해서 락을 운용하는 것이 필요하다

    예제코드
    - 읽기락과 쓰기락이 분리되어 있어서 쓰기락이 잡혀있는 동안은 읽기락을 획득할 수 없지만,
      쓰기락의 자원이 해제된 이후에 읽기락 시에는 동시 접근(읽기락끼리만)이 가능하여 성능상 이점을 가지고 갈 수 있다.
 */
public class ReadWriteLockEx {

    public static void main(String[] args) {
        ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
        SharedData sharedData = new SharedData();

        Thread reader1 = new Thread(() -> {
            readWriteLock.readLock().lock();
            try {
                System.out.println("읽기 스레드 1이 데이터를 읽고 있습니다. 데이터: " + sharedData.getData());
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            } finally {
                readWriteLock.readLock().unlock();
            }
        });

        Thread reader2 = new Thread(() -> {
            readWriteLock.readLock().lock();
            try {
                System.out.println("읽기 스레드 2가 데이터를 읽고 있습니다. 데이터: " + sharedData.getData());
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            } finally {
                readWriteLock.readLock().unlock();
            }
        });

        Thread writer = new Thread(() -> {
            readWriteLock.writeLock().lock();
            try {
                System.out.println("쓰기 스레드가 데이터를 쓰고 있습니다");
                sharedData.setData(40);
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("쓰기 스레드가 데이터를 변경 했습니다. 데이터: " + sharedData.getData());
            } finally {
                readWriteLock.writeLock().unlock();
            }
        });

        writer.start();
        reader1.start();
        reader2.start();
    }

    static class SharedData {

        private int data = 0;

        public int getData() {
            return data;
        }

        public void setData(int data) {
            this.data = data;
        }
    }

}
