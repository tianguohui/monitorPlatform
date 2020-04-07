package com.ph.monitorPlatform.controller;


import com.ph.monitorPlatform.dto.Login;
import com.ph.monitorPlatform.entity.User;
import com.ph.monitorPlatform.service.IUserService;
import com.ph.monitorPlatform.utils.JsonResult;
import com.ph.monitorPlatform.utils.UserUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author zuohongyu
 * @since 2020-02-27
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private IUserService userService;
    @Autowired
    private UserUtil userUtil;

    @PostMapping("/login")
    @ResponseBody
    public JsonResult<User> login(@RequestBody Login login, HttpServletRequest request) {
        return userService.login(login,request);
    }



    @PostMapping("/test")
    @ResponseBody
    public JsonResult<User> test() {
        User user = userUtil.getCurrentUser();
        return JsonResult.success(user);
    }

}

