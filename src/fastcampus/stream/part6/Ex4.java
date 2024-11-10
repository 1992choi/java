package fastcampus.stream.part6;

import fastcampus.stream.part6.model.Order;
import fastcampus.stream.part6.model.User;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Ex4 {

    public static void main(String[] args) {
        /*
            Stream의 구성요소
            - Stream은 소스, 중간 처리, 종결 처리로 구분되어진다.
            - 여러가지의 중간 처리를 이어붙이는 것이 가능하다.

            - 소스
              - 컬렌셕, 배열 등
            - 중간 처리(Intermediate Operations)
              - 0개 이상의 filter, map 등의 중간처리
            - 종결 처리(Terminal Operation)
              - Collect, reduce 등
         */

        // 예제 1. 유저 리스트 중에 검증되지 않은 유저의 이메일만 추출
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

        List<String> emails = users.stream()
                .filter(user -> !user.isVerified())
                .map(User::getEmailAddress)
                .collect(Collectors.toList());
        System.out.println(emails); // [bob@fastcampus.co.kr, charlie@fastcampus.co.kr]

        // 예제 2.
        LocalDateTime now = LocalDateTime.now(ZoneId.of("Asia/Seoul"));
        Order order1 = new Order()
                .setId(1001)
                .setStatus(Order.OrderStatus.CREATED)
                .setCreatedByUserId(101)
                .setCreatedAt(now.minusHours(4));
        Order order2 = new Order()
                .setId(1002)
                .setStatus(Order.OrderStatus.ERROR)
                .setCreatedByUserId(103)
                .setCreatedAt(now.minusHours(1));
        Order order3 = new Order()
                .setId(1003)
                .setStatus(Order.OrderStatus.PROCESSED)
                .setCreatedByUserId(102)
                .setCreatedAt(now.minusHours(36));
        Order order4 = new Order()
                .setId(1004)
                .setStatus(Order.OrderStatus.ERROR)
                .setCreatedByUserId(104)
                .setCreatedAt(now.minusHours(40));
        Order order5 = new Order()
                .setId(1005)
                .setStatus(Order.OrderStatus.IN_PROGRESS)
                .setCreatedByUserId(101)
                .setCreatedAt(now.minusHours(10));
        List<Order> orders = Arrays.asList(order1, order2, order3, order4, order5);

        // 예제 2-1. 주문이 오류인 주문의 userId만 추출
        List<Long> errorUsers = orders.stream()
                .filter(order -> order.getStatus() == Order.OrderStatus.ERROR)
                .map(Order::getCreatedByUserId)
                .collect(Collectors.toList());
        System.out.println(errorUsers); // [103, 104]

        // 예제 2-2. 주문이 오류인 주문 중 24시간 내 주문
        List<Order> errorList = orders.stream()
                .filter(order -> order.getStatus() == Order.OrderStatus.ERROR)
                .filter(order -> order.getCreatedAt().isAfter(now.minusHours(24)))
                .collect(Collectors.toList());
        System.out.println(errorList); // [Order [id=1002, createdAt=2024-11-10T19:22:10.424094, createdByUserId=103, status=ERROR, ]]
    }

}
