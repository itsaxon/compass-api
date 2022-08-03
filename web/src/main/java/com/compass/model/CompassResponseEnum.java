package com.compass.model;

import com.compass.common.exception.biz.BizResponse;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 业务返回枚举
 *
 * @author itsaxon
 * @date 2022/08/03
 */
@Getter
@AllArgsConstructor
public enum CompassResponseEnum implements BizResponse {

    /**
     * 成功
     */
    SUCCESS(10000, "SUCCESS"),
    /**
     * 错误
     */
    ERROR(666666, "ERROR"),
    /**
     * 坏请求
     */
    BAD_REQUEST(400, "请求的参数个数或格式不符合要求"),
    /**
     * 无效参数
     */
    INVALID_ARGUMENT(400, "请求的参数不正确"),
    /**
     * 未经授权
     */
    UNAUTHORIZED(401, "无权访问"),
    /**
     * 被禁止
     */
    FORBIDDEN(403, "禁止访问"),
    /**
     * 没有找到
     */
    NOT_FOUND(404, "请求的地址不正确"),
    /**
     * 方法不允许
     */
    METHOD_NOT_ALLOWED(405, "不允许的请求方法"),
    /**
     * 不能接受
     */
    NOT_ACCEPTABLE(406, "不接受的请求"),
    /**
     * 冲突
     */
    CONFLICT(409, "资源冲突"),
    /**
     * 不支持媒体类型
     */
    UNSUPPORTED_MEDIA_TYPE(415, "不支持的Media Type"),
    /**
     * 内部错误
     */
    INTERNAL_ERROR(500, "服务器内部错误"),
    /**
     * 服务不可用
     */
    SERVICE_UNAVAILABLE(503, "服务不可用"),
    /**
     * 网关超时
     */
    GATEWAY_TIMEOUT(504, "请求服务超时");

    /**
     * 状态
     */
    private final int bizCode;
    /**
     * 消息
     */
    private final String bizMsg;

}
