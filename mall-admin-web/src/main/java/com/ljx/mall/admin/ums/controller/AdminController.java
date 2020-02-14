package com.ljx.mall.admin.ums.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.ljx.mall.admin.ums.dto.UmsAdminLoginParam;
import com.ljx.mall.common.api.CommonResult;
import com.ljx.mall.common.util.JwtTokenUtil;
import com.ljx.mall.ums.entity.Admin;
import com.ljx.mall.ums.service.IAdminService;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpRequest;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * ClassName: AdminController
 * Description:TODO
 * date: 2020-02-12 23:17
 *
 * @author JianXin-Lee
 * @version 1.0
 * @since JDK 1.8
 */
@CrossOrigin
@RestController
@RequestMapping("/admin")
public class AdminController {
    private static final Logger LOG = LoggerFactory.getLogger(AdminController.class);
    @Reference
    IAdminService adminService;
    @Value("${jwt.tokenHeader}")
    private String tokenHeader;
    @Value("${jwt.tokenHead}")
    private String tokenHead;

    @ApiOperation("登录以后返回token")
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public CommonResult login(@RequestBody UmsAdminLoginParam umsAdminLoginParam, BindingResult result){
        String username = umsAdminLoginParam.getUsername();
        String password = umsAdminLoginParam.getPassword();
        LOG.debug("执行登录功能:  username = {}, password = {}", username, password);
        HashMap<String, Object> paramMap = new HashMap<>();
        paramMap.put("username", username);
        paramMap.put("password", password);
        String token = adminService.login(paramMap);
        if (token == null){
            LOG.debug("登录失败! --- 用户名或密码错误");
            return CommonResult.validateFailed("用户名或密码错误");
        }

        Map<String, String> tokenMap = new HashMap<>();
        tokenMap.put("token", token);
        tokenMap.put("tokenHead", tokenHead);
        LOG.debug("登录成功! token = {}", token);
        return CommonResult.success(tokenMap);
    }

    @ApiOperation("获取当前登录用户信息")
    @RequestMapping(value = "/info", method = RequestMethod.GET)
    public CommonResult getAdminInfo(HttpServletRequest request){
        //通过 tokenHeader 得到当前用户的 token
        String oldToken = request.getHeader(tokenHeader);
        HashMap<String, Object> paramMap = new HashMap<>();
        paramMap.put("oldToken", oldToken);
        LOG.debug("调用 info -- oldToken = {}", oldToken);

        Admin admin = adminService.getAdminByUsername(paramMap);

        LOG.debug("info 调用 adminService  -- admin = {}", admin);

        Map<String, Object> data = new HashMap<>();
        data.put("username", admin.getUsername());
        data.put("roles", new String[]{"TEST"});
        data.put("icon", admin.getIcon());
        return CommonResult.success(data);
    }


    @ApiOperation(value = "刷新token")
    @RequestMapping(value = "/refreshToken", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult refreshToken(HttpServletRequest request) {
        String token = request.getHeader(tokenHeader);
        String refreshToken = adminService.refreshToken(token);
        if (refreshToken == null) {
            return CommonResult.failed("token已经过期！");
        }
        Map<String, String> tokenMap = new HashMap<>();
        tokenMap.put("token", refreshToken);
        tokenMap.put("tokenHead", tokenHead);
        return CommonResult.success(tokenMap);
    }

}
