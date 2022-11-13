package io;

import java.io.FileOutputStream;
import java.io.OutputStream;

/*
    OutputStream은 바이트 기반 출력 스트림의 최상위 클래스이면서 추상 클래스이다.
    void | write(int b) | 1byte 출력
                          매개 변수로 주어지는 int(4byte)에서 끝(오른쪽) 1byte만 출력 스트림으로 전송
    void | write(byte[] b) | 매개값으로 주어진 배열 b의 모든 바이트 출력
    void | write(byte[] b, int off, int len) | 매개값으로 주어진 배열 b[off]부터 len개까지의 바이트 출력
    void | flush() | 출력 버퍼에 잔류하는 모든 바이트 출력
    void | close() | 출력 스트림 닫기
 */
public class OutputStreamExample {
    public static void main(String[] args) throws Exception {
        OutputStream os = new FileOutputStream("C:/java_io_test/test1.db");

        byte a = 10, b = 20, c = 30;

        // write(int b) : 매개 변수로 주어지는 int(4byte)에서 끝(오른쪽) 1byte만 출력 스트림으로 전송
        os.write(a);
        os.write(b);
        os.write(c);

        // 출력 스트림은 출력할 바이트를 바로 보내는 것이 아니라 내부 버퍼에 우선 저장한다
        // flush()는 내부 버퍼에 잔류된 바이트를 모두 출력한다
        os.flush();
        os.close();

        /**********************************************************************************/

        OutputStream os2 = new FileOutputStream("C:/java_io_test/test2.db");

        byte[] array2 = {10, 20, 30, 40, 50};

        os2.write(array2);

        os2.flush();
        os2.close();

        /**********************************************************************************/

        OutputStream os3 = new FileOutputStream("C:/java_io_test/test3.db");

        byte[] array3 = new byte[5];
        array3[0] = 10;
        array3[1] = 20;
        array3[2] = 30;
        array3[3] = 40;
        array3[4] = 50;

        os3.write(array3, 1, 3);

        os3.flush();
        os3.close();

        /**********************************************************************************/




    }

}
