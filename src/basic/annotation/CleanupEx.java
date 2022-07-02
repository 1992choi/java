package basic.annotation;

import lombok.Cleanup;

import java.io.Closeable;
import java.io.IOException;

class CustomClose implements Closeable {

    @Override
    public void close() throws IOException {
        // 자원반납
        System.out.println("call close()");
    }

    public void customClose() throws IOException {
        // 자원반납
        System.out.println("call customClose()");
    }
}

public class CleanupEx {

    public static void main(String[] args) throws IOException {
        // 결과확인 : 모두 주석 후에 하나씩만 실행

        /*
            1. 어노테이션 적용안함
               - 출력결과 : 없음
               - 자원을 반납하지 않음
         */
        CustomClose cc1 = new CustomClose();



        /*
            2. 어노테이션 적용
               - 출력결과 : call close()
               - Closeable의 close()를 오버라이딩한 메서드가 실행되었다.
         */
        @Cleanup CustomClose cc2 = new CustomClose();



        /*
            3. 메서드가 있는 어노테이션 적용
               - 출력결과 : call customClose()
               - 사용자가 자원반납을 위해 만든 customClose()가 실행되었다.
         */
        @Cleanup("customClose") CustomClose cc3 = new CustomClose();
    }

}
