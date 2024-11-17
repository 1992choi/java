package fastcampus.stream.part9;

import fastcampus.stream.part9.model.Order;
import fastcampus.stream.part9.model.OrderLine;
import fastcampus.stream.part9.priceprocessor.OrderLineAggregationPriceProcessor;
import fastcampus.stream.part9.priceprocessor.TaxPriceProcessor;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class Ex03 {

    public static void main(String[] args) {
        /*
            Function Composition
            - 여러 개의 함수를 합쳐 하나의 새로운 함수를 만드는 것.
         */

        // 예제 1. (10을 더하는 함수)와 (2를 곱하는 함수)를 합성한다.
        Function<Integer, Integer> multiplyByTwo = x -> 2 * x;
        Function<Integer, Integer> addTen = x -> x + 10;

        Function<Integer, Integer> composedFunction = multiplyByTwo.andThen(addTen); // 2를 곱하는 함수 실행 후 10을 더하는 함수 실행
        System.out.println(composedFunction.apply(3)); // 16

        // 예제 2. 주문 별로 가격 적용 함수를 실행한다.
        //        - 여기서의 가격 적용 함수는 'OrderLine의 값을 모두 더하는 함수', 'Tax를 적용하는 함수' 2개이지만 더 많은 함수를 합성할 수도 있다.
        //          - reduce의 Function::andThen을 사용하여, 가격 적용 함수를 순차적으로 실행할 수 있음.
        Order unprocessedOrder = new Order()
                .setId(1001L)
                .setOrderLines(Arrays.asList(
                        new OrderLine().setAmount(BigDecimal.valueOf(1000)),
                        new OrderLine().setAmount(BigDecimal.valueOf(2000))));

        List<Function<Order, Order>> priceProcessors = getPriceProcessors(unprocessedOrder);

        Function<Order, Order> mergedPriceProcessors = priceProcessors.stream()
                .reduce(Function.identity(), Function::andThen);

        Order processedOrder = mergedPriceProcessors.apply(unprocessedOrder);
        System.out.println(processedOrder);
    }

    public static List<Function<Order, Order>> getPriceProcessors(Order order) {
        return Arrays.asList(
                new OrderLineAggregationPriceProcessor(),
                new TaxPriceProcessor(new BigDecimal("9.375"))
        );
    }

}
