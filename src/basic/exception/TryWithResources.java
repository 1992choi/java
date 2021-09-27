package basic.exception;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class TryWithResources {

    public static void main(String[] args) {
        // 기본적인 자원 해제 방식
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            fis = new FileInputStream("file.txt");
            fos = new FileOutputStream("file.txt");
        } catch (IOException e) {
            // ...
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    // ...
                }
            }
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    // ...
                }
            }
        }

        // Try-with-resources를 통한 자원 해제
        try (FileInputStream fis2 = new FileInputStream("file.txt");
             FileOutputStream fos2 = new FileOutputStream("file.txt")) {
            // ...
        } catch (IOException e) {
            // ...
        } finally {
            // close()를 명시적으로 호출해줄 필요가 없음.
        }
    }

}
