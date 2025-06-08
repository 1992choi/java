package basic.stream;

public class OptionalBestPractice {

    public static void main(String[] args) {
        /*
            Optional 모범 사례
            1. 반환 타입으로만 사용하고, 필드에는 가급적 쓰지 말기
              - Optional은 주로 메서드의 반환값에 대해 "값이 없을 수도 있음"을 표현하기 위해 도입되었다.
              - 클래스의 필드(멤버 변수)에 Optional을 직접 두는 것은 권장하지 않는다.
                - 필드를 Optional로 사용할 경우, 'null' or 'empty or '값이 있는 경우'와 같이 3가지 상황을 고려해야 되므로, 오히려 고려해야할 케이스만 늘어나게 된다.
                - 혹시라도 개발자가 부주의로 'Optional' 필드에 'null' 을 할당하면, 그 자체가 'NullPointerException' 을 발생시킬 여지를 남긴다.
                - 값이 없음을 명시하기 위해 사용하는 것이 'Optional' 인데, 정작 필드 자체가 'null' 이면 혼란이 가중된다.

            2. 메서드 매개변수로 'Optional' 을 사용하지 말기
              - 자바 공식 문서에 'Optional' 은 메서드의 반환값으로 사용하기를 권장하며, 매개변수로 사용하지 말라고 명시되어 있다.
              - 호출하는 측에서는 단순히 'null' 전달 대신 'Optional.empty()' 를 전달해야 하는 부담이 생기며, 결국 'null'을 사용하든 'Optional.empty()' 를 사용하든 큰 차이가 없어 가독성만 떨어진다.

            3. 컬렉션(Collection)이나 배열 타입을 'Optional'로 감싸지 말기
              - List<T>', 'Set<T>', 'Map<K,V>' 등 컬렉션(Collection) 자체는 비어있는 상태(empty)를 표현할 수 있다.
              - 따라서 'Optional<List<T>>' 처럼 다시 감싸면 'Optional.empty()' 와 "빈 리스트"('Collections.emptyList()')가 이중 표현이 되고, 혼란을 야기한다.

            4. 'isPresent()' 와 'get()' 조합을 직접 사용하지 않기
              - Optional의 'get()' 메서드는 가급적 사용하지 않아야 한다.
              - if (opt.isPresent()) {
                  opt.get()
                } else {
                  ...
                }

                위와 같이 코드를 작성하면, 사실상 'null' 체크 로직의 형태와 다를 바없으며, 깜빡하면 'NoSuchElementException' 같은 예외가 발생할 위험이 있다.
              - orElse', 'orElseGet', 'orElseThrow', 'ifPresentOrElse', 'map', 'filter' 등의 메서드를 활용하면 간결하고 안전하게 처리할 수 있다.

            5. orElseGet() vs orElse() 차이를 분명히 이해
              - 'orElse(T other)'는 항상 'other'를 즉시 생성하거나 계산한다.
                - 즉, 'Optional' 값이 존재해도 불필요한 연산/객체 생성이 일어날 수 있다. (즉시 평가)
              - 'orElseGet(Supplier<? extends T>)' 는 필요할 때만(빈 'Optional' 일 때만) 'Supplier' 를 호출한다.
                - 값이 이미 존재하는 경우에는 'Supplier' 가 실행되지 않으므로, 비용이 큰 연산을 뒤로 미룰 수 있다. (지연평가)

            6. 무조건 'Optional'이 좋은 것은 아니다
              - 'Optional'은 분명히 편의성과 안전성을 높여주지만, 모든 곳에서 "무조건" 사용하는 것은 오히려 코드 복잡성을 증가시킬 수 있다.
         */
    }

}
