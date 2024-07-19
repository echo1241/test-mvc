package com.sparta.demothread;

import com.sparta.demothread.jwt.JwtService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

@SpringBootTest
@ActiveProfiles("test")
class DemoThreadApplicationTests {

    @Test
    void contextLoads() {
    }

    @Autowired
    private UserRepository userRepository;

    @Test
    public void tokenToCsv() {
        List<User> users = userRepository.findByAll();

        long startTime = System.currentTimeMillis();

        ExecutorService executor = Executors.newVirtualThreadPerTaskExecutor();
        List<TokenResult> tokenResults = users.stream()
                .map(user -> new TokenResult(JwtService.createToken(user.getEmail())))
                .collect(Collectors.toList());

        try (FileWriter writer = new FileWriter("tokens.csv")) {
            writer.append("token\n");
            for (TokenResult result : tokenResults) {
                writer.append(result.getToken()).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Error writing CSV file.", e);
        }

        executor.shutdown();
        try {
            if (!executor.awaitTermination(60, TimeUnit.MINUTES)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
        }

        long endTime = System.currentTimeMillis();
        System.out.println("JWT 생성 및 CSV 저장 완료: " + (endTime - startTime) + "ms");
    }

    static class TokenResult {
        private final String token;

        public TokenResult(String token) {
            this.token = token;
        }

        public String getToken() {
            return token;
        }
    }

}
