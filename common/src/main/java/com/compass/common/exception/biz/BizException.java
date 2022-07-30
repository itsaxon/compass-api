package com.compass.common.exception.biz;

/**
 * 业务异常
 *
 * @author liushuozhen
 * @date 2022/07/21
 */
public class BizException extends BaseException {

    /**
     * 业务异常
     *
     * @param responseEnum 响应枚举
     * @param msg          信息
     */
    public BizException(BizResponse responseEnum, String msg) {
        super(responseEnum, msg);
    }

}

