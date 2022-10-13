package basic.exception;

public class Finally {

    public static void main(String[] args) {
        /*
            finally 블럭은 예외 발생여부와 관계없이 수행되는 블럭이다.
            또한, try와 catch 블럭에 return문이 존재해도 finally 블럭은 수행된다.

            --- 실행결과

                정상실행
                finally 실행
                1
                -------------
                오류
                finally 실행
                0
                -------------
                예외 전가
                finally 실행
         */
        System.out.println(successMethod());
        System.out.println("-------------");
        System.out.println(errorMethod());
        System.out.println("-------------");
        try {
            System.out.println(throwMethod());
        } catch (Exception e) {
        }

    }

    private static int successMethod() {
        try {
            System.out.println("정상실행");
            return 1;
        } catch (Exception e) {
            System.out.println("오류");
            return 0;
        } finally {
            System.out.println("finally 실행");
        }
    }

    private static int errorMethod() {
        try {
            int num = 3 / 0;
            System.out.println("정상실행");
            return 1;
        } catch (Exception e) {
            System.out.println("오류");
            return 0;
        } finally {
            System.out.println("finally 실행");
        }
    }

    private static int throwMethod() throws Exception {
        try {
            int num = 3 / 0;
            System.out.println("정상실행");
            return 1;
        } catch (Exception e) {
            System.out.println("예외 전가");
            throw new Exception();
        } finally {
            System.out.println("finally 실행");
        }
    }

}
