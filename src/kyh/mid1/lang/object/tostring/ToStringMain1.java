package kyh.mid1.lang.object.tostring;

public class ToStringMain1 {

    public static void main(String[] args) {
        /*
            - Object 가 제공하는 toString() 메서드는 기본적으로 패키지를 포함한 객체의 이름과 객체의 참조값(해시코드)를 16진수로 제공한다.
            - System.out.println()을 통해서 toString과 object를 출력하면, 결과가 동일하다.
              - System.out.println() 내부에서 toString()을 호출하기 때문이다.
         */
        Object object = new Object();

        // toString() 반환값 출력
        System.out.println(object.toString()); // java.lang.Object@a09ee92

        // object 직접 출력
        System.out.println(object); // java.lang.Object@a09ee92
    }

}
