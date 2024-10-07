package kyh.mid1.lang.object.tostring;

public class ToStringMain2 {

    public static void main(String[] args) {
        /*
            - toString() 오버라이딩
              - car은 오버라이딩을 하지않은 상태 / Dog는 오버라이딩을 한 상태
              - toString() 을 재정의(오버라이딩)해서 보다 유용한 정보를 제공하는 것이 일반적이다.

            - 재정의한 클래스의 참조값을 출력하는 방법
              - toString()을 재정의했는데, 참조값을 알고 싶다면?
                - 'Integer.toHexString(System.identityHashCode(인스턴스))' 형태로 작성하여 참조값을 알아낼 수 있다.
                - Ex) Integer.toHexString(System.identityHashCode(dog1));
         */
        Car car = new Car("Model Y");
        Dog dog1 = new Dog("멍멍이1", 2);
        Dog dog2 = new Dog("멍멍이2", 5);

        System.out.println("1. 단순 toString 호출");
        System.out.println(car.toString()); // kyh.mid1.lang.object.tostring.Car@452b3a41
        System.out.println(dog1.toString()); // Dog{dogName='멍멍이1', age=2}
        System.out.println(dog2.toString()); // Dog{dogName='멍멍이2', age=5}

        System.out.println("2. println 내부에서 toString 호출");
        System.out.println(car); // kyh.mid1.lang.object.tostring.Car@452b3a41
        System.out.println(dog1); // Dog{dogName='멍멍이1', age=2}
        System.out.println(dog2); // Dog{dogName='멍멍이2', age=5}

        System.out.println("3. Object 다형성 활용");
        ObjectPrinter.print(car); // 객체 정보 출력: kyh.mid1.lang.object.tostring.Car@452b3a41
        ObjectPrinter.print(dog1); // 객체 정보 출력: Dog{dogName='멍멍이1', age=2}
        ObjectPrinter.print(dog2); // 객체 정보 출력: Dog{dogName='멍멍이2', age=5}

        String refValue = Integer.toHexString(System.identityHashCode(dog1));
        System.out.println("refValue = " + refValue); // refValue = 38af3868
    }
}
