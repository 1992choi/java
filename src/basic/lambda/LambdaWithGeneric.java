package basic.lambda;

public class LambdaWithGeneric {

    public static void main(String[] args) {
        // 함수형 인터페이스에 제네릭을 사용하지 않는다면, 타입에 따라 함수도 계속 생성되어야 한다.
        StringFunction stringFunction = s -> s.toUpperCase();
        System.out.println(stringFunction.apply("abc")); // ABC

        NumberFunction numberFunction = num -> num * num;
        System.out.println(numberFunction.apply(2)); // 4

        // 이를 해결하고자 Object를 사용할 수 있지만, 함수는 줄어드는 대신에 안전하지 않은 캐스팅 과정이 필요하다.
        ObjectFunction objectStringFunction = s -> ((String) s).toUpperCase();
        System.out.println(objectStringFunction.apply("abc")); // ABC

        ObjectFunction objectNumberFunction = num -> (int) num * (int) num;
        System.out.println(objectNumberFunction.apply(2)); // 4

        // 제네릭을 사용할 경우, 위 문제들이 말끔하게 해소된다. (재사용성 + 타입 안전성)
        GenericFunction<String, String> genericStringFunction = s -> s.toUpperCase();
        System.out.println(genericStringFunction.apply("abc")); // ABC

        GenericFunction<Integer, Integer> genericNumberFunction = num -> num * num;
        System.out.println(genericNumberFunction.apply(2)); // 4

        GenericFunction<Integer, Boolean> genericBooleanFunction = num -> num % 2 == 0; // 기존 String과 Integer 조합 이외에도 여러 타입으로 확장이 가능하다.
        System.out.println(genericBooleanFunction.apply(4)); // true
    }

    @FunctionalInterface
    interface StringFunction {
        String apply(String s);
    }

    @FunctionalInterface
    interface NumberFunction {
        Integer apply(Integer s);
    }

    @FunctionalInterface
    interface ObjectFunction {
        Object apply(Object s);
    }

    @FunctionalInterface
    interface GenericFunction<T, R> {
        R apply(T t);
    }

}
