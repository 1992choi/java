package fastcampus.stream.part8;

import fastcampus.stream.part8.model.Order;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Ex07 {

    public static void main(String[] args) {
        /*
            Grouping By
            - Stream 안의 데이터에 classfier를 적용했을 때, 결과값이 같은 값끼리 모아서 Map 형태로 반환해주는 collector
         */

        // 예제 1. 10으로 나눴을 때 나머지별로 그룹핑
        List<Integer> numbers = Arrays.asList(13, 2, 101, 203, 304, 402, 305, 349, 2312, 203);
        Map<Integer, List<Integer>> unitDigitMap = numbers.stream()
                .collect(Collectors.groupingBy(number -> number % 10));
        System.out.println(unitDigitMap); // {1=[101], 2=[2, 402, 2312], 3=[13, 203, 203], 4=[304], 5=[305], 9=[349]}

        // 예제 2. 예제 1과 동일하지만 Set으로 반환
        Map<Integer, Set<Integer>> unitDigitSet = numbers.stream()
                .collect(Collectors.groupingBy(number -> number % 10, Collectors.toSet()));
        System.out.println(unitDigitSet); // {1=[101], 2=[2, 402, 2312], 3=[203, 13], 4=[304], 5=[305], 9=[349]}

        // 예제 3. 예제 1과 동일하지만 String 결합 후 List로 반환
        Map<Integer, List<String>> unitDigitStrMap = numbers.stream()
                .collect(Collectors.groupingBy(number -> number % 10,
                        Collectors.mapping(number -> "unit digit is " + number, Collectors.toList())));
        System.out.println(unitDigitStrMap); // {1=[unit digit is 101], 2=[unit digit is 2, unit digit is 402, unit digit is 2312], 3=[unit digit is 13, unit digit is 203, unit digit is 203], 4=[unit digit is 304], 5=[unit digit is 305], 9=[unit digit is 349]}

        // 예제 4. 같은 OrderStatus끼리 묶기
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

        Map<Order.OrderStatus, List<Order>> orderStatusMap = orders.stream()
                .collect(Collectors.groupingBy(Order::getStatus));
        System.out.println(orderStatusMap); // {ERROR=[Order [id=1002, createdByUserId=0, status=ERROR, amount=4000, ], Order [id=1003, createdByUserId=0, status=ERROR, amount=3000, ]], CREATED=[Order [id=1001, createdByUserId=0, status=CREATED, amount=2000, ]], PROCESSED=[Order [id=1004, createdByUserId=0, status=PROCESSED, amount=7000, ]]}

        // 예제 5. OrderStatus 별 Amount 총합
        Map<Order.OrderStatus, BigDecimal> orderStatusToSumOfAmountMap = orders.stream()
                .collect(Collectors.groupingBy(Order::getStatus,
                        Collectors.mapping(Order::getAmount,
                                Collectors.reducing(BigDecimal.ZERO, BigDecimal::add))));
        System.out.println(orderStatusToSumOfAmountMap); // {ERROR=7000, CREATED=2000, PROCESSED=7000}
    }

}
