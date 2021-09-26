package basic.clazz;

/*
    MethodOverriding.java에서는 class를 사용하였지만
    Animal 클래스 내의 cry()는 실질적으로 아무런 기능을 하지 않는 메서드였다.
    따라서 추상 메서드를 사용하는 것이 조금 더 바람직한 방법이다.

    class Animal {
        void cry() {
        }
    }
*/
abstract class AnimalUsingAbs {
    void cry() {}
}

class BirdUsingAbs extends AnimalUsingAbs {
    void cry() {
        System.out.println("짹짹");
    }
}

class CatUsingAbs extends AnimalUsingAbs {
    void cry() {
        System.out.println("야옹");
    }
}

class DogUsingAbs extends AnimalUsingAbs {
    void cry() {
        System.out.println("멍멍");
    }
}

public class MethodOverridingUsingAbstract {

    public static void main(String[] args) {
        // 자신의 클래스로 객체 생성
        BirdUsingAbs bird = new BirdUsingAbs();
        CatUsingAbs cat = new CatUsingAbs();
        DogUsingAbs dog = new DogUsingAbs();
        bird.cry(); // 짹짹
        cat.cry(); // 야옹
        dog.cry(); // 멍멍

        // 부모 클래스로 객체 생성
        AnimalUsingAbs bird2 = new BirdUsingAbs();
        AnimalUsingAbs cat2 = new CatUsingAbs();
        AnimalUsingAbs dog2 = new DogUsingAbs();
        bird2.cry(); // 짹짹
        cat2.cry(); // 야옹
        dog2.cry(); // 멍멍

        // 부모 클래스로 객체 생성 - 배열로 관리
        AnimalUsingAbs[] animals = new AnimalUsingAbs[]{new BirdUsingAbs(), new CatUsingAbs(), new DogUsingAbs()};
        for (AnimalUsingAbs animal : animals) {
            animal.cry(); // 짹짹, 야옹, 멍멍
        }
    }

}
