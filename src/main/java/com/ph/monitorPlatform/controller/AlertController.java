package com.ph.monitorPlatform.controller;


import com.ph.monitorPlatform.service.IAlertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author zuohongyu
 * @since 2020-02-28
 */
@RestController
@RequestMapping("/alert")
public class AlertController {

    @Autowired
    private IAlertService alertService;

    @PostMapping("/exportAlert")
    @ResponseBody
    public void exportAlert(@RequestBody List<BigDecimal> alertIds, HttpServletResponse response) throws IOException {
        alertService.exportAlert(alertIds, response);

    }

}

