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



/** final 메서드 */
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
/** final 메서드 */



public class FinalKeyword {

    /** final 변수 - 인스턴스 변수 */
    final int finalVar1;
    final int finalVar2;

    // 생성자를 통한 값 할당
    FinalKeyword() {
        finalVar1 = 1;
    }

    // 초기화블럭을 통한 값 할당
    {
        finalVar2 = 2;
    }
    /** final 변수 - 인스턴스 변수 */
    

    /** final 변수 */
    public void finalTest() {
        int normalVariable = 0;
        final int finalVariable = 0;

        normalVariable = 1;
        // finalVariable = 1; // 오류. Cannot assign a value to final variable 'finalVariable'
    }
    /** final 변수 */

    public static void main(String[] args) {

    }

}
