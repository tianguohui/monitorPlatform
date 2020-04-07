package com.ph.monitorPlatform.service;

import com.ph.monitorPlatform.entity.Alert;
import com.baomidou.mybatisplus.extension.service.IService;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zuohongyu
 * @since 2020-02-28
 */
public interface IAlertService extends IService<Alert> {

    void exportAlert(List<BigDecimal> alertIds, HttpServletResponse response) throws IOException;
}
