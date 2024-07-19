package com.sparta.demothread;

import com.sparta.demothread.jwt.JwtService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@Slf4j
@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserRepository userRepository;

    private SignatureAlgorithm sa = SignatureAlgorithm.HS256;
    private String jwtSecret = "7Iqk7YyM66W07YOA7L2U65Sp7YG065+9U3ByaW5n6rCV7J2Y7Yqc7YSw7LWc7JuQ67mI7J6F64uI64ukLg==";

    @GetMapping("/test")
    public User handleRequest(@RequestParam String token) {
//        String jwtString = authHdr.replace("Bearer","");
        Claims claims = Jwts.parserBuilder()
                .setSigningKey(JwtService.key)
                .build()
                .parseClaimsJws(token).getBody();

        Optional<User> user = userRepository.findById((String)claims.get("email"));

        log.info("쓰레드{}", Thread.currentThread());
        return user.get();
    }
}