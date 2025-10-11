package javamistakes;

/*
    ClassCastException
    - ClassCastException이 발생하는 이유 중 하나는 명시적 타입 캐스팅 표현 시에 발생한다.
      명시적 타입 캐스팅을 방지하기 위해서는 instanceof로 검사하는 방법이 있다.
      이 방법은 매번 instanceof로 검사하고, 명시적 타입캐스팅을 통해 변수에 담은 후 사용해야하기 때문에 코드가 다소 복잡해질 수 있다.

      자바 16부터는 instanceof의 표현법이 개선되었다.
      - 바로 변수를 할당하도록 개선
 */
public class Ex043_ClassCastException {

    public static void main(String[] args) {
        String name = "choi";
        Person person = new Person("lee");

        printInfo(name);
        printInfo(person);

        printInfo2(name);
        printInfo2(person);
    }

    // 자바 16 이전 버전에서의 표현법
    public static void printInfo(Object obj) {
        if (obj instanceof String) {
            String name = (String) obj;
            System.out.println(name);
        } else if (obj instanceof Person) {
            Person person = (Person) obj;
            System.out.println(person.name);
        }
    }

    // 자바 16 부터의 표현법
    public static void printInfo2(Object obj) {
        if (obj instanceof String name) {
            System.out.println(name);
        } else if (obj instanceof Person person) {
            System.out.println(person.name);
        }
    }

    static class Person {
        String name;

        public Person(String name) {
            this.name = name;
        }
    }

}
