package com.ph.monitorPlatform.dto;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.format.NumberFormat;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class AlertExportDto {
    @NumberFormat
    @ExcelProperty(value = "告警编号", index = 0)
    private BigDecimal alertId;

    @ExcelProperty(value = "状态", index = 1)
    private String state;

    @ExcelProperty(value = "CI名称", index = 2)
    private String devName;

    @ExcelProperty(value = "应用名称", index = 3)
    private String appName;

    @ExcelProperty(value = "级别", index = 4)
    private String severity;

    @ExcelProperty(value = "消息内容", index = 5)
    private String message;

    @ExcelProperty(value = "首次告警时间", index = 6)
    private Date firstArisingTime;

    @ExcelProperty(value = "最近告警时间", index = 7)
    private Date arisingTime;

    @ExcelProperty(value = "次数", index = 8)
    private BigDecimal count;

    @ExcelProperty(value = "采集系统", index = 9)
    private String agentId;

    @ExcelProperty(value = "关闭时间", index = 10)
    private Date closeTime;

    @ExcelProperty(value = "关闭人", index = 11)
    private String closeBy;
    //工单编号（不确定是此字段）
    @ExcelProperty(value = "工单编号", index = 12)
    private String orderId;
    //    private BigDecimal alertId;
    @ExcelProperty(value = "子告警", index = 13)
    private String related;

    @ExcelProperty(value = "接入行", index = 14)
    private String instance;

    @ExcelProperty(value = "交易渠道", index = 15)
    private String instance2;

}
