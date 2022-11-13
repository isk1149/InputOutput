package io;

import java.io.FileInputStream;
import java.io.InputStream;

/*
    InputStream은 바이트 기반 입력 스트림의 최상위 클래스이면서 추상 클래스이다.
    int | read() | 1byte를 읽고 읽은 바이트를 리턴. 즉, int로 리턴할 때 4byte 중 끝(오른쪽) 1byte 리턴
                   더 이상 입력 스트림으로부터 바이트를 읽을 수 없다면 -1 리턴
                   이를 이용해 마지막 바이트까지 반복해서 1byte씩 읽기 가능
    int | read(byte[] b) | 읽은 바이트를 매개값으로 주어진 배열에 저장하고 읽은 바이트 수를 리턴
                           실제 읽은 바이트 수가 배열의 길이보다 적을 경우, 읽은 수만큼 리턴
                           ex. 입력 스트림에서 5개의 바이트가 들어온다면 길이 3인 배열로 두 번 읽고 각각 3, 2를 리턴
                           더 이상 입력 스트림으로부터 바이트를 읽을 수 없다면 -1 리턴
                           이를 이용해 읽을 수 있는 마지막 바이트까지 반복해서 읽기 가능
    int | read(byte[] b, int off, int len) | len개의 바이트를 읽고 매개값으로 주어진 배열에서 b[off]부터 len개까지 저장
                                             그리고 읽은 바이트 수인 len을 리턴
                                             실제 읽은 바이트 수가 len개보다 적을 경우, 읽은 수만큼 리턴
                                             더 이상 입력 스트림으로부터 바이트를 읽을 수 없다면 -1 리턴
                                             off를 0으로, len을 b.length로 준다면 read(byte[] b)와 동일
    void | close() | 입력 스트림 닫기
 */
public class InputStreamExample {
    public static void main(String[] args) throws Exception {
        InputStream is = new FileInputStream("C:/java_io_test/test1.db");

        while(true) {
            int data = is.read();
            if(data == -1) break;
            System.out.println(data);
        }

        is.close();
        System.out.println();
        /**********************************************************************************/

        InputStream is2 = new FileInputStream("C:/java_io_test/test2.db");

        byte[] buffer2 = new byte[3];

        while(true) {
            int readByteNum = is2.read(buffer2);
            if(readByteNum == -1) break;
            System.out.println("==" + readByteNum + "==");
            for(int i = 0; i < readByteNum; i++) {
                System.out.println(buffer2[i]);
            }
        }

        is2.close();
        System.out.println();
        /**********************************************************************************/

        InputStream is3 = new FileInputStream("C:/java_io_test/test3.db");

        byte[] buffer3 = new byte[5];

        int readByteNum = is3.read(buffer3, 2, 3);
        if(readByteNum != -1) {
            for(int i = 0; i < buffer3.length; i++) {
                System.out.println(buffer3[i]);
            }
        }

        is3.close();
    }
}
