package basic.exception;

import java.io.FileWriter;
import java.io.IOException;

public class CheckedAndUnchecked {

    public static void main(String[] args) {
        /*
                        CheckedException	            UncheckedException
             -------------------------------------------------------------------
             확인 시점        Compile                       Runtime
                 처리        반드시 처리                      명시적으로 하지 않아도 무관
              트랜잭션        예외 발생 시 Rollback X          예외 발생 시 Rollback O
         */

        // Checked Exception 중 하나인 IOException은 반드시 처리를 해야한다.
        try {
            FileWriter file = new FileWriter("data.txt");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // Unchecked Exception 중 하나인 NullPointerException은 반드시 처리를 할 필요는 없다.
        String str = null;
        str.length(); // NullPointerException 발생
    }

}
