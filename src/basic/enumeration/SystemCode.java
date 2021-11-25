package basic.enumeration;

public enum SystemCode {

    SUCCESS("0000", "성공했습니다."),
    INSERT_FAIL("0001", "등록을 실패했습니다."),
    UPDATE_FAIL("0002", "수정을 실패했습니다."),
    DELETE_FAIL("0003", "삭제를 실패했습니다."),
    SEARCH_FAIL("0004", "조회된 값이 없습니다."),
    UNKNOWN("9999", "오류가 발생했습니다.");

    private String code;
    private String message;

    SystemCode(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return this.code;
    }

    public String getMessage() {
        return this.message;
    }
}
