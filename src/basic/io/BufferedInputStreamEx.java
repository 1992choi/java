package basic.io;

import java.io.*;
import java.nio.charset.Charset;

public class BufferedInputStreamEx {

    public static void main(String[] args) throws IOException {
        /* 파일 본문
            abc
            가나다라마바사
            1234
         */
        File file = new File(System.getProperty("user.dir") + File.separator
                + "data" + File.separator + "bufferedInputStream.txt");
        byte[] bytes = new byte[100];
        int count;
        if (file.exists()) {
            InputStream is = new FileInputStream(file);
            /*
                BufferedInput[Output]Stream은 입출력 과정에서 메모리 버퍼를 사용해 속도를 향상시킬 수 있다.
                만약 버퍼를 사용하지 않을 경우, 100byte의 데이터를 기록하고자 할 때 byte 단위로 파일에 데이터를 쓴다면 100번 액세스가 행해진다.
                반대로 버퍼를 사용하고 이 버퍼 사이즈가 50이라면 100byte의 데이터를 기록하기 위해서는
                단 2번만의 하드디스크 액세스로 작업을 완료할 수 있다.
             */
            BufferedInputStream bis = new BufferedInputStream(is);
            while ((count = bis.read(bytes)) != -1) {
                String str = new String(bytes, 0, count, Charset.forName("UTF-8"));
                System.out.println(str);
                /* 출력 결과
                    abc
                    가나다라마바사
                    1234
                 */
            }
            is.close();
            bis.close();
        } else {
            System.out.println("파일이 없습니다.");
        }
    }

}
