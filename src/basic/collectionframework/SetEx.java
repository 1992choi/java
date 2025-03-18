package basic.collectionframework;

import java.util.*;

public class SetEx {

    public static void main(String[] args) {
        /* HashSet */
        Set<String> hashSet = new HashSet<>();
        // 요소 추가
        hashSet.add("가");
        hashSet.add("나");
        hashSet.add("가"); // 중복을 허용하지 않는다.
        hashSet.add("다");
        System.out.println(hashSet); // [가, 다, 나] : HashSet은 추가한 순서대로 출력되지 않는다.

        // 요소 삭제
        hashSet.remove("다");
        System.out.println(hashSet); // [가, 나] : HashSet은 추가한 순서대로 출력되지 않는다.
        
        // 요소 확인
        System.out.println(hashSet.contains("나")); // true
        System.out.println(hashSet.contains("다")); // false

        // 모든 요소 출력
        Iterator<String> it = hashSet.iterator();
        while (it.hasNext()) {
            System.out.println(it.next()); // 저장되어있던 가, 나를 하나씩 출력
        }


        /* LinkedHashSet - HashSet과 유사하나 입력 순서가 보장된다. */
        Set<String> linkedHashSet = new LinkedHashSet<>();
        linkedHashSet.add("라");
        linkedHashSet.add("다");
        linkedHashSet.add("나");
        linkedHashSet.add("가");
        System.out.println(linkedHashSet); // [라, 다, 나, 가]


        /* TreeSet - HashSet과 유사하나 정렬 및 검색 기능이 추가되었다. */
        TreeSet<String> treeSet = new TreeSet<>();
        treeSet.add("라");
        treeSet.add("바");
        treeSet.add("나");
        treeSet.add("다");
        treeSet.add("가");
        treeSet.add("마");
        System.out.println(treeSet); // [가, 나, 다, 라, 마, 바] : 크기 순으로 출력
        System.out.println(treeSet.first()); // 가 : 원소 중 가장 작은 원소값 출력
        System.out.println(treeSet.last()); // 바 : 원소 중 가장 큰 원소값 출력

        // 데이터 꺼내기
        System.out.println(treeSet.pollFirst()); // 가
        System.out.println(treeSet.pollFirst()); // 나
        System.out.println(treeSet.pollLast()); // 바
        System.out.println(treeSet); // [다, 라, 마] : pollFirst() 또는 pollLast()를 통해 데이터를 꺼내면 저장된 원소에서 제거된다.

        // 데이터 정렬
        NavigableSet<String> navigableSet = treeSet.descendingSet();
        System.out.println(navigableSet); // [마, 라, 다]
        System.out.println(navigableSet.descendingSet()); // [다, 라, 마]

        // 부분 집합 생성
        treeSet.add("가");
        treeSet.add("나");
        treeSet.add("바");
        System.out.println(treeSet); // [가, 나, 다, 라, 마, 바]
        System.out.println(treeSet.headSet("다")); // [가, 나] : 파라미터 미만 데이터(포함x)
        System.out.println(treeSet.headSet("다", true)); // [가, 나, 다] : 파라미터 이하 데이터(포함o)
        System.out.println(treeSet.tailSet("다")); // [다, 라, 마, 바] : 파라미터 이상 데이터(포함o)
        System.out.println(treeSet.tailSet("다", false)); // [라, 마, 바] : 파리미터 초과 데이터(포함x)
        System.out.println(treeSet.subSet("나", "라")); // [나, 다]
        System.out.println(treeSet.subSet("나", true, "라", true)); // [나, 다, 라]


        // 객체 데이터 예제 - equals()와 hashCode() 오버라이딩
        Set<Person> hashSet1 = new HashSet<>();
        hashSet1.add(new Person("choi", 20));
        hashSet1.add(new Person("kim", 31));
        hashSet1.add(new Person("choi", 31));
        hashSet1.add(new Person("choi", 20));
        hashSet1.add(new Person("kim", 40));
        Iterator<Person> iterator1 = hashSet1.iterator();
        while (iterator1.hasNext()) {
            System.out.println(iterator1.next());
        }
        /*
            choi(20)
            kim(31)
            choi(31)
            kim(40)
         */


        // 객체 데이터 예제 - equals()와 hashCode() 오버라이딩 안함
        Set<Person2> hashSet2 = new HashSet<>();
        hashSet2.add(new Person2("choi", 20));
        hashSet2.add(new Person2("kim", 31));
        hashSet2.add(new Person2("choi", 31));
        hashSet2.add(new Person2("choi", 20));
        hashSet2.add(new Person2("kim", 40));
        Iterator<Person2> iterator2 = hashSet2.iterator();
        while (iterator2.hasNext()) {
            System.out.println(iterator2.next());
        }
        /*
            kim(40)
            choi(20)
            choi(31)
            kim(31)
            choi(20)
         */


        // 집합 (합집합, 교집합, 차집합)
        Set<Integer> setA = new HashSet<>();
        Set<Integer> setB = new HashSet<>();

        // 값 초기화
        setA.add(1); setA.add(2); setA.add(3); setA.add(4); setA.add(5);
        System.out.println(setA); // [1, 2, 3, 4, 5]
        setB.add(4); setB.add(5); setB.add(6); setB.add(7); setB.add(8);
        System.out.println(setB); // [4, 5, 6, 7, 8]

        // 교집합. 공통된 요소만 남기고 삭제
//        setA.retainAll(setB);
//        System.out.println(setA); // [4, 5]

        // 합집합. 모든 요소를 합함
//        setA.addAll(setB);
//        System.out.println(setA); // [1, 2, 3, 4, 5, 6, 7, 8]

        // 차집합. 공통 요소를 제거
        setA.removeAll(setB);
        System.out.println(setA); // [1, 2, 3]



        /*
            Set.of() 주의사항
            - Set.of()는 불변(immutable) Set을 생성한다.
            - 불변 리스트는 수정 불가능하며, 내부적으로 안정적인 구조를 유지해야한다.
            - 따라서 null 값을 허용하면, 예기치 않은 NullPointerException이 발생할 가능성이 커지고, 불변 객체의 신뢰성이 떨어질 수 있기에 null을 허용하지 않는다.
         */
        String value1 = "value1";
        String value2 = null;

        Set<String> set = new HashSet<>();
        set.add(value1);
        set.add(value2);
        System.out.println("set.add 성공"); // set.add 성공

        Set.of(value1, value2);
        System.out.println("Set.of 성공"); // NPE 발생하여 출력 X
    }

}

class Person {
    String name;
    int age;

    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return name + "(" + age + ")";
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Person)) {
            return false;
        }

        Person p = (Person)obj;
        return this.name.equals(p.name) && this.age == p.age;
    }
}

class Person2 {
    String name;
    int age;

    Person2(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return name + "(" + age + ")";
    }
}
