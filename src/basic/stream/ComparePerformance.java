package basic.stream;

import java.util.ArrayList;
import java.util.List;

class User {
    private String name;

    User(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

public class ComparePerformance {

    public static void main(String[] args) {
        /** 합계 로직 시간측정 */
        List<Long> list = new ArrayList<>();
        for (long i = 0; i < 10_000_000; i++) {
            list.add(i);
        }

        // for 문으로 합계 구하기
        long start = System.currentTimeMillis();
        int size = list.size();
        long sum = 0;
        for (int i = 0; i < size; i++) {
            sum += list.get(i);
        }
        System.out.println("sum = " + sum + " [" + (System.currentTimeMillis() - start) + "ms]"); // sum = 49999995000000 [18ms]

        // for 문으로 합계 구하기 [list.size() 그대로 사용]
        start = System.currentTimeMillis();
        sum = 0;
        for (int i = 0; i < list.size(); i++) {
            sum += list.get(i);
        }
        System.out.println("sum = " + sum + " [" + (System.currentTimeMillis() - start) + "ms]"); // sum = 49999995000000 [15ms]

        // for-each로 합계 구하기
        start = System.currentTimeMillis();
        sum = 0;
        for (long l : list) {
            sum += l;
        }
        System.out.println("sum = " + sum + " [" + (System.currentTimeMillis() - start) + "ms]"); // sum = 49999995000000 [15ms]

        // Stream API로 합계 구하기
        start = System.currentTimeMillis();
        sum = list.stream().reduce(0L, Long::sum);
        System.out.println("sum = " + sum + " [" + (System.currentTimeMillis() - start) + "ms]"); // sum = 49999995000000 [69ms]


        /** 값 변경 로직 시간측정 */
        List<User> users = new ArrayList<>();
        for (int i = 0; i < 10_000_000; i++) {
            users.add(new User("user_" + i));
        }

        // for 문으로 값 변경
        start = System.currentTimeMillis();
        size = users.size();
        for (int i = 0; i < size; i++) {
            users.get(i).setName(users.get(i).getName() + "_NEW");
        }
        System.out.println("users[0] = " + users.get(0).getName() + " [" + (System.currentTimeMillis() - start) + "ms]"); // users[0] = user_0_NEW [838ms]

        // for 문으로 값 변경 [list.size() 그대로 사용]
        start = System.currentTimeMillis();
        for (int i = 0; i < list.size(); i++) {
            users.get(i).setName(users.get(i).getName() + "_NEW");
        }
        System.out.println("users[0] = " + users.get(0).getName() + " [" + (System.currentTimeMillis() - start) + "ms]"); // users[0] = user_0_NEW_NEW [1009ms]

        // for-each로 값 변경
        start = System.currentTimeMillis();
        for (User user : users) {
            user.setName(user.getName() + "_NEW");
        }
        System.out.println("users[0] = " + users.get(0).getName() + " [" + (System.currentTimeMillis() - start) + "ms]"); // users[0] = user_0_NEW_NEW_NEW [320ms]

        // Stream API로 값 변경
        start = System.currentTimeMillis();
        users.stream().forEach(x -> x.setName(x.getName() + "_NEW"));
        System.out.println("users[0] = " + users.get(0).getName() + " [" + (System.currentTimeMillis() - start) + "ms]"); // users[0] = user_0_NEW_NEW_NEW_NEW [463ms]
    }

}
