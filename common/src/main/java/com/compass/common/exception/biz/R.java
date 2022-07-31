package com.compass.common.exception.biz;

/**
 * 业务执行异常枚举
 *
 * @author liushuozhen
 * @date 2022/07/31
 */
public enum R implements BizExceptionAssert {

    /**
     * 业务异常
     */
    BIZ_ERROR(666666, "业务异常"),

    /**
     * 数据异常
     */
    DB_ERROR(777777, "数据异常"),

    /**
     * 短信异常
     */
    MSG_ERROR(60002, "短信异常");

    /**
     * 返回码
     */
    private final int bizCode;

    /**
     * 返回消息
     */
    private final String bizMsg;

    R(int bizCode, String bizMsg) {
        this.bizCode = bizCode;
        this.bizMsg = bizMsg;
    }

    @Override
    public int getBizCode() {
        return bizCode;
    }

    @Override
    public String getBizMsg() {
        return bizMsg;
    }
}
