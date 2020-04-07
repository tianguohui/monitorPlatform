package com.ph.monitorPlatform.entity;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.TableName;
import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author zuohongyu
 * @since 2020-02-27
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("t_user")
public class User implements Serializable {

    private static final long serialVersionUID=1L;

    private String userId;

    private String staffName;

    private String departmentCode;

    private String jobTitle;

    private String phone;

    private String mobilePhone;

    private String email;

    private String note;

    private String encryptedPwd;

    private String authMethod;

    private LocalDateTime lastLoginTime;

    private String lastLoginIp;

    private BigDecimal loginTimes;

    private String creator;

    private LocalDateTime createdate;

    private String updator;

    private LocalDateTime updatedate;

    private String lastDesktop;

    private BigDecimal userType;

    private BigDecimal flag;


}
