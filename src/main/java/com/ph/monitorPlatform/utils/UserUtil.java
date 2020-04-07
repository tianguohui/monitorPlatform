package com.ph.monitorPlatform.utils;

import com.auth0.jwt.exceptions.JWTCreationException;
import com.ph.monitorPlatform.entity.User;
import com.ph.monitorPlatform.mapper.UserMapper;
import com.ph.monitorPlatform.utils.exception.IllegalUserException;
import com.ph.monitorPlatform.utils.exception.InvalidTokenException;
import com.ph.monitorPlatform.utils.jwt.JwtHelper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;

@Component
@Slf4j
public class UserUtil {

    @Autowired
    HttpServletRequest httpServletRequest;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private JwtHelper jwtHelper;

    public String createAccessToken(String userId) {
        try {
            return jwtHelper.createToken(userId);
        } catch (JWTCreationException e) {
            log.error("error：{}", e);
        }
        throw new InvalidTokenException("token 创建失败");
    }

    public User getCurrentUser() {
        //从token中获取用户信息
        String userId = httpServletRequest.getAttribute("userId").toString();
        User user = userMapper.queryUserByUserId(userId);
        if (StringUtils.isEmpty(user)) {
            throw new IllegalUserException("非法用户");
        }
        return user;
    }
}
