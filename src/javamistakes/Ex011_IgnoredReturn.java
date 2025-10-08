package javamistakes;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/*
    반환값 무시
    - 메서드 호출후 결과값을 무시할 수 있는데, 반환된 값을 무시하게되어 발생할 수 있는 오류.
 */
public class Ex011_IgnoredReturn {

    public static void main(String[] args) throws IOException {
        // 잘못된 경로에서 디렉토리를 생성하면 mkdir()은 false를 반환한다.
        // 반환값을 확인하지 않으면 이후 로직이 의도와 다르게 동작할 수 있다.
        new File("/nonexistent path").mkdir();

        // 디렉토리 생성이 실패하면 예외를 발생시킨다.
        // 의도와 다르게 동작하는 것보다 예외를 발생시키고 이후 동작을 핸들링하는 것이 올바른 방법일 수 있다.
        Files.createDirectories(Paths.get("/nonexistent path"));
    }

}
