package fastcampus.stream.part7;

import fastcampus.stream.part7.model.User;

import java.util.Optional;

public class Ex2 {

    public static void main(String[] args) {
        // ifPresent(Consumer<? super T> action) : Optional이 null이 아니라면 action을 실행한다.
        Optional<User> maybeUser = Optional.ofNullable(maybeGetUser(true));
        maybeUser.ifPresent(user -> System.out.println(user)); // User [id=1001, name=Alice, emailAddress=alice@fastcampus.co.kr, isVerified=false, ]

        // map(Function<? super T, ? extends U> mapper : Optional이 null이면 mapper 적용
        Optional<Integer> maybeId = Optional.ofNullable(maybeGetUser(true))
                .map(user -> user.getId());
        maybeId.ifPresent(System.out::println); // 1001. maybeGetUser(false)라면 출력되지 않는다.

        String userName = Optional.ofNullable(maybeGetUser(false))
                .map(User::getName)
                .map(name -> "The name is " + name)
                .orElse("Name is empty");
        System.out.println(userName); // Name is empty

        // flatMap(Function<? super T, ? extends Optional<? extends U>> mapper) : mapper의 리턴 값이 또 다른 Optional이라면 flat적용
        // 현재 예제의 경우 getEmailAddress은 Optional을 반환하기 때문에 flatMap을 적용하여 바로 String으로 추출할 수 있는 것이다.
        Optional<String> maybeEmail = Optional.ofNullable(maybeGetUser(true))
                .flatMap(User::getEmailAddress);
        maybeEmail.ifPresent(System.out::println);
    }

    public static User maybeGetUser(boolean returnUser) {
        if (returnUser) {
            return new User()
                    .setId(1001)
                    .setName("Alice")
                    .setEmailAddress("alice@fastcampus.co.kr")
                    .setVerified(false);
        }
        return null;
    }

}
