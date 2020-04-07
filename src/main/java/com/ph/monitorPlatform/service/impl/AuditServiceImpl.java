package com.ph.monitorPlatform.service.impl;

import com.ph.monitorPlatform.entity.Audit;
import com.ph.monitorPlatform.mapper.AuditMapper;
import com.ph.monitorPlatform.service.IAuditService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zuohongyu
 * @since 2020-02-27
 */
@Service
public class AuditServiceImpl extends ServiceImpl<AuditMapper, Audit> implements IAuditService {

}
