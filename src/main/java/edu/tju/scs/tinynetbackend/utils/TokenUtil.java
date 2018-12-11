package edu.tju.scs.tinynetbackend.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import lombok.extern.slf4j.Slf4j;

import java.util.Date;

/**
 * @Author: liyuze
 * @Description:
 * @Date: Created in 21:55 18/12/10.
 */
@Slf4j
public class TokenUtil {

    private final static int DURATION_TIME = 9000000;

    public static String getToken(String secret, String aud){
        Algorithm algorithm = Algorithm.HMAC256(secret);
        return JWT.create()
                .withIssuer("tiny_net")
                .withAudience(aud)
//                .withExpiresAt(new Date(System.currentTimeMillis() + DURATION_TIME))
                .sign(algorithm);

    }

    public static boolean parseToken(String secret, String aud, String tokenString){
        Algorithm algorithm = Algorithm.HMAC256(secret);
        JWTVerifier verifier = JWT.require(algorithm)
                                .withIssuer("tiny_net")
                                .withAudience(aud).build();
        try{
            verifier.verify(tokenString);
            return true;
        } catch (Exception e){
            return false;
        }
    }



    public static void main(String[] args){
        Algorithm algorithm = Algorithm.HMAC256("secret");
        String token = JWT.create()
                .withIssuer("auth0")
                .sign(algorithm);
        System.out.println(token);
        Algorithm algorithm1 = Algorithm.HMAC256("secret");
        JWTVerifier verifier = JWT.require(algorithm1)
                .withIssuer("auth0")
                .build(); //Reusable verifier instance
        DecodedJWT jwt = verifier.verify(token);
        System.out.println(jwt.getHeader());
        System.out.println(jwt.getPayload());
        System.out.println(jwt.getSignature());

        String a = getToken("lee","tju");
        System.out.println(parseToken("lee","tju",a));


    }
}
