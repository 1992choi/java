package kyh.mid1.lang;

public class LangMain {

    public static void main(String[] args) {
        /*
            java.lang 패키지
            - 자바가 기본으로 제공하는 라이브러리 중에 가장 기본이 되는 패키지이다.
            - 대표 클래스
              - Object : 모든 자바 객체의 부모 클래스
              - String : 문자열
              - Integer, Long, Double 등 : 래퍼 타입, 기본형 데이터 타입을 객체로 만든 것
              - Class : 클래스 메타 정보
              - System : 시스템과 관련된 기본 기능 제공

            - 특징
              - import를 생략 가능하다.
                - lang 패키지에 속하는 System 클래스의 경우, import를 생략해서 아래와 같이 사용할 수 있다.
         */
        System.out.println("Hello World!");
    }

}
