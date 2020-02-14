package com.ljx.mall.admin.ums.dto;

import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotEmpty;

/**
 * ClassName: UmsAdminLoginParam
 * Description:TODO
 * date: 2020-02-13 0:13
 *
 * @author JianXin-Lee
 * @version 1.0
 * @since JDK 1.8
 */
public class UmsAdminLoginParam {
    @ApiModelProperty(value = "用户名", required = true)
    @NotEmpty(message = "用户名不能为空")
    private String username;
    @ApiModelProperty(value = "密码", required = true)
    @NotEmpty(message = "密码不能为空")
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
