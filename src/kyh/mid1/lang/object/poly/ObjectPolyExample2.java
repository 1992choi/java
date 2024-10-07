package kyh.mid1.lang.object.poly;

public class ObjectPolyExample2 {

    public static void main(String[] args) {
        Dog dog = new Dog();
        Car car = new Car();
        Object object = new Object(); //Object 인스턴스도 만들 수 있다.

        /*
            Object 는 모든 타입의 객체를 담을 수 있다. 따라서 Object[] 을 만들면 세상의 모든 객체를 담을 수 있는 배열을 만들 수 있다.

            만약 Object 와 같은 개념이 없다면 어떻게 될까?
            - void action(Object obj) 과 같이 모든 객체를 받을 수 있는 메서드를 만들 수 없다.
            - Object[] objects 처럼 모든 객체를 저장할 수 있는 배열을 만들 수 없다.

            Object가 없어도 직접 MyObject와 같은 클래스를 만들고, 모든 클래스에서 직접 정의한 MyObject를 상속할 수도 있지만,
            그렇게 된다면  서로 호환되지 않는 수 많은 XxxObject 들이 넘쳐날 것이다.
        */
        Object[] objects = {dog, car, object};

        size(objects);
    }

    private static void size(Object[] objects) {
        System.out.println("전달된 객체의 수는: " + objects.length);
    }

}
