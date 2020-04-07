package com.ph.monitorPlatform.mapper;

import com.ph.monitorPlatform.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author zuohongyu
 * @since 2020-02-27
 */
public interface UserMapper extends BaseMapper<User> {

    User queryUserByUserId(String userId);

    void updateByUserId(User updateUser);
}
