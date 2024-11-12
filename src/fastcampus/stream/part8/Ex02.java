package fastcampus.stream.part8;

import fastcampus.stream.part8.model.Order;
import fastcampus.stream.part8.model.User;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

public class Ex02 {

    public static void main(String[] args) {
        /*
            allMatch : 모든 데이터가 predicate를 만족하면 true
            anyMatch : 하나라도 predicate를 만족하면 true
         */
        List<Integer> numbers = Arrays.asList(3, -4, 2, 7, 9);
        boolean allPostive = numbers.stream()
                .allMatch(number -> number > 0);
        System.out.println("Are all numbers positive: " + allPostive); // false

        boolean anyNegative = numbers.stream()
                .anyMatch(number -> number < 0);
        System.out.println("Is any number negative: " + anyNegative); // true

        // 예제 1. 모든 사용자가 이메일 인증을 했는지
        User user1 = new User()
                .setId(101)
                .setName("Alice")
                .setVerified(true)
                .setEmailAddress("alice@fastcampus.co.kr");
        User user2 = new User()
                .setId(102)
                .setName("Bob")
                .setVerified(true)
                .setEmailAddress("bob@fastcampus.co.kr");
        User user3 = new User()
                .setId(103)
                .setName("Charlie")
                .setVerified(false)
                .setEmailAddress("charlie@fastcampus.co.kr");
        List<User> users = Arrays.asList(user1, user2, user3);

        boolean areAllUserVerified = users.stream()
                .allMatch(User::isVerified);
        System.out.println(areAllUserVerified); // false

        // 예제 2. 주문들 중에 오류가 하나라도 있는지
        Order order1 = new Order()
                .setId(1001L)
                .setAmount(BigDecimal.valueOf(2000))
                .setStatus(Order.OrderStatus.CREATED);
        Order order2 = new Order()
                .setId(1002L)
                .setAmount(BigDecimal.valueOf(4000))
                .setStatus(Order.OrderStatus.ERROR);
        Order order3 = new Order()
                .setId(1003L)
                .setAmount(BigDecimal.valueOf(3000))
                .setStatus(Order.OrderStatus.ERROR);
        Order order4 = new Order()
                .setId(1004L)
                .setAmount(BigDecimal.valueOf(7000))
                .setStatus(Order.OrderStatus.PROCESSED);
        List<Order> orders = Arrays.asList(order1, order2, order3, order4);

        boolean hasAnyError = orders.stream()
                .anyMatch(order -> order.getStatus() == Order.OrderStatus.ERROR);
        System.out.println(hasAnyError); // true
    }

}
