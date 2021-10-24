package basic.exception;

public class ExceptionMessage {

    public static void main(String[] args) {
        try {
            int num = 3 / 0;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            /*
                - 에러의 원인을 간단하게 출력
                  : / by zero
             */

            System.out.println(e.toString());
            /*
                - 에러의 Exception 내용과 원인을 출력
                  : java.lang.ArithmeticException: / by zero
             */

            e.printStackTrace();
            /*
                - 에러의 발생근원지를 찾아서 단계별로 에러를 출력
                  : java.lang.ArithmeticException: / by zero
                        at basic.exception.ExceptionMessage.main(ExceptionMessage.java:7)
             */

        }
    }

}
