package basic.clazz;

public class InstanceOf {

    public static void main(String[] args) {
        Car fireEngine = new FireEngine();
        Car ambulance = new Ambulance();

        doWork(fireEngine);
        doWork(ambulance);
    }

    public static void doWork(Car car) {
        /*
            인스턴스의 고유한 기능을 사용하기 위해서는 형변환이 필요한데
            형변환 시, instanceof 연산자를 통해 인스턴스의 타입을 체크할 수 있다.
         */
        if (car instanceof FireEngine) {
            FireEngine fireEngine = (FireEngine) car;
            fireEngine.water();
        } else if (car instanceof Ambulance) {
            Ambulance ambulance = (Ambulance) car;
            ambulance.siren();
        }
    }

}

class Car {
    void drive() {
        System.out.println("drive");
    }

    void stop() {
        System.out.println("stop");
    }
}


class FireEngine extends Car {
    void water() {
        System.out.println("water");
    }
}

class Ambulance extends Car {
    void siren() {
        System.out.println("siren");
    }
}