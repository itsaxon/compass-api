package com.compass.client.api.weixin.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 微信配置响应
 *
 * @author itsaxon
 * @date 2022/08/11
 */
@Data
public class WechatConfigDTO {

    /**
     * 随机获取 用于生成签名
     */
    @ApiModelProperty("随机获取 用于生成签名")
    private String token;


    /**
     * 随机获取 用于消息体加密
     */
    @ApiModelProperty("随机获取 用于消息体加密")
    private String encodingAesKey;

    /**
     * 接收编号
     */
    @ApiModelProperty("接收编号")
    private String receiveId;

}
