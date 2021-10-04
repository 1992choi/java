package basic.io;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.Charset;

public class OutputStreamEx {

    public static void main(String[] args) throws IOException {
        File file = new File(System.getProperty("user.dir") + File.separator + "data" + File.separator + "outputStream.txt");

        OutputStream os = new FileOutputStream(file); // 기존내용 무시하고 덮어쓰기
        byte[] bytes = "테스트".getBytes(Charset.forName("UTF-8"));
        os.write(bytes);
        os.flush();
        os.close();
        /*
            실행결과
            : 기존 파일의 내용이 'abc'에서 '테스트'로 덮어쓰여진다.
         */

        OutputStream os2 = new FileOutputStream(file, true); // 기존내용에 이어쓰기
        byte[] bytes2 = "123".getBytes(Charset.forName("UTF-8"));
        os2.write(bytes2);
        os2.flush();
        os2.close();
        /*
            실행결과
            : 기존 파일의 내용에 '123'이 추가된다.
              -> 테스트123
         */
    }

}
