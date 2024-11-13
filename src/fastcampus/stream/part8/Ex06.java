package fastcampus.stream.part8;

import fastcampus.stream.part8.model.Order;
import fastcampus.stream.part8.model.User;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Ex06 {

    public static void main(String[] args) {
        /*
            toMap
            - Stream 안의 데이터를 Map 형태로 반환해주는 Collector
         */

        // 예제 1. UserList를 Map 형태로 변환한다.
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
        Map<Integer, User> userIdToUserMap = users.stream()
                .collect(Collectors.toMap(User::getId, Function.identity()));
        System.out.println(userIdToUserMap); // {101=User [id=101, name=Alice, emailAddress=alice@fastcampus.co.kr, isVerified=true, ], 102=User [id=102, name=Bob, emailAddress=bob@fastcampus.co.kr, isVerified=false, ], 103=User [id=103, name=Charlie, emailAddress=charlie@fastcampus.co.kr, isVerified=false, ]}
        System.out.println(userIdToUserMap.get(103));

        // 예제 2. OrderList를 Map 형태(key=id / value=OrderStatus)로 변환한다.
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
        Map<Long, Order.OrderStatus> statusMap = orders.stream()
                .collect(Collectors.toMap(Order::getId, Order::getStatus));
        System.out.println(statusMap); // {1001=CREATED, 1002=ERROR, 1003=ERROR, 1004=PROCESSED}
    }

}
