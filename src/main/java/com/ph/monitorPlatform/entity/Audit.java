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
@TableName("t_audit")
public class Audit implements Serializable {

    private static final long serialVersionUID=1L;

    private BigDecimal auditId;

    private String userId;

    private String clientIp;

    private LocalDateTime operationTime;

    private String moduleName;

    private String moduleId;

    private String actionname;

    private String content;

    public Audit() {
    }

    public Audit(String userId, String clientIp, LocalDateTime operationTime, String moduleName, String moduleId, String actionname, String content) {
        this.userId = userId;
        this.clientIp = clientIp;
        this.operationTime = operationTime;
        this.moduleName = moduleName;
        this.moduleId = moduleId;
        this.actionname = actionname;
        this.content = content;
    }
}
