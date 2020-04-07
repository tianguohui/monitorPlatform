package com.ph.monitorPlatform.utils.jwt;

import com.alibaba.druid.util.StringUtils;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.ph.monitorPlatform.utils.exception.InvalidTokenException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class TokenInterceptor extends HandlerInterceptorAdapter {
    @Autowired
    private JwtHelper jwtHelper;

    @Autowired
    private JwtParam jwtParam;

    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response,
                             Object handler) {
        // Token 验证
        String bearerToken = request.getHeader(jwtParam.getHeader());
        if (StringUtils.isEmpty(bearerToken)) {
            throw new InvalidTokenException("token 不能为空");
        }
        String token = bearerToken.substring(7);
        if (jwtHelper.verifyToken(token)) {
            throw new InvalidTokenException("token 失效，请重新登录");
        }
        DecodedJWT jwt = jwtHelper.decodeToken(token);
        //设置 userId 用户账户
        request.setAttribute("userId", jwt.getClaim("userId").asString());
        return true;
    }

}
