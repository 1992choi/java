package basic.io;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class FileReaderEx {

    public static void main(String[] args) throws IOException {
        /*
            Reader(FileReader, BufferedReader, InputStreamReader)와
            Writer(FileWriter, BufferedWriter, OutputStreamWriter)는
            기존 예제(xxxStreamEx)와 다르게 byte단위의 입출력이 아닌 char단위의 입출력으로 문자열 입출력을 위해 특화된 기법이다.
         */
        File file = new File(System.getProperty("user.dir") + File.separator + "data" + File.separator + "xxxReader.txt");
        Reader reader = new FileReader(file);
        int data;
        while ((data = reader.read()) != -1) {
            System.out.print((char)data);
            /*
                실행결과
                : 123
                  abc
                  가나다
             */
        }
        reader.close();
    }

}
