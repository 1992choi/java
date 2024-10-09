package kyh.mid1.lang.object.equals;

public class EqualsMain {

    public static void main(String[] args) {
        /*
            - 동일성과 동등성
              - 동일성(Identity) : == 연산자를 사용해서 두 객체의 참조가 동일한 객체를 가리키고 있는지 확인
              - 동등성(Equality) : equals() 메서드를 사용하여 두 객체가 논리적으로 동등한지 확인

            - 동등성
              - Object는 동등성 비교를 위한 equals() 메서드를 제공한다.

            - equals() 재정의
              - UserV1을 동등비교 했을 때, false가 나오는 이유는
                equals를 재정의하지 않으면 object가 기본적으로 제공하는 equals()를 사용하는데,
                이는 기본적으로 동일성 비교를 진행한다.
              - 반면 UserV2는 equals()를 재정의하였는데, 실행결과를 보면 UserV1가 다르게 true가 나오는 것을 확인할 수 있다.
         */
        UserV1 user1 = new UserV1("id-100");
        UserV1 user2 = new UserV1("id-100");

        System.out.println("identity = " + (user1 == user2)); // false
        System.out.println("equality = " + (user1.equals(user2))); // false


        UserV2 user3 = new UserV2("id-100");
        UserV2 user4 = new UserV2("id-100");

        System.out.println("identity = " + (user3 == user4)); // false
        System.out.println("equality = " + user3.equals(user4)); // true
    }
}
