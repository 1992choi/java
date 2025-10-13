package javamistakes;

/*
    String.compareTo()
    - 자바 객체의 순서를 정의하는 표준 방식은 두 가지이다.
      - Comparable / Comparator
    - compare 메서드 중 상당수는 실제로 -1, 0, 1만 반환한다.
      하지만 String의 경우에는 다양한 값을 반환하게 되어있다.

    - 만약 예제와 같이 코드를 작성한다면
      compareTo() 구현 자체는 문제가 없지만, 이 결과를 특정 양수와 비교하는 사용 방식은 문제가 있을 수 있다.

    - 실수를 줄이는 가이드
      - 1과 -1처럼 0이 아닌 상수와 비교를 하지 않도록 주의한다.
      -
 */
public class Ex063_StringCompare {

    public static void main(String[] args) {
        User u1 = new User("abc", 20);
        User u2 = new User("abd", 25);
        User u3 = new User("a", 30);

        System.out.println("u1 vs u2: " + u1.compareTo(u2)); // -1
        System.out.println("u1 vs u3: " + u1.compareTo(u3)); // 3
        System.out.println("u2 vs u3: " + u2.compareTo(u3)); // 3

        // 단순히 양수가 나올 것이라 판단하여 1과 비교를 하게되면, 예상치 못한 결과를 초래할 수 있다.
        if (u1.compareTo(u3) == 1) {
            // 앞선 값에 대한 어떠한 처리
        }
    }

    static class User implements Comparable<User> {
        String name;
        int age;

        public User(String name, int age) {
            this.name = name;
            this.age = age;
        }

        @Override
        public int compareTo(User o) {
            int res = name.compareTo(o.name);
            return res != 0 ? res : Integer.compare(age, o.age);
        }
    }

}
