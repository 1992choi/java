package fastcampus.stream.part6;

import fastcampus.stream.part6.model.Order;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Ex6 {

    public static void main(String[] args) {
        /*
            Distinct
            - 중복되는 데이터가 제거된 stream을 리턴
         */

        // 예제 1. 중복되는 숫자를 제거하고 출력
        List<Integer> numbers = Arrays.asList(3, -5, 4, -5, 2, 3);
        List<Integer> distinctNumbers = numbers.stream()
                .distinct()
                .collect(Collectors.toList());
        System.out.println(distinctNumbers); // [3, -5, 4, 2]

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

        // 예제 2. 중복되는 주문자만 추린 후 정렬해서 출력
        List<Long> distinctCreatedByUserIds = orders.stream()
                .map(Order::getCreatedByUserId)
                .distinct()
                .sorted()
                .collect(Collectors.toList());
        System.out.println(distinctCreatedByUserIds); // [101, 102, 103, 104]
    }

}
