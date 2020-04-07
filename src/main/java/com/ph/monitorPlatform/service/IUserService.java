package com.ph.monitorPlatform.service;

import com.ph.monitorPlatform.dto.Login;
import com.ph.monitorPlatform.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;
import com.ph.monitorPlatform.utils.JsonResult;

import javax.servlet.http.HttpServletRequest;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author zuohongyu
 * @since 2020-02-27
 */
public interface IUserService extends IService<User> {

    JsonResult<User> login(Login login, HttpServletRequest request);

    User findUserByUserId(String userId);

}
