package fastcampus.stream.part8;

import fastcampus.stream.part8.model.User;
import fastcampus.stream.part8.service.EmailService;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Ex10 {

    public static void main(String[] args) {
        /*
            Parallel Stream
            - 여러개의 스레드를 이용하여 stream 처리 과정을 병렬화

            - 장점
              - 간단하게 병렬처리를 할 수 있다.
              - 속도가 비약적으로 빨라질 수 있다.

            - 단점
              - 항상 속도가 빨라지는 것은 아니다.
              - 공통으로 사용하는 리소스가 있을 경우, 잘못된 결과가 나올 수 있다.
              - deadlock이 발생할 수 있다.
                - 이를 막기위해 mutex, semaphore 등을 이용하면 순차처리보다 느려질 수도 있다.
         */

        User user1 = new User()
                .setId(101)
                .setName("Alice")
                .setVerified(true)
                .setEmailAddress("alice@fastcampus.co.kr");
        User user2 = new User()
                .setId(102)
                .setName("Bob")
                .setVerified(false)
                .setEmailAddress("bob@fastcampus.co.kr");
        User user3 = new User()
                .setId(103)
                .setName("Charlie")
                .setVerified(false)
                .setEmailAddress("charlie@fastcampus.co.kr");
        User user4 = new User()
                .setId(104)
                .setName("David")
                .setEmailAddress("david@fastcampus.co.kr")
                .setVerified(true);
        User user5 = new User()
                .setId(105)
                .setName("Eve")
                .setEmailAddress("eve@fastcampus.co.kr")
                .setVerified(false);
        User user6 = new User()
                .setId(106)
                .setName("Frank")
                .setEmailAddress("frank@fastcampus.co.kr")
                .setVerified(false);
        List<User> users = Arrays.asList(user1, user2, user3, user4, user5, user6);

        // 예제 1. 이메일을 검증하지 않은 유저에게 검증 요청 이메일 발송 (순차처리)
        long startTime = System.currentTimeMillis();
        EmailService emailService = new EmailService();
        users.stream()
                .filter(user -> !user.isVerified())
                .forEach(emailService::sendVerifyYourEmailEmail);
        long endTime = System.currentTimeMillis();
        System.out.println("Sequential: " + (endTime - startTime) + "ms"); // Sequential: 10ms

        // 예제 2. 이메일을 검증하지 않은 유저에게 검증 요청 이메일 발송 (병렬처리)
        startTime = System.currentTimeMillis();
        users.stream().parallel()
                .filter(user -> !user.isVerified())
                .forEach(emailService::sendVerifyYourEmailEmail);
        endTime = System.currentTimeMillis();
        System.out.println("Parallel: " + (endTime - startTime) + "ms"); // Parallel: 7ms

        /*
            예제 3. 순서 확인
            - 아래 예제를 실행해보면, 콘솔에 출력되는 문구가 계속 달라지는 것을 확인할 수 있다.
            - 이처럼 순서가 보장되지 않으니, 순차처리가 중요한 곳에서는 사용이 적절치 않을 수 있다.
         */
        List<User> processedUsers = users.parallelStream()
                .map(user -> {
                    System.out.println("Capitalize user name for user " + user.getId());
                    user.setName(user.getName().toUpperCase());
                    return user;
                })
                .map(user -> {
                    System.out.println("Set 'isVerified' to true for user " + user.getId());
                    user.setVerified(true);
                    return user;
                })
                .collect(Collectors.toList());
    }

}
