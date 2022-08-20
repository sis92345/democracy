package com.democracy.jwt;

import com.democracy.common.util.ApplicationPropertiesUtils;
import com.democracy.redis.RedisService;
import io.jsonwebtoken.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import java.time.Duration;
import java.util.Base64;
import java.util.Date;

@Configuration
public class JwtUtils {

    private static final Logger logger = LoggerFactory.getLogger(JwtUtils.class);


    @Autowired
    private RedisService redisService;



    private static  String jwtSecret = ApplicationPropertiesUtils.getValue( "app.jwt.secret" , "123123123123123" );


    private static long accessExpiration = Long.parseLong(ApplicationPropertiesUtils.getValue( "app.jwt.expire-timeout" , "40" ));


    private static  long refreshExpiration =Long.parseLong(ApplicationPropertiesUtils.getValue( "app.jwt.refresh-timeout" , "40" )); ;


    @PostConstruct
    protected void init(){
        jwtSecret = Base64.getEncoder().encodeToString(jwtSecret.getBytes());
    }

    public String generateAccessToken(String userId) {
        Long tokenInvalidTime = accessExpiration * 60 * 1000L;
        return createToken(userId, tokenInvalidTime);
    }

    public String generateRefreshToken(String userId) {
        Long tokenInvalidTime = refreshExpiration * 60 * 1000L;
        String refreshToken = createToken(userId, tokenInvalidTime);
       redisService.setValues(refreshToken, userId, Duration.ofMillis(tokenInvalidTime));
        return refreshToken;
    }

    public String createToken(String userId, Long tokenInvalidTime) {
        return Jwts.builder().setSubject(userId).setIssuedAt(new Date())
                .setExpiration(new Date((new Date()).getTime() + tokenInvalidTime))
                .signWith(SignatureAlgorithm.HS512, jwtSecret).compact();
    }

    public String getUserNameFromJwtToken(String token) {
        return Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody().getSubject();
    }


    public boolean validateJwtToken(String authToken) {
        try {
            Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(authToken);
            return true;
        } catch (SignatureException e) {
            logger.error("Invalid JWT signature: {}", e.getMessage());
        } catch (MalformedJwtException e) {
            logger.error("Invalid JWT token: {}", e.getMessage());
        } catch (ExpiredJwtException e) {
            logger.error("JWT token is expired: {}", e.getMessage());
        } catch (UnsupportedJwtException e) {
            logger.error("JWT token is unsupported: {}", e.getMessage());
        } catch (IllegalArgumentException e) {
            logger.error("JWT claims string is empty: {}", e.getMessage());
        }
        return false;
    }



    public Boolean checkRefreshToken(String refreshToken) {
        String redisRT = redisService.getValues(refreshToken);
        return redisRT == null ? false : true;
    }

    public void deleteRefreshToken(String refreshToken) {
        redisService.deleteValues(refreshToken);
    }




}
