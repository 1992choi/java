package kyh.mid1.lang.object.tostring;

public class BadObjectPrinter {

    /*
        Object와 OCP
        - 만약 Object가 없고, 또 Object가 제공하는 toString()과 같은 메서드가 없다면,
          서로 아무 관계가 없는 객체의 정보를 출력하기 어려울 것이다.
        - 아래와 같이 각 각의 클래스마다 별도의 메서드를 작성해야할 것이다.
          - 이렇게 되면 BadObjectPrinter는 Car와 Dog와 같이 구체적인 타입에 의존적이게 된다.
          - 즉 OCP를 위반하게 되는 것이다.
        - Object와 toString()의 경우는 추상적인 Object에 의존하기 때문에 OCP를 잘 지킨다고 볼 수 있다.
     */

    public static void print(Car car) {
        // print Car Info
    }

    public static void print(Dog dog) {
        // print Dog Info
    }

}
