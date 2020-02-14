package com.ljx.mall.common.api;

/**
 * ClassName: ResultCode
 * Description:TODO
 * date: 2020-02-13 13:00
 *
 * @author JianXin-Lee
 * @version 1.0
 * @since JDK 1.8
 */
public enum ResultCode implements IErrorCode {
    SUCCESS(200, "服务器已成功处理了请求"),
    FAILED(500, "服务器内部错误，无法完成请求"),
    VALIDATE_FAILED(404, "参数检验失败,未找到服务器找不到请求的网页"),
    UNAUTHORIZED(401, "未授权请求没有进行身份验证或验证未通过"),
    FORBIDDEN(403, "没有相关权限,禁止访问服务器拒绝此请求");;

    private long code;
    private String message;

    private ResultCode(long code, String message){
        this.code = code;
        this.message = message;
    }

    @Override
    public long getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
