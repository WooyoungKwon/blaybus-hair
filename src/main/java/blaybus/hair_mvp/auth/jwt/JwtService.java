package blaybus.hair_mvp.auth.jwt;

import java.util.Date;

import javax.crypto.SecretKey;

import blaybus.hair_mvp.auth.dto.AccessTokenPayload;
import blaybus.hair_mvp.auth.dto.RefreshTokenPayload;
import blaybus.hair_mvp.domain.user.entity.Role;
import blaybus.hair_mvp.exception.ErrorResponseCode;
import blaybus.hair_mvp.exception.code.AccessTokenExceptionCode;
import io.jsonwebtoken.ExpiredJwtException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;


import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

@Service
public class JwtService {

    private final SecretKey secretKey;

    @Value("${spring.application.name}")
    private String issuer;

    @Value("#{${jwt.access-key-expiration-s} * 1000}")
    private long accessKeyExpirationInMs;

    @Value("#{${jwt.refresh-key-expiration-s} * 1000}")
    private long refreshKeyExpirationInMs;

    public JwtService(@Value("${jwt.secret-key}") String secretKey) {
        this.secretKey = Keys.hmacShaKeyFor(Decoders.BASE64.decode(secretKey));
    }

    public Claims verifyToken(String jwt) throws AccessTokenExceptionCode {
            return Jwts.parser()
                    .verifyWith(secretKey)
                    .build()
                    .parseSignedClaims(jwt)
                    .getPayload();

    }

    public AccessTokenPayload createAccessTokenPayload(Claims payload) {
        String roleString = payload.get("role", String.class);
        Role roleEnum = Role.valueOf(roleString);
        return new AccessTokenPayload(
                payload.getSubject(),
                roleEnum,
                payload.getIssuedAt()
        );
    }

    public RefreshTokenPayload createRefreshTokenPayload(Claims payload) {
        return new RefreshTokenPayload(payload.getSubject(), payload.getIssuedAt());
    }

    public String createAccessToken(AccessTokenPayload jwtPayload) {
        return Jwts.builder()
                .subject(jwtPayload.email())
                .claim("role", jwtPayload.roleEnum().name())
                .issuer(issuer)
                .issuedAt(jwtPayload.issuedAt())
                .expiration(new Date(jwtPayload.issuedAt().getTime() + accessKeyExpirationInMs))
                .signWith(secretKey)
                .compact();
    }

    public String createRefreshToken(RefreshTokenPayload jwtPayload) {
        return Jwts.builder()
                .subject(jwtPayload.email())
                .issuer(issuer)
                .issuedAt(jwtPayload.issuedAt())
                .expiration(new Date(jwtPayload.issuedAt().getTime() + refreshKeyExpirationInMs))
                .signWith(secretKey)
                .compact();
    }
}
