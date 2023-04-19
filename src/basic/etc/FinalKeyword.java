package basic.etc;

/** final 클래스 */
class NormalClass {
}

final class FinalClass {
}

class NormalChildClass extends NormalClass {
}

// 오류. Cannot inherit from final 'basic.etc.FinalClass'
//class FinalChildClass extends FinalClass {
//}

/** final 클래스 */



/** final 메소드 */
class ParentClass {

    void normalMethod() {
        // ...
    }

    final void finalMethod() {
        // ...
    }

}

class ChildClass extends ParentClass {

    @Override
    void normalMethod() {
        super.normalMethod();
    }

    // 오류. 'finalMethod()' cannot override 'finalMethod()' in 'basic.etc.ParentClass'; overridden method is final
//    @Override
//    void finalMethod() {
//        super.finalMethod();
//    }

}
/** final 메소드 */



public class FinalKeyword {

    /** final 변수 */
    int normalVariable = 0;
    final int finalVariable = 0;

    public void test() {
        normalVariable = 1;
        // finalVariable = 1; // 오류. Cannot assign a value to final variable 'finalVariable'
    }
    /** final 변수 */

    public static void main(String[] args) {

    }

}
