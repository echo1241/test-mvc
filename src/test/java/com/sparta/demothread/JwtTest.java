package com.sparta.demothread;

import com.sparta.demothread.jwt.JwtService;
import org.junit.jupiter.api.Test;

public class JwtTest {

    @Test
    void test1() {


        // 1. email 값 추출
        String email = "test@test.com";


        // email값은 어떻게 추출할 것인가,
        //   1) 데이터베이스에서 10000개를 메모리에 올려서 추출한다
             // 2) csv파일에서 추출한다.

        // 2. 해당 email 값으로 jwt 생성
        // service가 필요하다.

        String token = JwtService.createToken(email);

        // 3. jwt 생성한 값을 csv로 생성하기??

        // file에 쓰기
//        FileService.write(content);

        // 밥 먹으러 갔다올게여 1:30 ~

        System.out.println(token);



    }


}
