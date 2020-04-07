package com.ph.monitorPlatform.service.impl;

import com.alibaba.excel.EasyExcel;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ph.monitorPlatform.dto.AlertExportDto;
import com.ph.monitorPlatform.entity.Alert;
import com.ph.monitorPlatform.mapper.AlertMapper;
import com.ph.monitorPlatform.service.IAlertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.net.URLEncoder;
import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author zuohongyu
 * @since 2020-02-28
 */
@Service
public class AlertServiceImpl extends ServiceImpl<AlertMapper, Alert> implements IAlertService {

    @Autowired
    private AlertMapper alertMapper;

    @Override
    public void exportAlert(List<BigDecimal> alertIds, HttpServletResponse response) throws IOException {
        List<AlertExportDto> alertExportDtos = alertMapper.selectByAlertIds(alertIds);
        alertExportDtos.stream().forEach(a -> {
            //state状态转换
            a.setState(transStateToString(a.getState()));
            //severity状态转换
            a.setSeverity(transSeverityToString(a.getSeverity()));
            //子告警状态转换
            a.setRelated(transRelatedToString(a.getRelated()));
        });
/*        String fileName = "simpleWrite" + System.currentTimeMillis() + ".xlsx";
        // 这里 需要指定写用哪个class去写
        ExcelWriter excelWriter = EasyExcel.write(fileName, AlertExportDto.class).build();
        WriteSheet writeSheet = EasyExcel.writerSheet("模板").build();
        excelWriter.write(alertExportDtos, writeSheet);
        // 千万别忘记finish 会帮忙关闭流
        excelWriter.finish();*/
        exportToExcel(response, alertExportDtos, "历史告警");

    }

    public String transStateToString(String state) {
        String stateString;
        switch (state) {
            case "0":
                stateString = "新产生";
                break;
            case "5":
                stateString = "已确认";
                break;
            case "10":
                stateString = "处理中";
                break;
            case "20":
                stateString = "已处理";
                break;
            case "30":
                stateString = "已忽略";
                break;
            default:
                stateString = "unknown";
        }
        return stateString;
    }

    public String transSeverityToString(String severity) {
        String severityString;
        switch (severity) {
            case "0":
                severityString = "INFO";
                break;
            case "1":
                severityString = "WARNING";
                break;
            case "2":
                severityString = "MINOR";
                break;
            case "3":
                severityString = "MAJOR";
                break;
            case "4":
                severityString = "CRITICAL";
                break;
            default:
                severityString = "unknown";
        }
        return severityString;
    }

    public String transRelatedToString(String related) {
        String relatedString;
        switch (related) {
            case "f":
                relatedString = "false";
                break;
            case "t":
                relatedString = "true";
                break;
            default:
                relatedString = "undefined";
        }
        return relatedString;
    }

    public void exportToExcel(HttpServletResponse response, List exportData, String excelFileName) throws IOException {
        response.setContentType("application/vnd.ms-excel");
        response.setCharacterEncoding("utf-8");
        // 这里URLEncoder.encode可以防止中文乱码 当然和easyexcel没有关系
        String fileName = URLEncoder.encode(excelFileName, "UTF-8");
        response.setHeader("Content-disposition", "attachment;filename=" + fileName + ".xlsx");
        EasyExcel.write(response.getOutputStream(), AlertExportDto.class).sheet("data").doWrite(exportData);
    }
}
