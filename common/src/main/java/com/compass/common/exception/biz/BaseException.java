package com.compass.common.exception.biz;

import cn.hutool.core.util.StrUtil;

/**
 * 基类异常
 *
 * @author liushuozhen
 * @date 2022/07/21
 */
public abstract class BaseException extends RuntimeException {

    private final int code;

    private final String msg;

    public BaseException(BizResponse responseEnum, String message) {
        // 自定义异常描述为空 使用自定义文案
        super(StrUtil.isNotBlank(message) ? message : responseEnum.getBizMsg());
        code = responseEnum.getBizCode();
        msg = StrUtil.isNotEmpty(message) ? message : responseEnum.getBizMsg();
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    @Override
    public String toString() {
        return "BaseException{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                '}';
    }
}
