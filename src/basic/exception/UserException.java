package basic.exception;

class NaturalNumException extends Exception {
    public NaturalNumException(String message) {
        super(message);
    }
}

public class UserException {

    private static void naturalNumCheck(int num) throws NaturalNumException {
        if (num <= 0) {
            throw new NaturalNumException("자연수가 아닙니다.");
        }
    }

    public static void main(String[] args) {
        try {
            naturalNumCheck(-1);
        } catch (NaturalNumException e) {
            System.out.println(e.toString()); // basic.exception.NaturalNumException: 자연수가 아닙니다.
            System.out.println(e.getMessage()); // 자연수가 아닙니다.
        }
    }

}
