package basic.clazz;

public class StaticFactoryMethod {

    public static void main(String[] args) {
        /*
            정적 팩토리 메서드
              - 정적 팩토리 메서드는 객체 생성을 담당하는 static 메서드로, 생성자(constructor) 대신 인스턴스를 생성하고 반환하는 역할을 한다.
              - 일반적인 생성자(Constructor) 대신에 클래스의 인스턴스를 생성하고 초기화하는 로직을 캡슐화하여 제공하는 정적(static) 메서드이다. (보통은 생성자를 private으로 지정하나 예제를 위해 public으로 지정)
            특징
              - 정적 메서드 : 클래스 레벨에서 호출되며, 인스턴스 생성 없이 접근할 수 있다.
              - 객체 반환 : 내부에서 생성한 객체(또는 이미 존재하는 객체 = 캐싱)를 반환한다.
              - 생성자 대체 : 생성자와 달리 메서드 이름을 명시할 수 있어, 생성 과정의 목적이나 특징을 명확하게 표현할 수 있다.
              - 유연한 구현 : 객체 생성 과정에서 캐싱, 객체 재활용, 하위 타입 객체 반환 등 다양한 로직을 적용할 수 있다.
         */

        // 생성자를 이용한 객체 생성
        Person person1 = new Person("Alice");

        // 정적 팩토리 메서드를 이용한 객체 생성
        Person person2 = Person.of("Bob");

        // 같은 이름일 경우 캐싱된 객체 반환
        Person person3 = Person.of("Bob");
        System.out.println("person2 == person3: " + (person2 == person3)); // true
    }

    static class Person {

        private String name;

        public String getName() {
            return name;
        }

        /** 기본 생성자 */
        public Person(String name) {
            this.name = name;
        }

        /** 정적 팩토리 메서드 */
        // 캐싱용 Map
        private static final java.util.Map<String, Person> cache = new java.util.HashMap<>();

        // 정적 팩토리 메서드
        public static Person of(String name) {
            if (cache.containsKey(name)) {
                return cache.get(name);
            }

            Person person = new Person(name);
            cache.put(name, person);

            return person;
        }
    }

}
