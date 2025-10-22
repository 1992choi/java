package javamistakes;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/*
    Null을 허용하지 않는 컬렉션에서 null 검색
    - 컬렉션이 null을 처리하는 세 가지 기본 원칙이다.
      - 컬렉션 내 null원소를 허용
        - ArrayList, HashSet, Collections.singleton() 등
      - null 원소는 불허하지만 contains() 등의 메서드는 null 인수를 허용하며, 검색 결과로는 부재를 반환함
        - ConcurrentLinkedQueue, EnumSet, ArrayDeque 등
      - null 원소를 불허, 검색 메서드도 null 불허
        - List.of(), Set.of(), Map.of() 등

    - 자바 버전을 올리면서 코드를 마이그레이션 할 때, 위와 같은 특징을 무시한채로 마이그레이션을 하면 NPE가 발생할 수 있다.
      - 따라서 수정 불가 컬렉션을 신형 컬렉션 팩토리로 무분별하게 교체하지 않는다.
 */
public class Ex071_SearchNullInNonNullableCollection {

    public static void main(String[] args) {
        String userDevice = null;
        // AS_IS : 구식의 수정 불가 컬렉션
        Set<String> platforms = Collections.unmodifiableSet(
                new HashSet<>(Arrays.asList("PC", "MAC", "MOBILE"))
        );
        System.out.println(platforms.contains(userDevice)); // false

        // TO_BE : 마이그레이션을 진행하며 신형 API로 수정된 예시
        Set<String> newPlatForms = Set.of("PC", "MAC", "MOBILE");
        System.out.println(newPlatForms.contains(userDevice)); // NPE 발생
        // 만약 인자값이 null일 경우, 기존에는 false를 받았지만 변경 후 코드에서는 NPE가 발생한다.
    }

}
