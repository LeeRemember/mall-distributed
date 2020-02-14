package com.ljx.mall.ums.service;

import com.ljx.mall.ums.entity.Admin;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.HashMap;

/**
 * <p>
 * 后台用户表 服务类
 * </p>
 *
 * @author Ljx
 * @since 2020-02-12
 */
public interface IAdminService extends IService<Admin> {

    /**
     * 登录功能
     * @param paramMap 封装有 username password 参数
     * @return 生成的JWT的token
     */
    String login(HashMap<String, Object> paramMap);

    Admin getAdminByUsername(HashMap<String, Object> paramMap);

    String refreshToken(String token);
}
