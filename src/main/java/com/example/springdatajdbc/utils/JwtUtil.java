package com.example.springdatajdbc.utils;

import com.auth0.jwt.*;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;


import java.util.Date;

public class JwtUtil {

    /**
     * 过期时间15分钟
     * 密钥
     */
    private static final long EXPIRE_TIME = 15 * 60 * 1000;
    private static final String SECRET = "ymy214";

    /**
     * 生成签名，15分钟后过期
     */
    public static String sign(String uid) {
        try {
            Date date = new Date(System.currentTimeMillis() + EXPIRE_TIME);
            Algorithm algorithm = Algorithm.HMAC256(SECRET);
            return JWT.create()
                    // 将 user id 保存到 token 里面
                    .withAudience(uid)
                    // 五分钟后token过期
                    .withExpiresAt(date)
                    // token 的密钥
                    .sign(algorithm);
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * 根据token获取userId
     */
    public static String getUserId(String token) {
        try {
            String uid = JWT.decode(token).getAudience().get(0);
            return uid;
        } catch (JWTDecodeException e) {
            return null;
        }
    }

    /**
     * 校验token
     */
    public static boolean checkSign(String token) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(SECRET);
            JWTVerifier verifier = JWT.require(algorithm)
                    // .withClaim("username", username)
                    .build();
            DecodedJWT jwt = verifier.verify(token);
            return true;
        } catch (JWTVerificationException exception) {
            throw new RuntimeException("token 无效，请重新获取");
        }
    }
}
