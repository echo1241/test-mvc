package com.sparta.demothread;

import org.junit.jupiter.api.Test;

public class FileServiceTest {

    @Test
    void readTest() {
        // 파일 read 테스트 진행

        String result = FileService.read();

        System.out.println(result);
    }

    @Test
    void writeTest() {
        // given
        String content = "Iqk7YyM66W07YOA7L2U65Sp7YG065+9U3ByaW5n6rCV7J2Y";

        // 파일 write 테스트 진행
        FileService.write(content);

        System.out.println(FileService.read());
    }
}
