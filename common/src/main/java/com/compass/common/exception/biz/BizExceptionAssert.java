package com.compass.common.exception.biz;

/**
 * 业务异常断言
 *
 * @author liushuozhen
 * @date 2022/07/21
 */
public interface BizExceptionAssert extends BizResponse, ExceptionAssert {

    /**
     * 创建异常
     *
     * @param msg 异常描述内容
     * @return BizException
     * @see BizException
     */
    @Override
    default BizException newException(String msg) {
        return new BizException(this, msg);
    }

}
