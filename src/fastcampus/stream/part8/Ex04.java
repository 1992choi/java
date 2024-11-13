package fastcampus.stream.part8;

import fastcampus.stream.part8.model.Order;
import fastcampus.stream.part8.model.OrderLine;
import fastcampus.stream.part8.model.User;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

public class Ex04 {

    public static void main(String[] args) {
        /*
            - reduce
              - 주어진 함수를 반복 적용해 Stream 안의 데이터를 하나의 값으로 합치는 작업
              - 앞서 살펴본 Max / Min / Count 도 reduce의 일종으로 볼 수 있다..
         */

        // 예제 1. 반복적으로 요소들을 더하는 작업
        List<Integer> numbers = Arrays.asList(1, 4, -2, -5, 3);
        int sum = numbers.stream()
                .reduce((x, y) -> x + y)
                .get();
        System.out.println(sum); // 1

        // 예제 2. 반복적으로 비교해서 최대값을 구하는 작업
        int min = numbers.stream()
                .reduce((x, y) -> x > y ? x : y)
                .get();
        System.out.println(min); // 4

        // 예제 3. 반복적으로 요소들을 곱하는 작업
        int product = numbers.stream()
                .reduce(1, (x, y) -> x * y);
        System.out.println(product); // 120

        // 예제 4. 요소들을 탐색해 문자를 숫자로 변환 후 더하는 작업
        List<String> numberStrList = Arrays.asList("3", "2", "5", "-4");
        int sumOfNumberStrList = numberStrList.stream()
                .map(Integer::parseInt)
                .reduce(0, (x, y) -> x + y);
        System.out.println(sumOfNumberStrList); // 6

        int sumOfNumberStrList2 = numberStrList.stream()
                .reduce(0, (number, str) -> number + Integer.parseInt(str), (num1, num2) -> num1 + num2);
        System.out.println(sumOfNumberStrList2);

        // 예제 5. 유저의 친구의 숫자를 모두 더하는 작업
        User user1 = new User()
                .setId(101)
                .setName("Alice")
                .setFriendUserIds(Arrays.asList(201, 202, 203, 204));
        User user2 = new User()
                .setId(102)
                .setName("Bob")
                .setFriendUserIds(Arrays.asList(204, 205, 206));
        User user3 = new User()
                .setId(103)
                .setName("Charlie")
                .setFriendUserIds(Arrays.asList(204, 205, 207));
        List<User> users = Arrays.asList(user1, user2, user3);
        int sumOfNumberOfFriends = users.stream()
                .map(User::getFriendUserIds)
                .map(List::size)
                .reduce(0, (x, y) -> x + y);
        System.out.println(sumOfNumberOfFriends); // 10

        // 예제 6. 주문들의 OrderLine들의 Amount 합계를 구하는 작업
        Order order1 = new Order()
                .setId(1001L)
                .setOrderLines(Arrays.asList(
                        new OrderLine().setAmount(BigDecimal.valueOf(1000)),
                        new OrderLine().setAmount(BigDecimal.valueOf(2000))));
        Order order2 = new Order()
                .setId(1002L)
                .setOrderLines(Arrays.asList(
                        new OrderLine().setAmount(BigDecimal.valueOf(2000)),
                        new OrderLine()
                                .setAmount(BigDecimal.valueOf(3000))));
        Order order3 = new Order()
                .setId(1002L)
                .setOrderLines(Arrays.asList(
                        new OrderLine().setAmount(BigDecimal.valueOf(1000)),
                        new OrderLine().setAmount(BigDecimal.valueOf(2000))));
        List<Order> orders = Arrays.asList(order1, order2, order3);

        BigDecimal sumOfAmounts = orders.stream()
                .map(Order::getOrderLines)
                .flatMap(List::stream)
                .map(OrderLine::getAmount)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        System.out.println(sumOfAmounts); // 11000
    }

}
