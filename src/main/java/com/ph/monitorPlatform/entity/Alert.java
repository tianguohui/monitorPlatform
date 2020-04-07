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
 * @since 2020-02-28
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("t_alert")
public class Alert implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * ??id
     */
    private BigDecimal eventId;

    /**
     * ????id
     */
    private BigDecimal alertId;

    /**
     * ????id
     */
    private String srcEventId;

    /**
     * ????id
     */
    private BigDecimal alertCode;

    /**
     * ??id
     */
    private BigDecimal nodeId;

    /**
     * ????????','??????????
     */
    private String domains;

    /**
     * ?????????','???????????
     */
    private String nodeTypes;

    /**
     * ????
     */
    private String devName;

    /**
     * ????
     */
    private String appName;

    /**
     * ????id
     */
    private BigDecimal relatedNodeId;

    /**
     * ?????
     */
    private String instance;

    /**
     * ?????2
     */
    private String instance2;

    /**
     * ??KPI?
     */
    private String kpiValue;

    /**
     * ??KPI Code
     */
    private BigDecimal kpiCode;

    /**
     * ??KPI??
     */
    private String kpiUnit;

    /**
     * 0  : INFO
     * 1  : WARNING
     * 2  : MINOR
     * 3  : MAJOR
     * 4  : CRITICAL
     */
    private BigDecimal severity;

    /**
     * ????
     */
    private String title;

    /**
     * ????
     */
    private String message;

    /**
     * ??????
     */
    private LocalDateTime arisingTime;

    /**
     * ??????
     */
    private LocalDateTime receiveTime;

    /**
     * ????id
     */
    private String agentId;

    /**
     * ??????
     */
    private BigDecimal count;

    /**
     * 待处理告警：0    新产生
     * 已确认告警：5    已确认
     * 已前转告警：10   处理中
     * 已解决告警：20   已处理
     * 已忽略告警：30   已忽略
     */
    private BigDecimal state;

    /**
     * ????id
     */
    private BigDecimal causeAlertId;

    /**
     * ???????
     */
    private LocalDateTime firstArisingTime;

    /**
     * ???????
     */
    private BigDecimal oldSeverity;

    /**
     * ??????
     */
    private LocalDateTime updateTime;

    /**
     * ???????
     */
    private LocalDateTime openTime;

    /**
     * ??????
     */
    private LocalDateTime closeTime;

    /**
     * ????????
     */
    private String openBy;

    /**
     * ???????
     */
    private String closeBy;

    /**
     * ????????
     */
    private String owner;

    /**
     * ????
     */
    private String orderId;

    /**
     * ????
     */
    private String orderStatus;

    /**
     * ????
     */
    private String comments;

    private BigDecimal incidentId;

    private String tags;

    private LocalDateTime claimTime;

    private String claimBy;

    private LocalDateTime upgradeTime;

    private BigDecimal upgradeCount;

    private BigDecimal activeState;

    private Boolean filtered;

    private Boolean related;

    private Integer knowledgeId;

    /**
     * agentName
     */
    private String agentName;


}
