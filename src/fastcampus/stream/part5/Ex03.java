package fastcampus.stream.part5;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;

public class Ex03 {

    public static void main(String[] args) {
        /*
            Constructor 참조 예제
            -
         */
        Map<String, BiFunction<String, String, Car>> carTypeToConstructorMap = new HashMap<>();
        carTypeToConstructorMap.put("sedan", Sedan::new);
        carTypeToConstructorMap.put("suv", Suv::new);

        String[][] inputs = new String[][]{
                {"sedan", "Sonata", "Hyundai"},
                {"sedan", "Model S", "Tesla"},
                {"suv", "Sorento", "KIA"}
        };

        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < inputs.length; i++) {
            String[] input = inputs[i];
            String carType = input[0];
            String name = input[1];
            String brand = input[2];

            /*
                carTypeToConstructorMap.get(carType)을 통해 BiFunction<String, String, Car>을 꺼낼 수 있다.
                BiFunction은 name과 brand를 input으로 받아 Car를 반환한다.

                즉 아래 코드는 생성자를 호출하여 Car를 만든 후 list에 담는 로직이다.
             */
            cars.add(carTypeToConstructorMap.get(carType).apply(name, brand));
        }

        for (Car car : cars) {
            car.drive();
        }
    }

}

abstract class Car {
    protected String name;
    protected String brand;

    public Car(String name, String brand) {
        this.name = name;
        this.brand = brand;
    }

    public abstract void drive();
}

class Sedan extends Car {
    public Sedan(String name, String brand) {
        super(name, brand);
    }

    public void drive() {
        System.out.println("Driving a sedan " + name + " from " + brand);
    }
}

class Suv extends Car {
    public Suv(String name, String brand) {
        super(name, brand);
    }

    public void drive() {
        System.out.println("Driving an SUV " + name + " from " + brand);
    }
}