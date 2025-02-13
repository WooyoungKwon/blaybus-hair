package blaybus.hair_mvp.auth.service;

import java.time.Duration;

import blaybus.hair_mvp.constants.JwtMetadata;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseCookie;
import org.springframework.stereotype.Service;

@Service
public class CookieService {

    @Value("${jwt.access-key-expiration-s}")
    private long accessKeyExpirationInS;

//    @Value("${server.servlet.context-path}")
//    private String contextPath;

    public ResponseCookie createAccessTokenCookie(String accessToken, Duration maxAge) {

        return ResponseCookie.from(JwtMetadata.ACCESS_TOKEN, accessToken)
                .httpOnly(true)
                .secure(true)
                .maxAge(maxAge)
//                .path(contextPath)
                .sameSite("None")
                .build();
    }

    public ResponseCookie createAccessTokenCookie(String accessToken) {
        return ResponseCookie.from(JwtMetadata.ACCESS_TOKEN, accessToken)
                .httpOnly(true)
                .secure(true)
                .maxAge(accessKeyExpirationInS)
//                .path(contextPath)
                .sameSite("Strict")
                .build();
    }

}
