package basic.io;

import java.io.*;
import java.nio.charset.Charset;

public class PrintStreamEx {

    public static void main(String[] args) throws IOException {
        /*
            PrintStream은 다양한 타입의 출력에 특화된 클래스로 자동 flush()기능을 제공한다.
         */
        File file = new File(System.getProperty("user.dir") + File.separator
                + "data" + File.separator + "printStream.txt");
        PrintStream ps = new PrintStream(file);
        ps.print(1);
        ps.print(2);
        ps.print(3);
        ps.println();
        ps.println("abc");
        ps.println("가나다");
        ps.close();
        /*
            실행결과
            : 123
              abc
              가나다
              (공백 존재)
         */
    }

}
