package fastcampus.stream.part6;

import fastcampus.stream.part6.model.Order;
import fastcampus.stream.part6.model.User;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Ex5 {

    public static void main(String[] args) {
        /*
            Sorted
            - 데이터가 순새대로 정렬된 Stream을 리턴
         */

        // 예제 1. 오름차순으로 정렬
        List<Integer> numbers = Arrays.asList(3, -5, 7, 4);
        List<Integer> sortedNumbers = numbers.stream()
                .sorted()
                .collect(Collectors.toList());
        System.out.println(sortedNumbers);

        // 예제 2. 이름 순으로 정렬
        User user1 = new User()
                .setId(101)
                .setName("Paul")
                .setVerified(true)
                .setEmailAddress("alice@fastcampus.co.kr");
        User user2 = new User()
                .setId(102)
                .setName("David")
                .setVerified(false)
                .setEmailAddress("bob@fastcampus.co.kr");
        User user3 = new User()
                .setId(103)
                .setName("John")
                .setVerified(false)
                .setEmailAddress("charlie@fastcampus.co.kr");
        List<User> users = Arrays.asList(user1, user2, user3);
        List<User> sortedUsers = users.stream()
                .sorted((u1, u2) -> u1.getName().compareTo(u2.getName()))
                .collect(Collectors.toList());
        System.out.println(sortedUsers); // [User [id=102, name=David, emailAddress=bob@fastcampus.co.kr, isVerified=false, ], User [id=103, name=John, emailAddress=charlie@fastcampus.co.kr, isVerified=false, ], User [id=101, name=Paul, emailAddress=alice@fastcampus.co.kr, isVerified=true, ]]

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

        // 예제 3. 주문일시 별로 정렬
        List<Order> sortedOrders = orders.stream()
                .sorted((o1, o2) -> o1.getCreatedAt().compareTo(o2.getCreatedAt()))
                .collect(Collectors.toList());
        System.out.println(sortedOrders); // [Order [id=1004, createdAt=2024-11-09T04:55:02.741332, createdByUserId=104, status=ERROR, ], Order [id=1003, createdAt=2024-11-09T08:55:02.741332, createdByUserId=102, status=PROCESSED, ], Order [id=1005, createdAt=2024-11-10T10:55:02.741332, createdByUserId=101, status=IN_PROGRESS, ], Order [id=1001, createdAt=2024-11-10T16:55:02.741332, createdByUserId=101, status=CREATED, ], Order [id=1002, createdAt=2024-11-10T19:55:02.741332, createdByUserId=103, status=ERROR, ]]
    }

}
