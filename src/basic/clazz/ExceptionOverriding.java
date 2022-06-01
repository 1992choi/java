package basic.clazz;

import java.io.IOException;
import java.sql.SQLException;

public class ExceptionOverriding {
    public static void main(String[] args) throws Exception {
    }
}

/*
    메서드 오버라이딩(Method Overriding)시 throws문 규칙
        A. 하위클래스는 상위클래스의 메서드에서 명시한 throws를 명시하지 않을 수 있다.
        B. 하위클래스는 상위클래스의 메서드와 동일하게 throws를 명시할 수 있다.
        C. 하위클래스는 상위클래스의 메서드에서 throws하는 예외의 하위 예외만 throws 할 수 있다.(상위 예외처리 불가)
*/
class ParentExceptionClass{
    void method() throws IOException, SQLException {
        System.out.println("call ParentExceptionClass.method()");
    }
}

class ChildExceptionClassA extends ParentExceptionClass {
    @Override
    void method() {
        System.out.println("call ChildExceptionClassA.method()");
    }
}

class ChildExceptionClassB extends ParentExceptionClass {
    @Override
    void method() throws IOException, SQLException {
        System.out.println("call ChildExceptionClassB.method()");
    }
}

/*
    오류발생
    : 'C. 하위클래스는 상위클래스의 메서드에서 throws하는 예외의 하위 예외만 throws 할 수 있다.(상위 예외처리 불가)'라는 규칙에 위배된다.
 */
class ChildExceptionClassC extends ParentExceptionClass {
    @Override
    void method() /* throws Exception */ {
        System.out.println("call ChildExceptionClassC.method()");
    }
}
