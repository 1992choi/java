package basic.clazz;

public class InstanceOfVariable {

    public static void main(String[] args) {
        Animal dog = new Dog();
        Animal cat = new Cat();

        cry(dog);
        cry(cat);

        cryWithVariable(dog);
        cryWithVariable(cat);
    }

    /*
        기존의 instanceof 사용 방식
        - 형변환 이후 사용이 가능했다.
     */
    public static void cry(Animal animal) {
        if (animal instanceof Dog) {
            // animal.cry(); // 컴파일 오류.
            ((Dog)animal).cry();
        } else if (animal instanceof Cat) {
            ((Cat)animal).cry();
        }
    }

    /*
        변수화 하여 사용
        - 형변환없이 바로 사용할 수 있다.
     */
    public static void cryWithVariable(Animal animal) {
        if (animal instanceof Dog dog) {
            dog.cry();
        } else if (animal instanceof Cat cat) {
            cat.cry();
        }
    }

    static class Animal {}

    static class Dog extends Animal {
        public void cry() {
            System.out.println("Dog cry");
        };
    }

    static class Cat extends Animal {
        public void cry() {
            System.out.println("Cat cry");
        };
    }

}