package basic.enumeration;

class SystemException extends Exception {
    public SystemException(SystemCode code) {
        super(code.getMessage());
    }
}

public class EnumEx {

    public static void main(String[] args) throws SystemException {
        int insertCnt = 0;
        if (insertCnt == 0) {
            throw new SystemException(SystemCode.INSERT_FAIL); // 등록을 실패했습니다.
        }
    }

}
