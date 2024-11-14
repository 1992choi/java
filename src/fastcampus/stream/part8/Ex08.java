package fastcampus.stream.part8;

import fastcampus.stream.part8.model.User;
import fastcampus.stream.part8.service.EmailService;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Ex08 {

    public static void main(String[] args) {
        /*
            Partitioning By
            - Grouping By와 유사하지만 Function 대신 Predicate를 받아 true와 false를 key로 가지는 map을 반환
         */

        List<Integer> numbers = Arrays.asList(13, 2, 101, 203, 304, 402, 305, 349, 2312, 203);
        Map<Boolean, List<Integer>> numberPartitions = numbers.stream()
                .collect(Collectors.partitioningBy(number -> number % 2 == 0));
        System.out.println("Even number: " + numberPartitions.get(true)); // Even number: [2, 304, 402, 2312]
        System.out.println("Odd number: " + numberPartitions.get(false)); // Odd number: [13, 101, 203, 305, 349, 203]

        // 예제 1. 친구 숫자를 판단하여 특정 수치 기준으로 메일을 다르게 발송.
        User user1 = new User()
                .setId(101)
                .setName("Alice")
                .setEmailAddress("alice@fastcampus.co.kr")
                .setFriendUserIds(Arrays.asList(201, 202, 203, 204, 211, 212, 213, 214));
        User user2 = new User()
                .setId(102)
                .setName("Bob")
                .setEmailAddress("bob@fastcampus.co.kr")
                .setFriendUserIds(Arrays.asList(204, 205, 206));
        User user3 = new User()
                .setId(103)
                .setName("Charlie")
                .setEmailAddress("charlie@fastcampus.co.kr")
                .setFriendUserIds(Arrays.asList(204, 205, 207, 218));
        List<User> users = Arrays.asList(user1, user2, user3);

        Map<Boolean, List<User>> userPartitions = users.stream()
                .collect(Collectors.partitioningBy(user -> user.getFriendUserIds().size() > 5));

        EmailService emailService = new EmailService();

        for (User user : userPartitions.get(true)) {
            emailService.sendPlayWithFriendsEmail(user);
            // Sending 'Play With Friends' email to alice@fastcampus.co.kr
        }

        for (User user : userPartitions.get(false)) {
            emailService.sendMakeMoreFriendsEmail(user);
            // Sending 'Make More Friends' email to bob@fastcampus.co.kr
            // Sending 'Make More Friends' email to charlie@fastcampus.co.kr
        }
    }

}
