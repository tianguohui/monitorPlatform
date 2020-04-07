package com.ph.monitorPlatform.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class LoginReturn implements Serializable {
    private String token;
    private String planCode;

    public LoginReturn() {
    }

    public LoginReturn(String token, String planCode) {
        this.token = token;
        this.planCode = planCode;
    }
}
