package fastcampus.stream.part6;

import fastcampus.stream.part6.model.Order;
import fastcampus.stream.part6.model.User;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Ex3 {

    public static void main(String[] args) {
        /*
            Map
            - 데이터를 변형하는데 사용
         */

        // 예제 1. 각 요소를 2배의 값으로 변경
        List<Integer> numberList = Arrays.asList(3, 6, -4);
        List<Integer> numberListX2 = numberList.stream()
                .map(x -> x * 2)
                .collect(Collectors.toList());
        System.out.println(numberListX2); // [6, 12, -8]

        // 예제 2. 각 요소를 문자열로 변경
        Stream<Integer> numberListStream = numberList.stream();
        Stream<String> strStream = numberListStream.map(x -> "Number is " + x);
        List<String> strList = strStream.collect(Collectors.toList());
        System.out.println(strList); // [Number is 3, Number is 6, Number is -4]

        // 예제 3. 각 유저의 이메일만 취합하여 새로운 리스트로 변경
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
                .setVerified(true)
                .setEmailAddress("charlie@fastcampus.co.kr");

        List<User> users = Arrays.asList(user1, user2, user3);
        List<String> emailAddresses = users.stream()
                .map(User::getEmailAddress)
                .collect(Collectors.toList());
        System.out.println(emailAddresses); // [alice@fastcampus.co.kr, bob@fastcampus.co.kr, charlie@fastcampus.co.kr]

        // 예제 4. 주문 리스트에서 CreatedByUserId만 추출
        Order order1 = new Order()
                .setId(1001)
                .setStatus(Order.OrderStatus.CREATED)
                .setCreatedByUserId(101);
        Order order2 = new Order()
                .setId(1002)
                .setStatus(Order.OrderStatus.ERROR)
                .setCreatedByUserId(103);
        Order order3 = new Order()
                .setId(1003)
                .setStatus(Order.OrderStatus.PROCESSED)
                .setCreatedByUserId(102);
        Order order4 = new Order()
                .setId(1004)
                .setStatus(Order.OrderStatus.ERROR)
                .setCreatedByUserId(104);
        Order order5 = new Order()
                .setId(1005)
                .setStatus(Order.OrderStatus.IN_PROGRESS)
                .setCreatedByUserId(101);

        List<Order> orders = Arrays.asList(order1, order2, order3, order4, order5);
        List<Long> createdByUserIds = orders.stream()
                .map(Order::getCreatedByUserId)
                .collect(Collectors.toList());
        System.out.println(createdByUserIds); // [101, 103, 102, 104, 101]


    }

}
