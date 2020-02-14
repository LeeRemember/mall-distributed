package com.ljx.mall.ums.service.impl;

import com.ljx.mall.ums.entity.AdminLoginLog;
import com.ljx.mall.ums.mapper.AdminLoginLogMapper;
import com.ljx.mall.ums.service.IAdminLoginLogService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 后台用户登录日志表 服务实现类
 * </p>
 *
 * @author Ljx
 * @since 2020-02-12
 */
@Service
public class AdminLoginLogServiceImpl extends ServiceImpl<AdminLoginLogMapper, AdminLoginLog> implements IAdminLoginLogService {

}
