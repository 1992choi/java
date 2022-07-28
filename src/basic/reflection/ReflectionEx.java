package basic.reflection;

import java.lang.reflect.Method;

public class ReflectionEx {

    public static void main(String[] args) throws Exception {
        Sample sample = new Sample();
        String param = "callA";

        // 직접 호출하는 경우
        if ("callA".equals(param)) {
            sample.callA(); // Run callA()
        } else {
            sample.callB(); // Run callB()
        }

        // Reflection을 사용하는 경우 : 클래스나 메서드 정보를 동적으로 변경할 수 있다는 장점이 있다.
        Class clazz = Class.forName("basic.reflection.Sample");
        Method method = clazz.getMethod(param);
        method.invoke(sample); // Run callA() : '직접 호출하는 경우'와 다르게 메서드를 실행하는 로직을 공통으로 만들 수 있다.
    }

}

class Sample {
    public void callA() {
        System.out.println("Run callA()");
    }

    public void callB() {
        System.out.println("Run callB()");
    }
}
