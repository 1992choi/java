package basic.reflection;

import java.lang.reflect.Method;

public class ReflectionEx {

    public static void main(String[] args) throws Exception {
        Theme theme = new Theme();
        String userSelectTheme = "Blue";

        // 직접 호출하는 경우
        if ("Blue".equals(userSelectTheme)) {
            theme.changeBlue(); // 파란 테마로 변경
        } else if ("Red".equals(userSelectTheme)) {
            theme.changeRed(); // 빨간 테마로 변경
        }

        // Reflection을 사용하는 경우 : 클래스나 메서드 정보를 동적으로 변경할 수 있다는 장점이 있다.
        Class clazz = Class.forName("basic.reflection.Theme");
        Method method = clazz.getMethod("change" + userSelectTheme);
        method.invoke(theme); // 파란 테마로 변경 : '직접 호출하는 경우'와 다르게 메서드를 실행하는 로직을 공통으로 만들 수 있다.
    }

}

class Theme {
    public void changeBlue() {
        System.out.println("파란 테마로 변경");
    }

    public void changeRed() {
        System.out.println("빨간 테마로 변경");
    }
}
