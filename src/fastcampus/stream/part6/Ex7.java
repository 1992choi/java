package fastcampus.stream.part6;

import fastcampus.stream.part6.model.Order;
import fastcampus.stream.part6.model.OrderLine;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Ex7 {

    public static void main(String[] args) {
        /*
            FlatMap
            - 데이터에 함수를 적용한 후 중첩된 stream을 연결하여 하나의 stream으로 리턴
            - 중첩된 stream을 처리하기 위해 사용된다.
         */

        // 예제 1. 2차원 배열로 구성된 나라를 모두 출력
        String[][] cities = new String[][]{
                {"Seoul", "Busan"},
                {"San Francisco", "New York"},
                {"Madrid", "Barcelona"}
        };
        Stream<String[]> cityStream = Arrays.stream(cities);
        Stream<Stream<String>> cityStreamStream = cityStream.map(x -> Arrays.stream(x));
        List<Stream<String>> cityStreamList = cityStreamStream.collect(Collectors.toList());
        System.out.println(cityStreamList); // 스트림의 주소값이 출력된다.

        Stream<String[]> cityStream2 = Arrays.stream(cities);
        Stream<String> flattenedCityStream = cityStream2.flatMap(x -> Arrays.stream(x));
        List<String> flattenedCityList = flattenedCityStream.collect(Collectors.toList());
        System.out.println(flattenedCityList); // [Seoul, Busan, San Francisco, New York, Madrid, Barcelona]

        // 예제 2. 주문별 주문라인을 모두 출력
        Order order1 = new Order()
                .setId(1001)
                .setOrderLines(Arrays.asList(
                        new OrderLine()
                                .setId(10001)
                                .setType(OrderLine.OrderLineType.PURCHASE)
                                .setAmount(BigDecimal.valueOf(5000)),
                        new OrderLine()
                                .setId(10002)
                                .setType(OrderLine.OrderLineType.PURCHASE)
                                .setAmount(BigDecimal.valueOf(4000))
                ));
        Order order2 = new Order()
                .setId(1002)
                .setOrderLines(Arrays.asList(
                        new OrderLine()
                                .setId(10003)
                                .setType(OrderLine.OrderLineType.PURCHASE)
                                .setAmount(BigDecimal.valueOf(2000)),
                        new OrderLine()
                                .setId(10004)
                                .setType(OrderLine.OrderLineType.DISCOUNT)
                                .setAmount(BigDecimal.valueOf(-1000))
                ));
        Order order3 = new Order()
                .setId(1003)
                .setOrderLines(Arrays.asList(
                        new OrderLine()
                                .setId(10005)
                                .setType(OrderLine.OrderLineType.PURCHASE)
                                .setAmount(BigDecimal.valueOf(2000))
                ));
        List<Order> orders = Arrays.asList(order1, order2, order3);
        List<OrderLine> mergedOrderLines = orders.stream()    // Stream<Order>
                .map(Order::getOrderLines)                    // Stream<List<OrderLine>>
                .flatMap(List::stream)                        // Stream<OrderLine>
                .collect(Collectors.toList());
        System.out.println(mergedOrderLines); // [OrderLine [id=10001, type=PURCHASE, productId=0, quantity=0, amount=5000], OrderLine [id=10002, type=PURCHASE, productId=0, quantity=0, amount=4000], OrderLine [id=10003, type=PURCHASE, productId=0, quantity=0, amount=2000], OrderLine [id=10004, type=DISCOUNT, productId=0, quantity=0, amount=-1000], OrderLine [id=10005, type=PURCHASE, productId=0, quantity=0, amount=2000]]
    }

}
