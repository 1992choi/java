package javamistakes;

/*
    수정 불가 컬렉션의 수정 시도
    - 자바에는 변경할 수 있는 컬렉션과 그렇지 않은 컬렉션이 존재한다.
      또한 특정 변경 작업만 허용하는 컬렉션도 있다.

      전체 가변 (가변)
      - ArrayList
      - LinkedList
      - ArrayDeque
      - HashSet
      - TreeSet
      - LinkedHashSet

      갱신 전용 (가변)
      - Arrays.asList

      제거 전용 (가변)
      - Map.keySet
      - Map.entrySet
      - Map.values

      무기능(no-op) 메서드 (불변)
      - Collections.emptyList
      - Collections.emptySet
      - Collections.singleton
      - Collections.singletonList
      - Collections.nCopies

      예외를 던지는 무기능 메서드 (불변)
      - Collections.unmodifiable*
      - List.of
      - List.copyOf
      - Set.of
      - Set.copyOf
      - Stream.toList

      위와 같은 특성을 모두 외울 수는 없다.
      그렇기 때문에 메서드가 반환하는 컬렉션은 기본적으로 수정할 수 없다고 간주하고 코딩하는 것이 좋다. (= 수정하려는 시도를 하지 않는다.)
      - 수정이 필요한 경우 복사본을 만들어서 수정하도록 한다.
 */
public class Ex073_UnmodifiableCollection {

    public static void main(String[] args) {

    }

}
