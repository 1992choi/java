package basic.generic;

import java.util.ArrayList;
import java.util.List;

/**
 * 공변(Covariance)과 불공변(Invariance)
 * - 배열은 공변(Covariant)
 * - 제네릭은 불공변(Invariant)
 * <p>
 * 이펙티브 자바에서는 불공변 제네릭(List<E>)을 기본으로 사용할 것을 권장한다.
 * 이유는 컴파일 시점에 타입 안정성을 보장할 수 있기 때문이다.
 */
public class CovariantAndInvariant {

    public static void main(String[] args) {
        /* -----------------------------------
         * 1. 배열은 '공변(Covariant)'
         * -----------------------------------
         * Dog[]는 Animal[]의 하위 타입으로 간주된다.
         * 즉, 배열은 공변이다.
         *
         * 하지만 이로 인해 런타임 시 타입 오류가 발생할 수 있다.
         */
        Dog[] dogs = new Dog[2];
        Animal[] animals = dogs; // 허용 (공변)

        animals[0] = new Dog(); // 가능
        try {
            animals[1] = new Cat(); // 런타임 오류 (ArrayStoreException)
        } catch (ArrayStoreException e) {
            System.out.println("배열은 공변이지만, 런타임에 타입 오류가 발생할 수 있다.");
        }

        /* -----------------------------------
         * 2. 제네릭은 '불공변(Invariant)'
         * -----------------------------------
         * List<Dog>는 List<Animal>의 하위 타입이 아니다.
         * 즉, 제네릭은 불공변이다.
         *
         * 이는 컴파일 시점에 타입 안정성을 확보하기 위한 설계이다.
         * 이펙티브 자바에서는 바로 이 점을 이유로,
         * 불공변한 제네릭 타입(List<E>)을 기본으로 사용하는 것을 권장한다.
         *
         * → 런타임 오류보다 컴파일 오류가 낫다는 원칙에 따라,
         *   제네릭의 불공변성은 안전성을 보장한다.
         */
        List<Dog> dogList = new ArrayList<>();
        // List<Animal> animalList = dogList; // 컴파일 오류 (불공변)

        dogList.add(new Dog());
        for (Dog d : dogList) {
            d.eat();
        }
    }

    static class Animal {
        void eat() {
            System.out.println("Animal eats");
        }
    }

    static class Dog extends Animal {
        @Override
        void eat() {
            System.out.println("Dog eats");
        }
    }

    static class Cat extends Animal {
        @Override
        void eat() {
            System.out.println("Cat eats");
        }
    }

}
