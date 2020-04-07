package com.ph.monitorPlatform.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ph.monitorPlatform.dto.Login;
import com.ph.monitorPlatform.entity.Audit;
import com.ph.monitorPlatform.entity.User;
import com.ph.monitorPlatform.mapper.AuditMapper;
import com.ph.monitorPlatform.mapper.UserMapper;
import com.ph.monitorPlatform.service.IUserService;
import com.ph.monitorPlatform.utils.JsonResult;
import com.ph.monitorPlatform.utils.UserUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static com.ph.monitorPlatform.utils.IpUtil.getIpAddress;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author zuohongyu
 * @since 2020-02-27
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserUtil userUtil;
    @Autowired
    private AuditMapper auditMapper;


    @Override
    public User findUserByUserId(String userId) {
        return userMapper.queryUserByUserId(userId);
    }


    @Override
    public JsonResult login(Login login, HttpServletRequest request) {
        User user = userMapper.queryUserByUserId(login.getUserId());
        if (user == null) {
            return JsonResult.failMessage("用户不存在");
        }
        if (!user.getEncryptedPwd().equals(login.getEncryptedPwd())) {
            return JsonResult.failMessage("密码错误");
        }
        String accessToken = userUtil.createAccessToken(login.getUserId());
        //获取用户登录ip
        String userIp = getIpAddress(request);
        LocalDateTime current = LocalDateTime.now();
        //更新用户表 lastlogin time  /lastlogin ip   /loginTimes
        User updateUser = new User();
        updateUser.setUserId(user.getUserId());
        updateUser.setLastLoginIp(userIp);
        updateUser.setLastLoginTime(current);
        updateUser.setLoginTimes(user.getLoginTimes().add(new BigDecimal(1)));
        userMapper.updateByUserId(updateUser);
        //todo 返回组织机构信息（延期）
        //记录登录日志
        Audit loginLog = new Audit(user.getUserId(), userIp, current, "统一用户管理", "userManager",
                "用户登录", "用户" + user.getUserId() + "登陆了viportal系统");
        auditMapper.insert(loginLog);
        return JsonResult.success(accessToken);
    }

}
