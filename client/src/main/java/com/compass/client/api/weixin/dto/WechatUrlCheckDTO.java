package com.compass.client.api.weixin.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * URL验证请求
 *
 * @author itsaxon
 * @date 2022/08/11
 */
@Data
public class WechatUrlCheckDTO {

    /**
     * 企微加密签名
     */
    @ApiModelProperty(value = "企微加密签名")
    String msgSignature;

    /**
     * 时间戳
     */
    @ApiModelProperty(value = "时间戳")
    String timestamp;

    /**
     * 随机数
     */
    @ApiModelProperty(value = "随机数")
    String nonce;

    /**
     * 包含消息内容的加密字符串
     */
    @ApiModelProperty(value = "包含消息内容的加密字符串")
    String echostr;

}
