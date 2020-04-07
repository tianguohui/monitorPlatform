package com.ph.monitorPlatform.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class Login implements Serializable {
    private String userId;
    private String encryptedPwd;
}
