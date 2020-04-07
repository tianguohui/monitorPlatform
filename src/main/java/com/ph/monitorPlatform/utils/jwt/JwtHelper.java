package com.ph.monitorPlatform.utils.jwt;

import com.alibaba.fastjson.JSONObject;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

@Slf4j
@Component
public class JwtHelper {

    @Autowired
    private JwtParam jwtParam;

    public String createToken(String userId) {
        Date nowDate = new Date();
        //过期时间
        Date expireDate = new Date(nowDate.getTime() + jwtParam.getExpire() * 1000);
        String token = null;
        JSONObject obj = new JSONObject();
        obj.put("x-hasura-default-role", "admin");
        obj.put("x-hasura-allowed-roles", new String[]{"editor", "user", "admin"});

        try {
            Algorithm algorithmHS = Algorithm.HMAC256(jwtParam.getSecret());
            token = JWT.create()
                    .withIssuer("auth0")
                    .withIssuedAt(nowDate)
                    .withSubject("1234567890")
                    .withClaim("userId", userId)
                    .withClaim("https://hasura.io/jwt/claims", obj.toJSONString())
                    .withExpiresAt(expireDate)
                    .sign(algorithmHS);
        } catch (JWTCreationException e) {
            log.error("error：{}", e);
        }
        return token;
    }

    public boolean verifyToken(String token) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(jwtParam.getSecret());
            JWTVerifier verifier = JWT.require(algorithm)
                    .withIssuer("auth0")
                    .build(); //Reusable verifier instance
            DecodedJWT jwt = verifier.verify(token);
            return jwt.getExpiresAt().before(new Date());
        } catch (JWTVerificationException e) {
            log.error("error：{}", e.getMessage());
            return false;
        }
    }

    public DecodedJWT decodeToken(String token) {
        try {
            DecodedJWT jwt = JWT.decode(token);
            return jwt;
        } catch (JWTDecodeException e) {
            log.error("error：{}", e.getMessage());
            return null;
        }
    }

}
