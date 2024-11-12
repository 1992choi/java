package fastcampus.stream.part7;

import java.util.Optional;

public class Ex1 {

    public static void main(String[] args) {
        String someEmail = "some@email.com";
        String nullEmail = null;

        /* Optional을 만드는 방법 */

        // Null이 아닌 오브젝트를 이용해 만드는 방법
        Optional<String> maybeEmail = Optional.of(someEmail);

        // 빈 Optional을 만드는 방법
        Optional<String> maybeEmail2 = Optional.empty();

        // Null인지 아닌지 알지 못하는 오브젝트로 만드는 방법
        Optional<String> maybeEmail3 = Optional.ofNullable(someEmail);
        Optional<String> maybeEmail4 = Optional.ofNullable(nullEmail);

        String email = maybeEmail.get();
        System.out.println(email); // some@email.com

        if (maybeEmail2.isPresent()) { // Optional에 값이 있는지 확인한다. 이 경우 Null이기 때문에 조건문을 만족하지 않아 출력문이 실행되지 않는다.
            System.out.println(maybeEmail2.get());
        }

        // orElse(value) : 값이 없으면 value를 할당한다.
        String defaultEmail = "default@email.com";
        String email3 = maybeEmail2.orElse(defaultEmail);
        System.out.println(email3); // default@email.com

        // maybeEmail2.orElseGet(Supplier) : 값이 없으면 Supplier가 실행된다. 아래 예제는 defaultEmail를 반환하는 Supplier 실행
        String email4 = maybeEmail2.orElseGet(() -> defaultEmail);
        System.out.println(email4); // default@email.com

        // 값이 없으면 예외를 던진다.
        String email5 = maybeEmail2.orElseThrow(() -> new RuntimeException("email not present"));
    }

}
