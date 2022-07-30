package com.compass.common.exception.biz;


/**
 * 业务响应
 *
 * @author liushuozhen
 * @date 2022/07/21
 */
public interface BizResponse {

    /**
     * 得到业务代码
     *
     * @return int
     */
    int getBizCode();

    /**
     * 得到业务信息
     *
     * @return {@link String}
     */
    String getBizMsg();

}
