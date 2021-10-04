package basic.io;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;

public class InputStreamEx {

    public static void main(String[] args) throws IOException {
        /* 파일 본문
            abc
            가나다라마바사
            1234
            a

            가

            1
         */
        File file = new File(System.getProperty("user.dir") + File.separator + "data" + File.separator + "inputStream.txt");
        byte[] bytes = new byte[100];
        int count;
        if (file.exists()) {
            InputStream is = new FileInputStream(file);
            while ((count = is.read(bytes)) != -1) {
                String str = new String(bytes, 0, count, Charset.forName("UTF-8"));
                System.out.println(str);
                /* 출력 결과
                    abc
                    가나다라마바사
                    1234
                    a

                    가

                    1
                 */
            }
            is.close();
        } else {
            System.out.println("파일이 없습니다.");
        }
    }

}
