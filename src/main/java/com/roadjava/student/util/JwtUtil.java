package com.roadjava.student.util;

import com.alibaba.fastjson.JSON;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.AlgorithmMismatchException;
import com.auth0.jwt.exceptions.InvalidClaimException;
import com.auth0.jwt.exceptions.SignatureVerificationException;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.roadjava.student.bean.res.Result;
import lombok.extern.slf4j.Slf4j;

import java.util.Calendar;

@Slf4j
public class JwtUtil {
    private static final String SECRET="roadjava.com";
    public static <T> String getToken(T t){
//        定义过期时间
        Calendar instance= Calendar.getInstance();
        instance.add(Calendar.MONTH,1);

        JWTCreator.Builder builder = JWT.create()
                .withClaim(t.getClass().getSimpleName(), JSON.toJSONString(t));
        String token= builder.withExpiresAt(instance.getTime())
                .sign(Algorithm.HMAC256(SECRET));

        return token;
    }

//    用来校验token是否合法
    public static Result<DecodedJWT> verify(String tokenToVerify) {
        String errMsg;
        try{
            DecodedJWT decodeJWT=JWT.require(Algorithm.HMAC256(SECRET)).build().verify(tokenToVerify);
            return Result.buildSuccess(decodeJWT);
        }catch (AlgorithmMismatchException e){
            errMsg="算法不匹配";
            log.error(errMsg,e);
        }catch (SignatureVerificationException e){
            errMsg="签名不匹配";
            log.error(errMsg,e);
        }catch (TokenExpiredException e){
            errMsg="令牌失效";
            log.error(errMsg,e);
        }catch (InvalidClaimException e){
            errMsg="声明无效";
            log.error(errMsg,e);
        }catch (Exception e){
            errMsg="校验令牌失败";
            log.error(errMsg,e);
        }
        return Result.buildFailure(errMsg);
    }

    public static <T> T parse(DecodedJWT data, Class<T> clz) {
        Claim claim=data.getClaim(clz.getSimpleName());
        System.out.println(claim);
        System.out.println(claim);
        if (claim==null){
            return null;
        }
        return JSON.parseObject(claim.asString(),clz);
    }
}
