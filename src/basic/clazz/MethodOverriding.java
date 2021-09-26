package basic.clazz;

class Animal {
    void cry() {}
}

class Bird extends Animal {
    @Override
    void cry() {
        System.out.println("짹짹");
    }
}

class Cat extends Animal {
    @Override
    void cry() {
        System.out.println("야옹");
    }
}

class Dog extends Animal {
    @Override
    void cry() {
        System.out.println("멍멍");
    }
}

public class MethodOverriding {

    public static void main(String[] args) {
        // 자신의 클래스로 객체 생성
        Bird bird = new Bird();
        Cat cat = new Cat();
        Dog dog = new Dog();
        bird.cry(); // 짹짹
        cat.cry(); // 야옹
        dog.cry(); // 멍멍
        
        // 부모 클래스로 객체 생성
        Animal bird2 = new Bird();
        Animal cat2 = new Cat();
        Animal dog2 = new Dog();
        bird2.cry(); // 짹짹
        cat2.cry(); // 야옹
        dog2.cry(); // 멍멍

        // 부모 클래스로 객체 생성 - 배열로 관리
        Animal[] animals = new Animal[]{new Bird(), new Cat(), new Dog()};
        for (Animal animal : animals) {
            animal.cry(); // 짹짹, 야옹, 멍멍
        }
    }

}
