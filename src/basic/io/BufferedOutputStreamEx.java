package basic.io;

import java.io.*;
import java.nio.charset.Charset;

public class BufferedOutputStreamEx {

    public static void main(String[] args) throws IOException {
        File file = new File(System.getProperty("user.dir") + File.separator
                + "data" + File.separator + "bufferedOutputStream.txt");

        OutputStream os = new FileOutputStream(file); // 기존내용 무시하고 덮어쓰기
        /*
            BufferedInput[Output]Stream은 입출력 과정에서 메모리 버퍼를 사용해 속도를 향상시킬 수 있다.
            만약 버퍼를 사용하지 않을 경우, 100byte의 데이터를 기록하고자 할 때 byte 단위로 파일에 데이터를 쓴다면 100번 액세스가 행해진다.
            반대로 버퍼를 사용하고 이 버퍼 사이즈가 50이라면 100byte의 데이터를 기록하기 위해서는
            단 2번만의 하드디스크 액세스로 작업을 완료할 수 있다.
         */
        BufferedOutputStream bos = new BufferedOutputStream(os);
        bos.write("안녕하세요".getBytes(Charset.forName("UTF-8")));
        bos.write('\n');
        bos.write("abc".getBytes());
        bos.close();
        /*
            실행결과
            : 안녕하세요
              abc
         */

        OutputStream os2 = new FileOutputStream(file, true); // 기존내용에 이어쓰기
        BufferedOutputStream bos2 = new BufferedOutputStream(os2);
        bos2.write('\n');
        bos2.write("이어쓰기".getBytes());
        bos2.close();
        /*
            실행결과
            : 안녕하세요
              abc
              이어쓰기  <- 이어쓰기된 문장
         */
    }

}
