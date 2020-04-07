package com.ph.monitorPlatform.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ph.monitorPlatform.dto.AlertExportDto;
import com.ph.monitorPlatform.entity.Alert;

import java.math.BigDecimal;
import java.util.List;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author zuohongyu
 * @since 2020-02-28
 */
public interface AlertMapper extends BaseMapper<Alert> {

    List<AlertExportDto> selectByAlertIds(List<BigDecimal> alertIds);
}
