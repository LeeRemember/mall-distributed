package com.ljx.mall.ums.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ljx.mall.common.util.JwtTokenUtil;
import com.ljx.mall.ums.entity.Admin;
import com.ljx.mall.ums.mapper.AdminMapper;
import com.ljx.mall.ums.service.IAdminService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.DigestUtils;

import java.util.HashMap;

/**
 * <p>
 * 后台用户表 服务实现类
 * </p>
 *
 * @author Ljx
 * @since 2020-02-12
 */
@Component
@Service
public class AdminServiceImpl extends ServiceImpl<AdminMapper, Admin> implements IAdminService {
    private static final Logger LOG = LoggerFactory.getLogger(AdminServiceImpl.class);
    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    @Autowired
    private AdminMapper adminMapper;

    @Override
    public String login(HashMap<String, Object> paramMap) {
        String token = null;
        String username = (String)paramMap.get("username");
        String password = (String)paramMap.get("password");

        LOG.debug("调用AdminService -- login 方法");

        String md5Password = DigestUtils.md5DigestAsHex(password.getBytes());

        QueryWrapper<Admin> wrapper = new QueryWrapper<Admin>()
                .eq("username",username)
                .eq("password",md5Password);

        Admin admin = adminMapper.selectOne(wrapper);
        if (admin == null){
            return null;
        }
        token = jwtTokenUtil.generateToken(admin);

        return token;
    }

    @Override
    public Admin getAdminByUsername(HashMap<String, Object> paramMap) {
        String oldToken = (String)paramMap.get("oldToken");
        String username = jwtTokenUtil.getUserNameFromToken(oldToken);

        LOG.debug("调用AdminService -- getAdminByUsername 方法  username = {}", username);

        QueryWrapper<Admin> wrapper = new QueryWrapper<Admin>().eq("username",username);
        Admin admin = adminMapper.selectOne(wrapper);

        if (admin == null){
            return null;
        }

        return admin;
    }

    @Override
    public String refreshToken(String token) {
        return jwtTokenUtil.refreshHeadToken(token);
    }
}
