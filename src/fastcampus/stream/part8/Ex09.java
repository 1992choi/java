package fastcampus.stream.part8;

import fastcampus.stream.part8.model.User;
import fastcampus.stream.part8.service.EmailService;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class Ex09 {

    public static void main(String[] args) {
        /*
            For Each
            - Stream의 각 데이터에 적용해주는 총결 처리 메서드
            - 만약 Stream의 중간처리가 필요없다면, Collection에도 foreach를 지원하니 Collection에서 바로 foreach를 사용할 수도 있다.
         */

        // 예제 1. Stream의 foreach와 Collection의 foreach
        List<Integer> numbers = Arrays.asList(3, 5, 2, 1);
        numbers.stream().forEach(number -> System.out.println("The number is " + number)); // The number is {number} : 요소만큼 반복 출력
        numbers.forEach(number -> System.out.println("The number is " + number)); // The number is {number} : 요소만큼 반복 출력



        // 예제 2. 필터링 사용 후 forEach
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
        List<User> users = Arrays.asList(user1, user2, user3);

        EmailService emailService = new EmailService();
        users.stream()
                .filter(user -> !user.isVerified())
                .forEach(emailService::sendVerifyYourEmailEmail);
        /*
            실행결과
            - Sending 'Verify Your Email' email to bob@fastcampus.co.kr
            - Sending 'Verify Your Email' email to charlie@fastcampus.co.kr
         */



        // 예제 3. foreach도 index를 지정해서 특정 범위만 반복 가능하다.
        for (int i = 0; i < users.size(); i++) {
            User user = users.get(i);
            System.out.println("Do an operation on user " + user.getName() + " at index " + i);
        }
        /*
            실행결과 (아래와 동일)
            - Do an operation on user Alice at index 0
            - Do an operation on user Bob at index 1
            - Do an operation on user Charlie at index 2
         */


        IntStream.range(0, users.size()).forEach(i -> {
            User user = users.get(i);
            System.out.println("Do an operation on user " + user.getName() + " at index " + i);
        });
        /*
            실행결과 (위와 동일)
            - Do an operation on user Alice at index 0
            - Do an operation on user Bob at index 1
            - Do an operation on user Charlie at index 2
         */
    }

}
