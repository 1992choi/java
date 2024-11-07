package basic.collectionframework;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CompareEx {

    public static void main(String[] args) {
        List<User> users = new ArrayList<>();
        users.add(new User("2", 50));
        users.add(new User("1", 20));
        users.add(new User("3", 30));

        // 정렬 전 : 넣은 순서대로
        System.out.println(users); // [User{id=2, age=50}, User{id=1, age=20}, User{id=3, age=30}]

        // 기본(=Comparable 사용) 정렬 : 나이를 비교하게 구현
        Collections.sort(users);
        System.out.println(users); // [User{id=1, age=20}, User{id=3, age=30}, User{id=2, age=50}]

        // 별도의 비교자(=Comparator 사용)를 통한 정렬 : id를 비교
        Collections.sort(users, new MyComparator());
        System.out.println(users); // [User{id=1, age=20}, User{id=2, age=50}, User{id=3, age=30}]

        /*
            Collections.sort()와 List.sort()
            - 결과는 똑같으나 의미가 명확한 List.sort()를 더 권장한다.
         */
        users.sort(null); // Collections.sort(users); 와 동일
        users.sort(new MyComparator()); // Collections.sort(users, new MyComparator()); 와 동일
    }

}

class User implements Comparable<User> {

    public String id;
    public int age;

    public User(String id, int age) {
        this.id = id;
        this.age = age;
    }

    @Override
    public int compareTo(User o) {
        return Integer.compare(this.age, o.age);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", age=" + age +
                '}';
    }

}

class MyComparator implements Comparator<User> {

    @Override
    public int compare(User o1, User o2) {
        return o1.id.compareTo(o2.id);
    }

}