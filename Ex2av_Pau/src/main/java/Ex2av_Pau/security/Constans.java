package Ex2av_Pau.security;

import io.jsonwebtoken.security.Keys;

import java.nio.charset.StandardCharsets;
import java.security.Key;

public class Constans {


    // Spring Security
    public static final String LOGIN_URL = "http://localhost:8080/login";
    public static final String SIGNUP_URL = "http://localhost:8080/signup";
    public static final String HEADER_AUTHORIZACION_KEY = "token";
    public static final String TOKEN_BEARER_PREFIX = "Bearer ";
    public static final String ENTRENADOR_URL = "http://localhost:8080/entrenador/entrenamiento";
    public static final String ADMIN_URL = "http://localhost:8080/admin/arte_marcial";
    public static final String USER_URL = "http://localhost:8080/user/entrenamiento";


    public static final String USER = "pau";
    public static final String PASS = "1234";
    // JWT
    public static final String SUPER_SECRET_KEY = "ZnJhc2VzbGFyZ2FzcGFyYWNvbG9jYXJjb21vY2xhdmVlbnVucHJvamVjdG9kZWVtZXBsb3BhcmFqd3Rjb25zcHJpbmdzZWN1cml0eQ==bWlwcnVlYmFkZWVqbXBsb3BhcmFiYXNlNjQ=";
    public static final long TOKEN_EXPIRATION_TIME = 864_000_000; // 10 day


    public static Key getSigningKey(String secret) {
        byte[] keyBytes = secret.getBytes(StandardCharsets.UTF_8);
        return Keys.hmacShaKeyFor(keyBytes);
    }


}
